package org.example;

public class Deadlock implements Runnable {
    A a = new A();
    B b = new B();

    public Deadlock() {
        Thread.currentThread().setName("Main thread");
        Thread t = new Thread(this, "Rival thread");
        t.start();

        a.foo(b);
        System.out.println("back in main thread");
    }

    @Override
    public void run() {
        b.bar(a);
        System.out.println("back in another thread");
    }

    public static void main(String[] args) {
        new Deadlock();
    }

}

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start method A.foo()");
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println("Class A is interrupted");
        }
        System.out.println("Thread name is: " + Thread.currentThread().getName() + "; state's: " + Thread.currentThread().getState());
        System.out.println(name + " trying to call the method B.last()");
        b.last();
        System.out.println("Thread name is: " + Thread.currentThread().getName() + "; state's: " + Thread.currentThread().getState());
    }
    synchronized void last() {
        System.out.println("into the method A.last()");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start method B.bar()");
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println("Class B is interrupted");
        }
        System.out.println("Thread name is: " + Thread.currentThread().getName() + "; state's: " + Thread.currentThread().getState());
        System.out.println(name + " trying to call the method A.last()");
        a.last();
        System.out.println("Thread name is: " + Thread.currentThread().getName() + "; state's: " + Thread.currentThread().getState());
    }
    synchronized void last() {
        System.out.println("into the method B.last()");
    }
}
