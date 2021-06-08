package com.mytool.thread;

/**
 * @author duankd
 * @ClassName ExecutorsUtil
 * @date 2021-06-03 10:51:09
 */
public class ExecutorsUtil {
    /**
     * Executors 返回线程池对象的弊端如下：
     *
     * FixedThreadPool 和 SingleThreadExecutor ： 允许请求的队列长度为 Integer.MAX_VALUE,可能堆积大量的请求，从而导致OOM。
     *
     * CachedThreadPool 和 ScheduledThreadPool ： 允许创建的线程数量为 Integer.MAX_VALUE ，可能会创建大量线程，从而导致OOM。
     */
}
