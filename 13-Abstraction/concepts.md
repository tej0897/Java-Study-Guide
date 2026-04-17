# Day 13: Abstraction

---

## Overview

```text
Goal:
Master abstraction to hide complexity and show only essential features

You will learn:
- What is abstraction
- Abstract classes
- Abstract methods
- Interfaces (introduction)
- When to use abstract classes
- Real-world abstraction patterns
- Benefits of abstraction
```

---

## Definitions

```text
Abstraction
  Hiding implementation details and exposing only a clear contract.
  Show: WHAT
  Hide: HOW

Abstract class
  A class that cannot be instantiated.
  Can contain both abstract methods and concrete methods.

Interface
  A contract that a class agrees to implement.
  (Modern Java can also have default/static methods.)
```

---

## Real-life analogies

```text
Driving
  You use steering and pedals (contract).
  You do not manage engine combustion (implementation).

Payment gateway
  pay(amount) is the contract.
  Card/UPI/Wallet implement it differently.
```

---

## ASCII diagrams

```text
            Vehicle (abstract)
         +---------------------+
         | + start()  (abstract)|
         | + stop()   (concrete)|
         +---------------------+
                 ^
                 |
        +--------+--------+
        |                 |
      Car               Bike
 (implements start)  (implements start)
```

---

## Code snippets

```java
abstract class Vehicle {
    abstract void start();
    void stop() { System.out.println("Stopped"); }
}

class Car extends Vehicle {
    @Override void start() { System.out.println("Car starts"); }
}
```

---

## Step-by-step explanations

```text
How abstraction helps:

1) Define stable contracts (interfaces/abstract classes)
2) Write code against the contract, not the implementation
3) Swap implementations without changing calling code

Result:
  cleaner design + easier testing + fewer dependencies.
```

---

## Edge cases / common mistakes

```text
1) Confusing encapsulation and abstraction
   Encapsulation: protect state (private fields).
   Abstraction: hide complexity behind a contract.

2) Overusing abstraction early
   Abstraction is useful, but premature abstraction can overcomplicate.

3) Interface vs abstract class
   Use interface for capabilities/roles; use abstract class for shared code + base state.
```

---

## Interview tips

```text
Q) Interface vs abstract class?
A) Interface: contract, multiple can be implemented.
   Abstract class: shared base behavior/state, single inheritance.

Q) Can abstract class have constructors?
A) Yes. Used by subclasses via super(...).
```

---

## Summary

```text
+-------------------+----------------------------------------------+
| Topic             | Key point                                     |
+-------------------+----------------------------------------------+
| Abstraction       | show WHAT, hide HOW                            |
| Abstract class    | can share code + force methods via abstract    |
| Interface         | contract; enables polymorphism and loose coupling|
+-------------------+----------------------------------------------+
```

## 1. What is Abstraction?

```text
Abstraction means hiding complex implementation details
and showing only essential features.

Hide: HOW things work
Show: WHAT things do
```

### Real-Life Analogy

```text
Car driver doesn't know:
- Engine internals
- Transmission details
- Fuel system

Driver only needs:
- Steering wheel
- Brake pedal
- Accelerator
- Dashboard display
```

---

## 2. Abstract Classes

### What is Abstract Class?

```text
A class that cannot be instantiated directly
Contains abstract methods that MUST be implemented by child classes
```

### Syntax

```java
abstract class Animal {
    abstract void sound();  // No implementation
    
    void eat() {
        System.out.println("Eating");
    }
}
```

---

### Key Rules

```text
1. Cannot create objects of abstract class
2. Must have at least one abstract method
3. Child class must implement abstract methods
4. Can have concrete methods too
```

---

## 3. Abstract Methods

### Definition

```text
Method with no implementation (no body)
Declared with 'abstract' keyword
Must be implemented by child class
```

### Example

```java
abstract class Vehicle {
    abstract void start();    // No body, must implement
    abstract void stop();     // No body, must implement
    
    void displayInfo() {      // Concrete method (has body)
        System.out.println("I am a vehicle");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts");
    }
    
    @Override
    void stop() {
        System.out.println("Car stops");
    }
}
```

---

## 4. Interfaces (Quick Introduction)

### What is Interface?

```text
Contract that specifies what methods a class must have
All methods are abstract (by default)
Cannot have implementation (until Java 8)
```

### Syntax

