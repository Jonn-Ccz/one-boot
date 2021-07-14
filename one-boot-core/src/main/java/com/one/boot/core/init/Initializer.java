package com.one.boot.core.init;

import org.springframework.context.SmartLifecycle;

/**
 * @version 1.0
 * @Author zcc
 * @Date: 2021/5/12
 * @Description: 初始化.
 */
public abstract class Initializer implements SmartLifecycle {

    boolean running = false;

    public abstract void lockInitialize();

    /**
     * 越小越在前面执行.
     */
    public static final int DEFAULT_PHASE = 10000;

    @Override
    public void start() {
        this.running = true;
        lockInitialize();
    }

    @Override
    public void stop() {
        this.running = false;
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    @Override
    public int getPhase() {
        return DEFAULT_PHASE;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        this.stop();
        callback.run();
    }

}
