package org.example;

public class MyRunnable implements Runnable {

    private Thread thread;

    public MyRunnable() {
        //create new thread
        thread = new Thread(this, "Demonstration thread");
        System.out.println("Child thread is created: " + thread);
        thread.start(); //launch thread
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            System.out.println("Child thread is interrupted.");
        }
        System.out.println("Child thread is finished.");
    }

}

class RunnerMyRunnable {

    public static void main(String[] args) {
        new MyRunnable(); //create new thread

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println("The main thread: " + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("The main thread is interrupted.");
        }
        System.out.println("The main thread is finished.");
    }

}