```java
interface Animal {
    void sound();
    void move();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
    
    @Override
    public void move() {
        System.out.println("Run");
    }
}
```

---

## 5. Abstract Class vs Concrete Class

```text
+------------------+--------------------+--------------------+
| Feature          | Abstract Class     | Concrete Class     |
+------------------+--------------------+--------------------+
| Instantiation    | Cannot create      | Can create objects |
| Methods          | Can be abstract    | All concrete       |
| Usage            | Blueprint          | Implementation     |
+------------------+--------------------+--------------------+
```

---

## 6. Real-Life Example: Payment System

```java
abstract class PaymentProcessor {
    
    abstract void processPayment(double amount);
    
    abstract void verifyTransaction();
    
    void logTransaction(double amount) {
        System.out.println("Transaction logged: $" + amount);
    }
}

class CreditCardProcessor extends PaymentProcessor {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing credit card: $" + amount);
    }
    
    @Override
    void verifyTransaction() {
        System.out.println("Verifying credit card");
    }
}

class PayPalProcessor extends PaymentProcessor {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing PayPal: $" + amount);
    }
    
    @Override
    void verifyTransaction() {
        System.out.println("Verifying PayPal account");
    }
}
```

---

## 7. Benefits of Abstraction

### Benefit 1: Hide Complexity

```java
// User doesn't need to know how it works
paymentProcessor.processPayment(100);

// Just uses it
```

---

### Benefit 2: Enforce Implementation

```java
// Child MUST implement abstract methods
// Compiler ensures nothing is missed
```

---

### Benefit 3: Flexibility

```java
// Can switch implementations easily
PaymentProcessor processor = new CreditCardProcessor();
// Later change to
processor = new PayPalProcessor();
```

---

## 8. Abstract Class vs Interface

```text
+--------------------+----------------+----------------+
| Feature            | Abstract Class | Interface      |
+--------------------+----------------+----------------+
| Methods            | Concrete/Abs   | Abstract only  |
| Variables          | Any            | Public static  |
| Constructors       | Yes            | No             |
| extends/implements | extends (1)    | implements (*)  |
| Access modifiers   | Any            | Public         |
+--------------------+----------------+----------------+
```

---

## 9. When to Use Abstract Classes

```text
✓ Classes are closely related
✓ Share common code
✓ Need non-public members
✓ Need constructors or instance variables
✓ IS-A relationship

Use Interfaces when:
✓ Unrelated classes should have same behavior
✓ Need to specify role/capability
✓ Multiple inheritance needed
```

---

## 10. Real-World Examples

### Example 1: Shape Hierarchy

```java
abstract class Shape {
    abstract double area();
    abstract double perimeter();
    
    void display() {
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}
```

---

### Example 2: Database Connections

```java
abstract class DatabaseConnection {
    abstract void connect();
    abstract void disconnect();
    abstract void executeQuery(String query);
    
    void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
```

---

## 11. Common Mistakes

### Mistake 1: Instantiating Abstract Class

```java
// WRONG
Animal animal = new Animal();  // Compile error!

// RIGHT
Animal animal = new Dog();  // Concrete subclass
```

---

### Mistake 2: Not Implementing Abstract Methods

```java
// WRONG
class Dog extends Animal {
    // Forgot to implement sound()
}

// RIGHT
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}
```

---

## 12. Interview Tips

```text
1. Abstraction definition
   - Hide complexity, show only what's needed

2. Abstract class definition
   - Cannot instantiate
   - Contains abstract methods

3. Abstract method
   - No implementation
   - Must be implemented by child

4. When to use abstraction
   - Create template/blueprint
   - Enforce implementation
   - Hide implementation details

5. Abstract class vs interface
   - Know differences
   - When to use each

6. Benefits
   - Flexibility, maintainability, organization

7. Real-world examples
   - Shape hierarchy
   - Database connections
   - Payment processors
```

---

## 13. Key Takeaways

```text
- Abstraction hides complexity, shows essential features
- Abstract classes cannot be instantiated
- Abstract methods have no implementation
- Child classes must implement abstract methods
- Use abstract classes for related classes with common code
- Provides template for subclasses
- Enables polymorphic behavior
- Forces implementation through abstract methods
```

---

## Final Thought

```text
Abstraction is the art of simplification.
Show only what matters, hide what doesn't.
Good abstraction makes code clean and maintainable.
```

---


