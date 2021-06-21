package org.example.gerbert_shild;

public class MultiThreadJoin implements Runnable {

    private String name;   //thread's name
    private Thread thread;

    public MultiThreadJoin(String name) {
        this.name = name;
        this.thread = new Thread(this, name);
        System.out.println("New thread is created: " + thread);
        this.thread.start(); //launch thread
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

    public String getName() {
        return name;
    }

    public Thread getThread() {
        return thread;
    }

}

class MultiThreadJoinRunner {

    public static void main(String[] args) {
        MultiThreadJoin ob1 = new MultiThreadJoin("First thread");
        MultiThreadJoin ob2 = new MultiThreadJoin("Second thread");
        MultiThreadJoin ob3 = new MultiThreadJoin("Third thread");

        System.out.println("The First thread is launched: " + ob1.getThread().isAlive());
        System.out.println("The Second thread is launched: " + ob2.getThread().isAlive());
        System.out.println("The Third thread is launched: " + ob3.getThread().isAlive());

        //wait terminate other threads
        try {
            System.out.println("wait terminate other threads");
            ob1.getThread().join();
            ob2.getThread().join();
            ob3.getThread().join();
        } catch (InterruptedException ex) {
            System.out.println("The main thread is interrupted.");
        }

        System.out.println("The First thread is launched: " + ob1.getThread().isAlive());
        System.out.println("The Second thread is launched: " + ob2.getThread().isAlive());
        System.out.println("The Third thread is launched: " + ob3.getThread().isAlive());

        System.out.println("The main thread is terminated.");
    }

}
