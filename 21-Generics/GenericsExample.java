/**
 * Day 21 - Generics: Generic Class Example
 */
import java.util.*;

class Box<T> {
    private T item;

    void put(T item) {
        this.item = item;
    }

    T get() {
        return item;
    }
}

public class GenericsExample {
    public static void main(String[] args) {
        System.out.println("=== Generics ===\n");

        Box<String> stringBox = new Box<>();
        stringBox.put("Hello");
        System.out.println("String: " + stringBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.put(42);
        System.out.println("Integer: " + intBox.get());

        Box<Double> doubleBox = new Box<>();
        doubleBox.put(3.14);
        System.out.println("Double: " + doubleBox.get());
    }
}


