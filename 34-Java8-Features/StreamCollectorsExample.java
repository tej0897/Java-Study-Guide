/**
 * Day 34 - Java 8 Features: Stream Collectors
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamCollectorsExample {

    static class Person {
        final String name;
        final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Stream Collectors ===\n");

        List<Person> people = Arrays.asList(
                new Person("Alice", 20),
                new Person("Bob", 17),
                new Person("Charlie", 20),
                new Person("Dina", 30)
        );

        System.out.println("People: " + people);

        Set<Integer> ages = people.stream()
                .map(p -> p.age)
                .collect(Collectors.toSet());
        System.out.println("Unique ages (toSet): " + ages);

        Map<Integer, List<Person>> byAge = people.stream()
                .collect(Collectors.groupingBy(p -> p.age));
        System.out.println("Grouped by age: " + byAge);

        String joinedNames = people.stream()
                .map(p -> p.name)
                .collect(Collectors.joining(", "));
        System.out.println("Joined names: " + joinedNames);

        long adults = people.stream()
                .filter(p -> p.age >= 18)
                .count();
        System.out.println("Adults count: " + adults);

        System.out.println("\nKey Points:");
        System.out.println("1. Collectors.toList/toSet for basic materialization");
        System.out.println("2. groupingBy to build maps of lists");
        System.out.println("3. joining to build strings");
    }
}

