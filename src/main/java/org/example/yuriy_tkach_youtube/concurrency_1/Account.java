package org.example.yuriy_tkach_youtube.concurrency_1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class Account {

    private int balance;
    private Lock lock;
    private final AtomicInteger failCounter = new AtomicInteger(0);

    public Account(int initialBalance, Lock lock) {
        this.balance = initialBalance;
        this.lock = lock;
    }

    public void incFailedTransferCount() {
        failCounter.incrementAndGet();
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public AtomicInteger getFailCounter() {
        return failCounter;
    }

}
