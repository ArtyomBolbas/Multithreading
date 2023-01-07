package org.example.pdf_lessons.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadExecutorExample {

    public static void main(String[] args) {

//        just for example
//        ExecutorService executor1 = Executors.newSingleThreadExecutor();
//        ExecutorService executor2 = Executors.newFixedThreadPool(10);
//        ExecutorService executor3 = Executors.newScheduledThreadPool(10);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            String threadName = Thread.currentThread().getName();
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadExecutorExample.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Hello from " + threadName);
        });

        executor.execute(() -> {
            String threadName = Thread.currentThread().getName();

            System.out.println("Hello again from " + threadName);
        });

        executor.shutdown();
    }

}
