package org.example.gerbert_shild;

public class Q {

    private int n;
    private boolean valueSet = false;

    public synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("The exception's type of \"InterruptedException\" is caught");
            }
        }
        System.out.println("got: " + n);
        System.out.println("Thread name is: " + Thread.currentThread().getName() + "; state's: " + Thread.currentThread().getState());
        valueSet = false;
        notify();
        return n;
    }

    public synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("The exception's type of \"InterruptedException\" is caught");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("sent: " + n);
        System.out.println("Thread name is: " + Thread.currentThread().getName() + "; state's: " + Thread.currentThread().getState());
        notify();
    }

}

class Producer implements Runnable {

    private Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;

        while(true) {
            System.out.println("Thread name is: " + Thread.currentThread().getName() + "; state's: " + Thread.currentThread().getState());
            q.put(i++);
        }
    }

}

class Consumer implements Runnable {

    private Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Thread name is: " + Thread.currentThread().getName() + "; state's: " + Thread.currentThread().getState());
            q.get();
        }
    }

}

class PC {

    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);

        System.out.println("If you want to stop this process, you'll need to press CTRL+C.");
    }

}
