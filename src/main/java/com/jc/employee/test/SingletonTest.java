package com.jc.employee.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LX
 * @date 2021/4/25
 */
public class SingletonTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 1, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 300; i++) {
            executor.execute(()->{
                SingletonObject singletonObject = SingletonObject.getInstance();
                System.out.println(singletonObject);
            });
        }
        executor.shutdown();
    }
}
