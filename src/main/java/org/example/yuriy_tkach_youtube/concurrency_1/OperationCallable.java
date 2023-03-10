package org.example.yuriy_tkach_youtube.concurrency_1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class OperationCallable {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        final Account acc1 = new Account(1000, new ReentrantLock());
        final Account acc2 = new Account(2000, new ReentrantLock());

        Runnable task = () -> System.out.println("Amount of failCounter_1 = " + acc1.getFailCounter() + " Amount of failCounter_2 = " + acc2.getFailCounter());

        scheduledExecutor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);


        ExecutorService service = Executors.newFixedThreadPool(3);

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            service.submit(new TransferCallable(acc1, acc2, random.nextInt(400)));
        }

        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
