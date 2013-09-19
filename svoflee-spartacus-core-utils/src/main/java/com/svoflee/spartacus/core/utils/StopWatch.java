
package com.svoflee.spartacus.core.utils;

/**
 * StopWatch 一个毫秒级的简单StopWatch
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class StopWatch {

    private long startTime;

    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    public long getMillis() {
        return System.currentTimeMillis() - startTime;
    }

    public void reset() {
        startTime = System.currentTimeMillis();
    }
}
