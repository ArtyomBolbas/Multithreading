package org.example;

public class MultiThread implements Runnable {

    private String name;   //thread's name
    private Thread thread;

    public MultiThread(String name) {
        this.name = name;
        this.thread = new Thread(this, name);
        System.out.println("New thread is created: " + thread);
        this.thread.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " terminated.");
    }

}

class MultiThreadRunner {

    public static void main(String[] args) {
        new MultiThread("First thread");
        new MultiThread("Second thread");
        new MultiThread("Third thread");

        try {
            //wait terminate other threads
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println("The main thread is interrupted.");
        }
        System.out.println("The main thread is terminated.");
    }

}
