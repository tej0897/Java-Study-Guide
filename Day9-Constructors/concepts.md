# Day 9: Constructors in Java

---

## Overview

```text
Goal:
Master constructors and how to initialize objects properly

You will learn:
- What is a constructor
- Constructor rules and syntax
- Default constructor
- Parameterized constructors
- Constructor overloading
- Constructor chaining
- Copy constructor
- When to use which constructor
```

---

## 1. What is a Constructor?

```text
A constructor is a special method that:
- Is called automatically when an object is created
- Initializes the object's state
- Has the SAME NAME as the class
- Has NO RETURN TYPE (not even void)
```

### Real-Life Analogy

```text
Think of a construction site:

Blueprint (Class) → Construction (Constructor) → Building (Object)

Constructor is the construction process.
It initializes everything when object is built.
```

---

## 2. Constructor Rules

### Rule 1: Must Have Same Name as Class

```java
// CORRECT
class Car {
    Car() {  // Same name as class
    }
}

// INCORRECT
class Car {
    void Car() {  // Wrong: has return type
    }
    
    Automobile() {  // Wrong: different name
    }
}
```

---

### Rule 2: No Return Type

```java
// CORRECT
class Car {
    Car() {  // No return type
    }
}

// INCORRECT
class Car {
    void Car() {  // WRONG: has return type 'void'
    }
    
    Car Car() {  // WRONG: has return type 'Car'
    }
}
```

---

### Rule 3: Called Automatically

```java
Car car = new Car();  // Constructor called automatically
```

---

## 3. Default Constructor

### What is Default Constructor?

```text
Default constructor is:
- Constructor with NO parameters
- Called when no arguments provided
- If not explicitly defined, Java provides one automatically
```

### Explicit Default Constructor

```java
class Car {
    String color;
    
    // Explicit default constructor
    Car() {
        color = "White";
    }
}

Car car = new Car();
System.out.println(car.color);  // "White"
```

---

### Implicit Default Constructor

```java
class Car {
    String color;
    
    // No constructor defined
    // Java provides default automatically
}

Car car = new Car();
System.out.println(car.color);  // null (default value)
```

---

## 4. Parameterized Constructor

### What is Parameterized Constructor?

```text
Constructor that takes parameters to initialize properties.
```

### Example

```java
class Car {
    String color;
    int speed;
    
    // Parameterized constructor
    Car(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }
}

Car car = new Car("Red", 120);
System.out.println(car.color);  // "Red"
System.out.println(car.speed);  // 120
```

---

### Why Use Parameterized Constructor?

```text
✓ Initialize object with meaningful values
✓ Avoid null/default values
✓ More efficient than default + setters
✓ Make code more readable
```

---

## 5. Constructor Overloading

### What is Constructor Overloading?

```text
Multiple constructors in same class with different parameters.
Java chooses correct one based on arguments.
```

### Example

```java
class Student {
    String name;
    int age;
    
    // Constructor 1: No parameter
    Student() {
        name = "Unknown";
        age = 0;
    }
    
    // Constructor 2: Name only
    Student(String name) {
        this.name = name;
        age = 0;
    }
    
    // Constructor 3: Both parameters
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Java chooses appropriate constructor
Student s1 = new Student();                    // Constructor 1
Student s2 = new Student("Tejas");             // Constructor 2
Student s3 = new Student("Tejas", 20);         // Constructor 3
```

---

### Constructor Overloading Rules

```text
Overloaded constructors must differ in:
1. Number of parameters
2. Type of parameters
3. Order of parameters

Cannot differ in:
- Just return type (constructor has no return type)
```

### Valid Overloading

```java
class Point {
    int x, y;
    
    Point() { }
    Point(int x) { }
    Point(int x, int y) { }           // Different number of parameters ✓
    Point(double x, double y) { }     // Different type of parameters ✓
}
```

### Invalid Overloading

```java
class Point {
    int x, y;
    
    Point(int x, int y) { }
    Point(int y, int x) { }  // WRONG! Same number and type, just different order
}
```

---

## 6. Constructor Chaining

### What is Constructor Chaining?

```text
One constructor calling another constructor in same class
using 'this' keyword.
```

