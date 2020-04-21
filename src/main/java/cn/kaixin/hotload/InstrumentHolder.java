package cn.kaixin.hotload;

import cn.kaixin.utils.logger.Loggers;

import java.lang.instrument.Instrumentation;

/**
 * @author: Yao Shuai
 * @date: 2020/3/23 17:57
 */
public class InstrumentHolder {

    public static Instrumentation instrumentation;

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("Premain is running ， the instrumentation is " + instrumentation.toString());
        InstrumentHolder.instrumentation = instrumentation;
    }

    public static Instrumentation getInstrumentation() {
        if (instrumentation == null) {
            throw new RuntimeException("Instrumentation Not instantiate!");
        }
        return instrumentation;
    }
}
