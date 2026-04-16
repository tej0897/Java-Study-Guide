/**
 * Day 17 - Constructor Chaining with This and Super
 */
public class ConstructorChainingExample {

    static class Person {
        String name;
        int age;
        String email;

        Person() {
            this("Unknown", 0, "no-email@example.com");
        }

        Person(String name) {
            this(name, 0, "no-email@example.com");
        }

        Person(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        void display() {
            System.out.println(name + ", " + age + ", " + email);
        }
    }

    static class Employee extends Person {
        String employeeId;

        Employee(String name, int age, String email, String id) {
            super(name, age, email);  // Call parent
            this.employeeId = id;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Constructor Chaining ===\n");

        Person p1 = new Person();
        Person p2 = new Person("John");
        Person p3 = new Person("Jane", 25, "jane@example.com");

        p1.display();
        p2.display();
        p3.display();

        System.out.println("\n--- Employee (extends Person) ---");
        Employee emp = new Employee("Bob", 30, "bob@company.com", "EMP001");
        emp.display();
    }
}


