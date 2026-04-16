# Day 15: Static Keyword

---

## Overview

```text
Goal:
Master the static keyword and understand class-level members

You will learn:
- Static variables
- Static methods
- Static blocks
- Static import
- When to use static
- Common patterns with static
- Memory considerations
```

---

## 1. What is Static?

```text
Static means "belongs to class, not to objects"

Object-level: Each object has its own copy
Class-level: Shared by all objects

Memory: Loaded once when class loads
```

### Real-Life Analogy

```text
Instance variable: Each car has its own gas tank
Static variable: Gas station serves all cars

Or:

Instance method: Each person can eat
Static method: Rules (like laws) apply to everyone
```

---

## 2. Static Variables

### Concept

```text
Shared by all objects of the class
Initialized when class loads
One copy in memory for entire class
```

### Example

```java
class Car {
    static int totalCars = 0;      // Class variable (static)
    String color;                   // Instance variable
    
    Car(String color) {
        this.color = color;
        totalCars++;               // Increment shared variable
    }
}

Car c1 = new Car("Red");
Car c2 = new Car("Blue");

System.out.println(Car.totalCars);  // 2 (shared)
```

---

## 3. Static Methods

### Concept

```text
Method that belongs to class, not object
Called using class name, not object
Cannot access instance variables
```

### Example

```java
class Calculator {
    static int add(int a, int b) {
        return a + b;
    }
}

// Called using class name
int result = Calculator.add(5, 10);

// NOT using object
// Calculator calc = new Calculator();
// calc.add(5, 10);  // Wrong usage (though works)
```

---

## 4. Static Blocks

### Concept

```text
Code block executed when class loads
Executed once, before any objects created
Used for initialization
```

### Example

```java
class Database {
    static String connectionString;
    
    static {
        // Executed when class loads
        connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Database initialized");
    }
}
```

---

## 5. When to Use Static

### Good Use Cases

```text
✓ Utility methods (Math.sqrt, String methods)
✓ Shared configuration
✓ Constants
✓ Factory methods
✓ Counters shared by all objects
```

### Example: Utility Class

```java
class MathUtils {
    static double square(double num) {
        return num * num;
    }
    
    static double sqrt(double num) {
        return Math.sqrt(num);
    }
}

// Usage
MathUtils.square(5);
MathUtils.sqrt(25);
```

---

## 6. Static Constants

### Pattern

```text
static final TYPE CONSTANT = value
```

### Example

```java
class AppConfig {
    static final String APP_NAME = "MyApp";
    static final double VERSION = 1.0;
    static final int MAX_USERS = 1000;
}

// Usage
System.out.println(AppConfig.APP_NAME);
```

---

## 7. Static vs Instance Variables

### Comparison

```text
+------------------+------------------+------------------+
| Feature          | Static           | Instance         |
+------------------+------------------+------------------+
| Scope            | Class-level      | Object-level     |
| Memory           | One copy         | One per object   |
| Initialization   | When class loads | When object made |
| Access           | ClassName.var    | object.var       |
| Changes affect   | All objects      | Only that object |
+------------------+------------------+------------------+
```

### Example

```java
class Student {
    static int universityCode = 1001;  // All students same
    String name;                       // Each student different
}

Student s1 = new Student();
Student s2 = new Student();

s1.name = "John";
s2.name = "Jane";

System.out.println(s1.universityCode);  // 1001
System.out.println(s2.universityCode);  // 1001 (same)
System.out.println(s1.name);            // "John"
System.out.println(s2.name);            // "Jane"
```

---

## 8. Static Methods Can't Access Instance Variables

### Why?

```text
Static method called on class, not object
No "this" reference
Don't know which object's variables to access
```

### Example

```java
class Student {
    String name;                      // Instance
    static int count;                 // Static
    
    static void displayCount() {
        System.out.println(count);    // OK: static variable
        // System.out.println(name);  // ERROR: instance variable
    }
    
    void displayName() {
        System.out.println(name);     // OK: instance variable
        System.out.println(count);    // OK: can access static from instance
    }
}
```

---

## 9. Common Static Patterns

### Pattern 1: Singleton

```java
class Singleton {
    private static Singleton instance;
    
    private Singleton() { }
    
    static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

---

### Pattern 2: Factory Method

```java
class AnimalFactory {
    static Animal createAnimal(String type) {
        if ("dog".equals(type)) {
            return new Dog();
        } else if ("cat".equals(type)) {
            return new Cat();
        }
        return null;
    }
}
```

---

## 10. Static Import

### Concept

```text
Import static members directly
```

### Example

```java
import static java.lang.Math.*;

double result = sqrt(16);  // No need for Math.sqrt()
```

---

## 11. Memory Diagram

### Static Variables

```text
Class Loading:
┌─────────────────────┐
│ Class Memory        │
├─────────────────────┤
│ static count = 0    │  ← Loaded once, shared
└─────────────────────┘

┌─────────────────────┐
│ Object 1            │
├─────────────────────┤
│ name = "John"       │  → References static count
└─────────────────────┘

┌─────────────────────┐
│ Object 2            │
├─────────────────────┤
│ name = "Jane"       │  → References same static count
└─────────────────────┘
```

---

## 12. Real-Life Example: Logger

```java
class Logger {
    private static int logCount = 0;
    
    static void log(String message) {
        logCount++;
        System.out.println("[LOG " + logCount + "] " + message);
    }
    
    static int getLogCount() {
        return logCount;
    }
}

// Usage
Logger.log("Application started");
Logger.log("Processing request");
System.out.println("Total logs: " + Logger.getLogCount());
```

---

## 13. Interview Tips

```text
1. Static definition
   - Class-level, shared by all objects

2. Static variable
   - One copy in memory
   - Shared by all objects

3. Static method
   - Called using class name
   - Cannot access instance variables

4. When to use static
   - Utility methods
   - Shared configuration
   - Factory methods
   - Constants

5. Static block
   - Executed when class loads
   - Initialization code

6. Memory implications
   - Static uses less memory for shared data
   - But care with mutable static variables

7. Common mistakes
   - Using static unnecessarily
   - Modifying static variables carelessly
   - Trying to access instance from static
```

---

## 14. Common Mistakes

### Mistake 1: Accessing Instance from Static

```java
// WRONG
static void method() {
    System.out.println(this.name);  // ERROR: 'this' not available
}

// RIGHT
void method() {
    System.out.println(this.name);  // OK in instance method
}
```

---

### Mistake 2: Using Static for Everything

```java
// WRONG: Overusing static
class StudentData {
    static String name;
    static int age;
    static String email;
    // All shared - not what we want!
}

// RIGHT: Use instance variables
class Student {
    String name;
    int age;
    String email;
    // Each student has own
}
```

---

## 15. Key Takeaways

```text
- Static belongs to class, not objects
- Static variables shared by all objects
- Static methods called using class name
- Static blocks executed at class load
- Cannot access instance variables from static methods
- Good for utilities, constants, factory methods
- Use carefully to avoid global state issues
```

---

## Final Thought

```text
Static is powerful but use wisely.
Remember: With shared state comes responsibility.
Use static for truly shared behavior and data,
not for convenience.
```

---


