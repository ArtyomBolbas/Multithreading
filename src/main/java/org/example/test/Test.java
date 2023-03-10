package org.example.test;

import java.util.function.Predicate;

public class Test extends TestAbstract {

    private int value;
    private int expectedValue;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(int expectedValue) {
        this.expectedValue = expectedValue;
    }

    public static void main(String[] args) {
        Test test = new Test();
//        test.add();
//        new Thread(() -> System.out.println("Hello From Another Thread")).start();
//        Testable.staticTest();

        Testable<String> a = value -> "Hello" + value;

        Predicate<Integer> predicate = value -> value > 4;

        System.out.println(predicate.test(5));
        System.out.println(predicate.test(3));

//        System.out.println(a.add(" from lambda expression"));

    }



}
