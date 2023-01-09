package org.example.yuriy_tkach_youtube.concurrency_1;

import java.util.concurrent.locks.ReentrantLock;

import static org.example.yuriy_tkach_youtube.concurrency_1.Transfer.transfer;

public class Operation {

    public static void main(String[] args) {
        final Account acc1 = new Account(1000, new ReentrantLock());
        final Account acc2 = new Account(2000, new ReentrantLock());



        new Thread(() -> transfer(acc1, "acc1", acc2, "acc2", 500)).start();
//        new Thread(() -> transfer(acc2, "acc2", acc1, "acc1", 300)).start();
//        new Thread(() -> transfer(acc1, "acc1", acc2, "acc2", 500)).start();
//        new Thread(() -> transfer(acc2, "acc2", acc1, "acc1", 300)).start();
//        new Thread(() -> transfer(acc1, "acc1", acc2, "acc2", 500)).start();
//        new Thread(() -> transfer(acc2, "acc2", acc1, "acc1", 300)).start();
//        new Thread(() -> transfer(acc1, "acc1", acc2, "acc2", 500)).start();
        transfer(acc2, "acc2", acc1, "acc1", 300);

//        Callable
//        Future

    }

}
