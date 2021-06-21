package org.example.gerbert_shild;

public class CallMe {

    public void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }

}

class Caller implements Runnable {

    private String msg;
    private CallMe target;
    private Thread thread;

    public Caller(CallMe target, String msg) {
        this.target = target;
        this.msg = msg;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CallMe getTarget() {
        return target;
    }

    public void setTarget(CallMe target) {
        this.target = target;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

}

class Synch {

    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target, "Welcome ");
        Caller ob2 = new Caller(target, "to synchronized ");
        Caller ob3 = new Caller(target, "world!");

        //wait terminate the thread
        try {
            ob1.getThread().join();
            ob2.getThread().join();
            ob3.getThread().join();
        } catch (InterruptedException ex) {
            System.out.println("is interrupted.");
        }
    }

}
