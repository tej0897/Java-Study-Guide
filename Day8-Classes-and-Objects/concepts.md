# Day 8: Classes and Objects Deep Dive

---

## Overview

```text
Goal:
Deeply understand how classes and objects work in Java,
and how to design well-structured classes

You will learn:
- Class structure and anatomy
- Objects as instances of classes
- State and behavior
- Creating and using objects
- Class design principles
- Best practices for class design
- Real-world class modeling
```

---

## 1. Recap: What is a Class?

```text
Class = Blueprint or template for creating objects
Object = Instance of a class (actual realization)
```

### Simple Example

```text
Class:   Car (Blueprint)
Object:  my car = Car object
         your car = Car object
         his car = Car object
```

---

## 2. Class Anatomy

### Complete Class Structure

```java
class Car {
    
    // 1. PROPERTIES (State/Attributes)
    String color;
    int speed;
    
    // 2. CONSTRUCTOR (Initializer)
    Car(String color) {
        this.color = color;
    }
    
    // 3. METHODS (Behavior)
    void accelerate() {
        speed += 10;
    }
}
```

### Breakdown

```text
+----------------------------+
| Class                      |
+----------------------------+
| PROPERTIES (What it is)    |
| - color                    |
| - speed                    |
+----------------------------+
| METHODS (What it does)     |
| - accelerate()             |
| - brake()                  |
+----------------------------+
```

---

## 3. Properties (State)

### What are Properties?

```text
Properties are variables that hold data about the object.
They define the "state" of an object.
```

### Real-Life Example

```text
Student class:
- name (property)
- age (property)
- rollNumber (property)
- gpa (property)

Each Student object has its own values for these properties.
```

### Declaration

```java
class Student {
    // Properties
    String name;
    int age;
    String email;
    double gpa;
}
```

---

## 4. Methods (Behavior)

### What are Methods?

```text
Methods are functions that define what actions an object can perform.
They define the "behavior" of an object.
```

### Real-Life Example

```text
Student class:
- study() - method
- submitAssignment() - method
- takeExam() - method
```

### Declaration

```java
class Student {
    String name;
    
    // Methods
    void study(int hours) {
        System.out.println(name + " studies for " + hours + " hours");
    }
    
    void submitAssignment(String assignmentName) {
        System.out.println(name + " submitted " + assignmentName);
    }
}
```

---

## 5. Creating Objects

### Syntax

```java
ClassName objectName = new ClassName();
```

### Example

```java
Student student1 = new Student();
Student student2 = new Student();
```

### What Happens?

```text
1. 'new' keyword allocates memory on heap
2. Constructor is called to initialize object
3. Reference returned and stored in variable
4. Object is ready to use
```

### Visual

```text
Memory:

Stack:                          Heap:
┌─────────────┐                ┌──────────────┐
│ student1    │───────────────→│ Student      │
│ reference   │                │ object1      │
└─────────────┘                └──────────────┘

┌─────────────┐                ┌──────────────┐
│ student2    │───────────────→│ Student      │
│ reference   │                │ object2      │
└─────────────┘                └──────────────┘
```

---

## 6. Accessing Properties and Methods

### Using Dot (.) Notation

```java
Student student = new Student();

// Accessing properties
student.name = "Tejas";
student.age = 20;

// Calling methods
student.study(5);
student.submitAssignment("Math");

// Reading properties
System.out.println(student.name);
```

---

## 7. Getters and Setters

### Why Use Getters and Setters?

```text
Instead of direct access, use methods:
- Getters: Read property value
- Setters: Write property value

Benefits:
- Control access
- Validation
- Encapsulation
```

### Example

```java
class Student {
    private int age;
    
    // Getter
    int getAge() {
        return age;
    }
    
    // Setter with validation
    void setAge(int newAge) {
        if (newAge > 0 && newAge < 150) {
            age = newAge;
        }
    }
}

// Using getter and setter
Student student = new Student();
student.setAge(20);
System.out.println(student.getAge());  // 20
student.setAge(-5);  // Rejected (invalid)
```

