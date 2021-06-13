package org.example;

public class MyThread extends Thread {

    public MyThread() {
        //create nre thread
        super("Demonstration thread");
        System.out.println("Child thread is created: " + this);
        start(); //launch thread
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            System.out.println("Child thread is interrupted.");
        }
        System.out.println("Child thread is terminated.");
    }

}

class RunnerMyThread {

    public static void main(String[] args) {
        new MyThread();

        try {
            for (int n = 15; n > 0; n--) {
                System.out.println("The main thread: " + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("The main thread is interrupted.");
        }
        System.out.println("The main thread is terminated.");
    }

}
