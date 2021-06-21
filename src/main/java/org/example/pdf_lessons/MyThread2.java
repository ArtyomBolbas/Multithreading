package org.example.pdf_lessons;

import java.util.Random;

public class MyThread2 extends Thread {

    private int value;

    public MyThread2(int value) {
        this.value = value;
    }

    @Override
    public void run() {
//        while(this.value >= 0) {
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
//        }
    }

}

class RunnerMyThread2 {

    public static void main(String[] args) {
        int v = (new Random()).nextInt(10);
        MyThread2 t2 = new MyThread2(v);
        t2.setDaemon(true);
        v = (new Random()).nextInt(10);
        MyThread2 t3 = new MyThread2(v);
        t3.setDaemon(true);
        t2.start();
        t3.start();
//        while(t2.isAlive() || t3.isAlive()) {
//        }

        try {
//            Thread.sleep(5000);
            t2.join();
            t3.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}
