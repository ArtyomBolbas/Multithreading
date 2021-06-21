package org.example.pdf_lessons;

import java.util.Random;

public class MyThread3 implements Runnable {

    private int value;

    public MyThread3(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        System.out.println("*** The thread " + Thread.currentThread().getName() + " started with " + this.value);
        while (this.value >= 0) {
            System.out.println("From " + Thread.currentThread().getName() + " value = " + this.value);
            this.value -= 1;
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {

            }
        }
        System.out.println("*** The thread " + Thread.currentThread().getName() + " has finished");
    }

}

class RunnerMyThread3 {

    public static void main(String[] args) {
        int v = (new Random()).nextInt(10);
        Runnable myThread2 = new MyThread3(v);
        Thread t2 = new Thread(myThread2);
        t2.setDaemon(true);
        v = (new Random()).nextInt(10);
        Runnable myThread3 = new MyThread3(v);
        Thread t3 = new Thread(myThread3);
        t3.setDaemon(true);
        t2.start();
        t3.start();
//        while(t2.isAlive() || t3.isAlive()) {
//        }

        try {
//          Thread.sleep(5000);
            t2.join();
            t3.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}