### Example

```java
class Student {
    String name;
    int age;
    String email;
    
    // Constructor 1: No parameter
    Student() {
        this("Unknown", 0);  // Calls Constructor 2
    }
    
    // Constructor 2: Name and age
    Student(String name, int age) {
        this(name, age, "no-email@example.com");  // Calls Constructor 3
    }
    
    // Constructor 3: All parameters
    Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
```

### Why Use Constructor Chaining?

```text
✓ Avoid code duplication
✓ Common initialization logic in one constructor
✓ More maintainable
```

### Visual Flow

```text
Student() → this("Unknown", 0)
            ↓
Student(String, int) → this(name, age, "default@example.com")
                       ↓
Student(String, int, String) → Initialization logic
```

---

## 7. 'this' Keyword in Constructor

### Usage 1: Distinguish Parameter from Property

```java
class Car {
    String color;
    
    Car(String color) {
        this.color = color;  // this.color = property, color = parameter
    }
}
```

---

### Usage 2: Call Another Constructor

```java
class Student {
    String name;
    int age;
    
    Student(String name) {
        this(name, 0);  // Calls other constructor
    }
    
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

---

## 8. Copy Constructor

### What is Copy Constructor?

```text
Constructor that creates new object as copy of existing object.
```

### Example

```java
class Student {
    String name;
    int age;
    
    // Regular constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Copy constructor
    Student(Student other) {
        this.name = other.name;
        this.age = other.age;
    }
}

// Usage
Student s1 = new Student("Tejas", 20);
Student s2 = new Student(s1);  // Copy of s1

System.out.println(s2.name);  // "Tejas"
System.out.println(s2.age);   // 20

// s1 and s2 are different objects with same values
s1.name = "Changed";
System.out.println(s2.name);  // Still "Tejas" (independent copy)
```

---

### Why Use Copy Constructor?

```text
✓ Create independent copy of object
✓ Modify copy without affecting original
✓ Deep copy (not reference copy)
```

---

## 9. Immutable Class with Constructor

### Example: ImmutableStudent

```java
class ImmutableStudent {
    private final String name;
    private final int age;
    
    // Constructor - only way to set values
    ImmutableStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Getters only (no setters)
    String getName() { return name; }
    int getAge() { return age; }
}

// Usage
ImmutableStudent s = new ImmutableStudent("Tejas", 20);
// s.name = "Changed";  // COMPILE ERROR! Cannot modify final fields
```

---

## 10. Constructor with Validation

### Example: Validated Constructor

```java
class BankAccount {
    private String accountNumber;
    private double balance;
    
    BankAccount(String accountNumber, double initialBalance) {
        // Validation
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        
        // Assignment only if valid
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
}

// Valid
BankAccount account1 = new BankAccount("ACC123", 1000);  // OK

// Invalid (exception thrown)
// BankAccount account2 = new BankAccount("", 1000);
// BankAccount account3 = new BankAccount("ACC123", -500);
```

---

## 11. Constructor with Complex Initialization

### Example

```java
class Database {
    private String connectionString;
    private boolean isConnected;
    private int connectionTimeout;
    
    Database(String host, int port, String database) {
        // Complex initialization logic
        this.connectionString = "jdbc:mysql://" + host + ":" + port + "/" + database;
        this.isConnected = false;
        this.connectionTimeout = 30;
        
        // Additional initialization
        initializeConnection();
    }
    
    private void initializeConnection() {
        System.out.println("Initializing connection to: " + connectionString);
        // Connection logic
    }
}
```

---

## 12. Anonymous Inner Class with Constructor

### Example

```java
interface Greeting {
    void greet(String name);
}

// Using anonymous class with constructor-like initialization
Greeting greeting = new Greeting() {
    String prefix = "Hello";
    
    @Override
    public void greet(String name) {
        System.out.println(prefix + ", " + name);
    }
};

greeting.greet("Tejas");  // Output: Hello, Tejas
```

---

## 13. Real-Life Example: Person Class

```java
class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    
    // Constructor 1: Default
    Person() {
        firstName = "John";
        lastName = "Doe";
        age = 18;
        email = "john@example.com";
    }
    
