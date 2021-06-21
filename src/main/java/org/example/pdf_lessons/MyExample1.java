package org.example.pdf_lessons;

public class MyExample1 implements Runnable {

    private int value;

    public MyExample1(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        while (value >= 0) {
            System.out.println("Hello from method run() Value: " + value);
            this.value -= 1;
        }
    }

}

class RunnerMyExample1 {

    public static void main(String[] args) {
        Runnable myExample1 = new MyExample1(10);
        myExample1.run();
    }

}
