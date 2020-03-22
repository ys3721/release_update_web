package cn.kaixin.hotload;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.instrument.ClassDefinition;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: Yao Shuai
 * @date: 2020/3/14 18:45
 */
public class HotReload {

    public static final String COMPILE_PATH = "H:\\sanguoQunYing\\server\\trunk\\main\\wg_base_libs\\libs\\";

    public void compile(String className, String content) throws URISyntaxException, IllegalAccessException, InstantiationException {
        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> _diagnose = new DiagnosticCollector<>();
        jc.getStandardFileManager(_diagnose, null, Charset.forName("UTF-8"));
        FileManagerImpl fileManager = new FileManagerImpl(jc.getStandardFileManager(_diagnose, null, null));
        boolean _compilePass = jc.getTask(null, fileManager, _diagnose, getCompileOptions(), null, Collections.singleton(new JavaSourceFileObject(className, content))).call();
        if (!_compilePass) {
            for (Diagnostic<? extends JavaFileObject> d : _diagnose.getDiagnostics()) {
                for (String info : d.toString().split("\n|\r")) {
                    System.err.println(info);
                }
            }
            return;
        }
        List<JavaClassFileObject> compiledClassObjects = fileManager.classObjects;


        DynamicClassLoader dynamicClassLoader = new DynamicClassLoader( this.getClass().getClassLoader());
        Class clazz = dynamicClassLoader.loadClass("cn.kaixin.hotload.Hello", compiledClassObjects.get(0));
        Object instance = clazz.newInstance();
        System.out.println(instance);
        try {
            instance.getClass().getDeclaredMethod("hello").invoke(instance);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        HotReload hr = new HotReload();
        try {
            try {
                hr.compile("cn.kaixin.hotload.Hello", "package cn.kaixin.hotload;\n" + "\n" + "public class Hello {\n" + "    public void hello() {\n" + "        System.out.println(1);\n" + "    }\n" + "}");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public class DynamicClassLoader extends URLClassLoader {
        public DynamicClassLoader(ClassLoader parent) {
            super(new URL[0], parent);
        }

        public Class findClassByClassName(String className) throws ClassNotFoundException {
            return this.findClass(className);
        }

        public Class loadClass(String fullName, JavaClassFileObject jco) {
            byte[] classData = jco.getClassData();
            return this.defineClass(fullName, classData, 0, classData.length);
        }
    }



    private class JavaSourceFileObject extends SimpleJavaFileObject {

        String code;

        public JavaSourceFileObject(String name, String code) throws URISyntaxException {
            super(new URI("string:///" + name.replace('.','/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return code;
        }
    }


    private Iterable<String> getCompileOptions() {
        StringBuilder sb = new StringBuilder();
        File file = new File(COMPILE_PATH);
        for (String fileName : file.list()) {
            if (fileName.endsWith(".jar")) {
                sb.append(COMPILE_PATH).append(fileName).append(File.pathSeparatorChar);
            }
        }
        return Arrays.asList("-classpath", sb.toString());
    }


    private class FileManagerImpl extends ForwardingJavaFileManager<JavaFileManager> {

        List<JavaClassFileObject> classObjects;

        public FileManagerImpl(JavaFileManager fileManager) {
            super(fileManager);
            classObjects = new ArrayList<>();
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling)
                throws IOException {
            try {
                JavaClassFileObject classObject = new JavaClassFileObject(className);
                classObjects.add(classObject);
                return classObject;
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException("编译成功后的类名，无法转为URI：" + className, e);
            }
        }

    }

    private class JavaClassFileObject extends SimpleJavaFileObject {

        String name;

        ByteArrayOutputStream byteCode;

        public JavaClassFileObject(String name) throws URISyntaxException {
            super(new URI("bytearr:///" + name.replace('.','/') + Kind.CLASS.extension), Kind.CLASS);
            this.name = name;
        }

        @Override
        public OutputStream openOutputStream() throws IOException {
            byteCode = new ByteArrayOutputStream();
            return byteCode;
        }

        public byte[] getClassData() {
            return byteCode.toByteArray();
        }

    }
}