    // Constructor 2: Name only
    Person(String firstName, String lastName) {
        this(firstName, lastName, 18, "no-email@example.com");
    }
    
    // Constructor 3: All parameters
    Person(String firstName, String lastName, int age, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setEmail(email);
    }
    
    // Validation setters
    void setFirstName(String firstName) {
        if (firstName != null && !firstName.isEmpty()) {
            this.firstName = firstName;
        }
    }
    
    void setLastName(String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            this.lastName = lastName;
        }
    }
    
    void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }
    
    void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }
    
    void displayInfo() {
        System.out.println(firstName + " " + lastName + ", " + age + ", " + email);
    }
}

// Usage
Person p1 = new Person();
Person p2 = new Person("Tejas", "Kumar");
Person p3 = new Person("Priya", "Singh", 25, "priya@example.com");
```

---

## 14. Edge Cases and Common Mistakes

### Mistake 1: Forgetting 'new' Keyword

```java
// WRONG
Student s = Student();

// RIGHT
Student s = new Student();
```

---

### Mistake 2: Constructor with Return Type

```java
// WRONG: Constructor should not have return type
class Student {
    void Student() {
    }
}

// RIGHT
class Student {
    Student() {
    }
}
```

---

### Mistake 3: Not Initializing Properties

```java
// WRONG: Properties remain null/default
class Car {
    String color;
    Car() {
    }
}

Car car = new Car();
System.out.println(car.color);  // null

// RIGHT: Initialize in constructor
class Car {
    String color;
    Car() {
        color = "White";
    }
}

Car car = new Car();
System.out.println(car.color);  // "White"
```

---

### Mistake 4: Invalid Constructor Chaining

```java
// WRONG: 'this()' must be first statement
class Student {
    Student(String name) {
        System.out.println("Creating student");
        this();  // COMPILE ERROR! Must be first
    }
    
    Student() {
    }
}

// RIGHT: 'this()' first
class Student {
    Student(String name) {
        this();  // First statement
        System.out.println("Creating student");
    }
    
    Student() {
    }
}
```

---

## 15. Interview Tips

```text
1. Constructor definition
   - Same name as class
   - No return type
   - Called automatically with 'new'

2. Default constructor
   - No parameters
   - Provided by Java if not defined
   - Can be explicitly defined

3. Parameterized constructor
   - Takes parameters
   - Better than default for initialization
   - More meaningful objects

4. Constructor overloading
   - Multiple constructors with different parameters
   - Based on number/type/order of parameters
   - Not return type

5. Constructor chaining
   - One constructor calls another
   - Uses 'this()' keyword
   - 'this()' must be first statement

6. Copy constructor
   - Creates independent copy
   - Deep copy of object
   - Useful for immutable objects

7. Validation in constructor
   - Ensure object is in valid state
   - Throw exceptions for invalid input
   - Better than setters for mandatory fields

8. this vs super
   - 'this' = current class
   - 'super' = parent class (learned later)
```

---

## 16. Key Takeaways

```text
- Constructor is special method called automatically on object creation
- Constructor name must match class name
- Constructor has no return type
- Default constructor created automatically if not defined
- Parameterized constructors enable flexible initialization
- Constructor overloading allows multiple initialization ways
- Constructor chaining reduces code duplication
- Copy constructor creates independent copy
- Validate input in constructor
- 'this' keyword used for naming conflicts and constructor chaining
- Immutable objects use final fields in constructor
```

---

## 17. Common Mistakes to Avoid

```text
❌ Adding return type to constructor
   ✓ Constructor has NO return type

❌ Forgetting to initialize important properties
   ✓ Initialize all properties in constructor

❌ Forgetting 'new' keyword
   ✓ Always use 'new' to create objects

❌ Invalid 'this()' call (not first statement)
   ✓ 'this()' must be first statement

❌ Not providing constructors with parameters
   ✓ Provide parameterized constructors

❌ Forgetting copy constructor for complex objects
   ✓ Provide copy constructor for independent copies
```

---

## Final Thought

```text
Constructors are the birth of objects.
Master them, and your objects will be well-initialized, safe, and predictable.
Good constructors prevent bugs before they start.
```

---


