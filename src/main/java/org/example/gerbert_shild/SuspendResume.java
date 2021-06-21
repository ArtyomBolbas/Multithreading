package org.example.gerbert_shild;

public class SuspendResume {

    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");

        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Stop first thread");
            Thread.sleep(1500);
            ob1.myResume();
            System.out.println("Continue first thread");
            ob2.mySuspend();
            System.out.println("Stop second thread");
            Thread.sleep(1500);
            ob2.myResume();
            System.out.println("Continue second thread");
        } catch (InterruptedException ex) {
            System.out.println("The main thread is interrupted");
        }

        try {
            System.out.println("Waiting terminating threads");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException ex) {
            System.out.println("The main thread is interrupted");
        }
        System.out.println("The main thread is terminated");
    }

}

class NewThread implements Runnable {

    String name;
    Thread t;
    boolean suspendFlag;

    public NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException ex) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " terminated.");
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }

    synchronized void myResume() {
        suspendFlag = false;
        notify();
    }

}
