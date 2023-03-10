package org.example.test;

@FunctionalInterface
public interface Testable<T> {

    T add(T t);

    int hashCode();

    static void staticTest() {
        System.out.println("Hello from Testable - static void staticTest()");
        processing();
    }

    default void defaultTest() {
        System.out.println("Hello from Testable - static void defaultTest()");
        processing();
    }

    private static void processing() {
        System.out.println("Hello from Testable - static void processing()");
    }


}
