package org.example.yuriy_tkach_youtube.concurrency_1;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransferCallable implements Callable<Boolean> {

    private Account from;
    private Account to;
    private int amount;

    public TransferCallable(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("Before " + Thread.currentThread().getName() + ". Balance of [from] = " + from.getBalance());
        System.out.println("Before " + Thread.currentThread().getName() + ". Balance of [to] = " + to.getBalance());
        Thread.sleep(3000);
        if (from.getLock().tryLock(1, TimeUnit.SECONDS)) {
            try {
                if (from.getBalance() < amount) {
                    Logger.getLogger(Transfer.class.getName()).log(Level.SEVERE, "Insufficient funds");
                    throw new InsufficientFundException("Insufficient funds");
                }

                if (to.getLock().tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        from.withdraw(amount);
                        Thread.sleep(2000);
                        to.deposit(amount);
                    } finally {
                        to.getLock().unlock();
                    }
                } else {
                    to.incFailedTransferCount();
                    return Boolean.FALSE;
                }
            } finally {
                from.getLock().unlock();
            }
        } else {
            from.incFailedTransferCount();
            return Boolean.FALSE;
        }

        System.out.println("After " + Thread.currentThread().getName() + ". Successfully transfer from [from] to [to]. Amount is [" + amount + "]");
        System.out.println("After " + Thread.currentThread().getName() + ". Balance of [from] = " + from.getBalance());
        System.out.println("After " + Thread.currentThread().getName() + ". Balance of [to] = " + to.getBalance());

        return Boolean.TRUE;
    }

}
