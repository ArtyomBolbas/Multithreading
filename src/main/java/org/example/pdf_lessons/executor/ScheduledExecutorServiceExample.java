package org.example.pdf_lessons.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Hello from " + Thread.currentThread().getName());
        ScheduledFuture sf = executor.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
        try {
            System.out.println("The name of the thread is " + Thread.currentThread().getName());
            Thread.currentThread().sleep(7000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ScheduledExecutorServiceExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        sf.cancel(true);

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            //wait 3 seconds for completion
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            //if service is not completed yet
            if (!executor.isTerminated()) {
                executor.shutdownNow();
                System.err.println("Make it to stop");
            }
            System.out.println("shutdown finished");

        }
    }
}