---

## 8. Constructors Deep Dive

### What is a Constructor?

```text
Constructor is a special method that:
- Has same name as class
- Called automatically when object is created
- Used to initialize object state
- Has no return type
```

### Constructor Syntax

```java
class Car {
    String color;
    
    // Constructor
    Car(String color) {
        this.color = color;
    }
}
```

### Using Constructor

```java
Car car = new Car("Red");
// Constructor automatically called
```

---

### No-Argument Constructor

```java
class Car {
    String color;
    
    // No-argument constructor
    Car() {
        color = "White";  // Default value
    }
}

Car car = new Car();  // color = "White"
```

---

### Default Constructor

```text
If you don't define any constructor,
Java automatically provides a DEFAULT constructor:

Car() {
    // Empty, does nothing
}
```

---

## 9. this Keyword

### What is 'this'?

```text
'this' refers to the CURRENT object.
Used to distinguish between property and parameter with same name.
```

### Example

```java
class Car {
    String color;
    
    Car(String color) {
        this.color = color;  // 'this.color' = property
                             // 'color' = parameter
    }
}
```

### Without 'this'

```java
Car(String color) {
    color = color;  // WRONG! Assigns parameter to itself
}
```

### With 'this'

```java
Car(String color) {
    this.color = color;  // CORRECT! Assigns parameter to property
}
```

---

## 10. Object State and Behavior

### State

```text
State = Current values of properties

Example:
Car object:
- color: "Red"
- speed: 0
- isRunning: false
```

### Behavior

```text
Behavior = What the object can do (methods)

Example:
Car object can:
- accelerate()
- brake()
- honk()
- stop()
```

### Interaction

```text
Behavior changes state:

Initial state:
- speed: 0
- isRunning: false

Call accelerate():
- speed: 60
- isRunning: true

Call brake():
- speed: 0
- isRunning: false
```

---

## 11. Immutable Objects

### What is Immutability?

```text
An immutable object is one whose state cannot change after creation.
Once created, properties cannot be modified.
```

### Example

```java
class Point {
    private final int x;
    private final int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    int getX() { return x; }
    int getY() { return y; }
    
    // No setters! State cannot be changed
}
```

### Benefits

```text
- Thread-safe (no synchronization needed)
- Reliable (cannot be changed unexpectedly)
- Can be cached
- Safe for use as map keys
```

---

## 12. Class Design Best Practices

### Practice 1: Single Responsibility

```text
A class should have ONE reason to change.
One class = One purpose
```

### Example

```java
// GOOD: Single responsibility
class User {
    String name;
    String email;
}

class UserValidator {
    boolean validateEmail(String email) {
        // Validation logic
    }
}

// BAD: Too many responsibilities
class User {
    String name;
    String email;
    
    // Authentication (not user responsibility)
    void authenticate() { }
    
    // Validation (not user responsibility)
    void validate() { }
    
    // Database (not user responsibility)
    void save() { }
}
```

---

### Practice 2: Encapsulation

```text
Hide internal details, expose only necessary interface.
Use private for internal, public for external.
```

### Example

```java
class BankAccount {
    // Private: internal details
    private double balance;
    private String accountNumber;
    
    // Public: only necessary methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public double getBalance() {
        return balance;
    }
}
```

---

### Practice 3: Meaningful Names

```text
Use clear, descriptive names for classes, properties, methods.
```

### Example

```java
// GOOD: Clear intention
class StudentGradeCalculator {
    double calculateAverageGrade(List<Double> grades) { }
}

// BAD: Unclear
class Calc {
    double calc(List<Double> x) { }
}
```

---

## 13. Object Composition

### What is Composition?

```text
Composition is combining multiple objects to create complex ones.
"has-a" relationship.
```

### Example

```java
class Engine {
    int horsepower;
}

class Car {
    Engine engine;  // Car HAS-A Engine
    String color;
    
    Car(int hp) {
        engine = new Engine();
        engine.horsepower = hp;
    }
}
```

### Visual

