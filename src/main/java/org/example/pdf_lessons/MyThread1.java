package org.example.pdf_lessons;

public class MyThread1 extends Thread {

    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("A");
        }
    }

}

class RunnerMyThread1 {

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1("My_thread_1");
        t1.setDaemon(true);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        int laps = 10000;
        while(laps > 0) {
            System.out.println(".");
            laps--;
        }
    }

}
