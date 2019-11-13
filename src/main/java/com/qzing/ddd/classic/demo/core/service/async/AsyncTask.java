package com.qzing.ddd.classic.demo.core.service.async;

@FunctionalInterface
public interface AsyncTask {
    void run() throws Exception;
}