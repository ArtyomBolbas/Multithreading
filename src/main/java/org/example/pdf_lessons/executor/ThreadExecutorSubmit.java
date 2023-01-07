package org.example.pdf_lessons.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadExecutorSubmit {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
            String threadName = Thread.currentThread().
                    getName();
            System.out.println("This code is being executed asynchronously in thread " + threadName);
        });
        try {
            //returns null if the task completed successfully
            if (future.get() == null) {
                System.out.println("Success!");
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(ThreadExecutorSubmit.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        executor.shutdown();
    }

}
