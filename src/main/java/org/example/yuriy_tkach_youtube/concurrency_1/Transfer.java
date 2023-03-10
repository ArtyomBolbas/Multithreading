package org.example.yuriy_tkach_youtube.concurrency_1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transfer {

    public static void transfer(Account accountFrom, String variableName, Account accountTo, String variableName2, int amount) {
        if (accountFrom.getBalance() < amount) {
            Logger.getLogger(Transfer.class.getName()).log(Level.SEVERE, "Insufficient funds");
            throw new InsufficientFundException("Insufficient funds");
        }
        System.out.println("Before " + Thread.currentThread().getName() + ". Balance of [" + variableName + "] = " + accountFrom.getBalance());
        System.out.println("Before " + Thread.currentThread().getName() + ". Balance of [" + variableName2 + "] = " + accountTo.getBalance());
//        Collection
        //HashSet
//        synchronized (accountFrom) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException("InterruptedException ", e);
//            }
//            synchronized (accountTo) {
//                accountFrom.withdraw(amount);
//                accountTo.deposit(amount);
//            }
//        }

        try {


            if (accountFrom.getLock().tryLock(1, TimeUnit.SECONDS)) {
                try {
                    if (accountTo.getLock().tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            accountFrom.withdraw(amount);
                            accountTo.deposit(amount);
                        } finally {
                            accountTo.getLock().unlock();
                        }
                    } else {
                        accountTo.incFailedTransferCount();
                    }
                } finally {
                    accountFrom.getLock().unlock();
                }
            } else {
                accountFrom.incFailedTransferCount();
            }



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("After " + Thread.currentThread().getName() + ". Successfully transfer from [" + variableName + "] to [" + variableName2 + "]. Amount is [" + amount + "]");
        System.out.println("After " + Thread.currentThread().getName() + ". Balance of [" + variableName + "] = " + accountFrom.getBalance());
        System.out.println("After " + Thread.currentThread().getName() + ". Balance of [" + variableName2 + "] = " + accountTo.getBalance());
    }

}
