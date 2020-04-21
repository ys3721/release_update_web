package cn.kaixin.hotload;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author: Yao Shuai
 * @date: 2020/3/23 20:40
 */
public class ReloadService {

    public void reload( Class<?> theClass, byte[]  theClassFile) throws UnmodifiableClassException, ClassNotFoundException {
        InstrumentHolder.instrumentation.redefineClasses(new ClassDefinition(theClass, theClassFile));
    }
}