```text
Car composition:

┌────────────────────┐
│        Car         │
├────────────────────┤
│ - engine (Engine)  │
│ - color (String)   │
│ - wheels (Wheel[]) │
└────────────────────┘
       contains
         ↓
   ┌─────────┐   ┌──────┐   ┌───────┐
   │ Engine  │   │Wheel │   │Wheel  │
   └─────────┘   └──────┘   └───────┘
```

---

## 14. Real-Life Example: Bank Account

```java
class BankAccount {
    // Properties
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    // Constructor
    BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    // Methods
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }
    
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
    
    // Getter
    double getBalance() {
        return balance;
    }
}

// Usage
BankAccount account = new BankAccount("123456", "Tejas", 1000);
account.deposit(500);
account.withdraw(200);
System.out.println(account.getBalance());  // 1300
```

---

## 15. Real-Life Example: Library Book

```java
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;  // Initially available
    }
    
    void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book '" + title + "' borrowed");
        } else {
            System.out.println("Book not available");
        }
    }
    
    void returnBook() {
        isAvailable = true;
        System.out.println("Book '" + title + "' returned");
    }
    
    boolean isAvailable() {
        return isAvailable;
    }
}

// Usage
Book book = new Book("Java Basics", "John Doe", "ISBN123");
book.borrow();
book.returnBook();
```

---

## 16. Edge Cases and Common Mistakes

### Mistake 1: Forgetting Constructor

```java
// WRONG: Relying on default constructor
class Person {
    String name;
    
    void setPerson(String name) {
        this.name = name;
    }
}

Person p = new Person();
// p.name is null (not initialized)
```

### Better

```java
// RIGHT: Provide constructor
class Person {
    String name;
    
    Person(String name) {
        this.name = name;
    }
}

Person p = new Person("Tejas");
// p.name is "Tejas"
```

---

### Mistake 2: Public Properties

```java
// WRONG: Direct access to properties
class User {
    public String password;
}

User user = new User();
user.password = "";  // Weak password allowed!
```

### Better

```java
// RIGHT: Use setter with validation
class User {
    private String password;
    
    void setPassword(String pwd) {
        if (pwd.length() >= 8) {
            password = pwd;
        } else {
            System.out.println("Password too weak");
        }
    }
}
```

---

## 17. Interview Tips

```text
1. Explain class vs object clearly
   - Class = blueprint
   - Object = instance

2. Understand class anatomy
   - Properties (state)
   - Methods (behavior)
   - Constructor (initialization)

3. Object creation process
   - Memory allocation on heap
   - Constructor invocation
   - Reference assignment

4. Importance of encapsulation
   - Hide internal details
   - Provide public interface
   - Validate in setters

5. Constructor purpose
   - Initialize object state
   - Called automatically with 'new'
   - Can have multiple constructors (overloading)

6. 'this' keyword usage
   - Refers to current object
   - Useful for naming conflicts
   - Can call other constructors

7. Design principles
   - Single responsibility
   - Clear naming
   - Immutability when appropriate
```

---

## 18. Key Takeaways

```text
- Class is blueprint, object is instance
- Properties define state (data)
- Methods define behavior (actions)
- Constructor initializes object when created
- Encapsulation hides internal details
- Use private properties, public methods
- Setters should validate input
- Immutable objects are safer
- Well-designed classes follow SOLID principles
- Composition combines objects for complex behavior
```

---

## 19. Common Mistakes to Avoid

```text
❌ Confusing class and object
   ✓ Class = template, Object = instance

❌ Making properties public
   ✓ Use private properties, public methods

❌ Forgetting to initialize properties
   ✓ Use constructor for initialization

❌ Not validating in setters
   ✓ Add business logic to setters

❌ Too many responsibilities in one class
   ✓ Keep classes focused and simple

❌ Unclear method/property names
   ✓ Use descriptive, clear names
```

---

## Final Thought

```text
A well-designed class is the foundation of good software.
Master class design and object creation,
and you're on your way to writing maintainable, professional code.
```

---


