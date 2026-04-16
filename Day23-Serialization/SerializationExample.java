/**
 * Day 23 - Serialization: Object Serialization
 */
import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    transient String password;

    Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        System.out.println("=== Serialization ===\n");

        Person person = new Person("John", 25, "secret123");

        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            out.writeObject(person);
            System.out.println("✓ Object serialized");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Deserialize
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.dat"))) {
            Person loadedPerson = (Person) in.readObject();
            System.out.println("✓ Object deserialized");
            System.out.println("Name: " + loadedPerson.name);
            System.out.println("Age: " + loadedPerson.age);
            System.out.println("Password (transient): " + loadedPerson.password);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


