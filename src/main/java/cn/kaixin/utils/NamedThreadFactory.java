package cn.kaixin.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {

    public static Map<String, Integer> threadNamePrefixCount = new ConcurrentHashMap<>();

    private String threadNamePrefix;

    public NamedThreadFactory(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
        if (!threadNamePrefixCount.containsKey(threadNamePrefix)) {
            threadNamePrefixCount.put(threadNamePrefix, 0);
        }
    }

    @Override
    public Thread newThread(Runnable r) {
        SecurityManager s = System.getSecurityManager();
        ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        AtomicInteger _countOfName = new AtomicInteger(threadNamePrefixCount.get(threadNamePrefix));
        threadNamePrefixCount.put(threadNamePrefix, _countOfName.getAndIncrement());
        Thread t = new Thread(group, r, threadNamePrefix+_countOfName, 0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }

}
