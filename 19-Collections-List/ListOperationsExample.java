/**
 * Day 19 - Collections: Sorting and Searching
 */
import java.util.*;

public class ListOperationsExample {

    static class Student implements Comparable<Student> {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public int compareTo(Student other) {
            return this.marks - other.marks;
        }

        @Override
        public String toString() {
            return name + "(" + marks + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== List Operations ===\n");

        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 85));
        students.add(new Student("Jane", 92));
        students.add(new Student("Bob", 78));

        System.out.println("Original: " + students);

        Collections.sort(students);
        System.out.println("Sorted by marks: " + students);

        Collections.reverse(students);
        System.out.println("Reversed: " + students);
    }
}



