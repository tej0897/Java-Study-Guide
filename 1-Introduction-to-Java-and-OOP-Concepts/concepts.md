# Day 1: Introduction to Java and OOP Concepts

---

## Overview

```text
Goal:
Understand what Java is and build a strong foundation in Object-Oriented Programming (OOP)

You will learn:
- What is Java
- Why Java is used
- What is OOP
- 4 Pillars of OOP with real-life examples
```

---

## 1. What is Java?

```text
Java is a high-level, object-oriented programming language
used to build scalable and platform-independent applications.
```

### Key Features

```text
- Platform Independent  -> Write Once, Run Anywhere
- Object-Oriented      -> Based on real-world modeling
- Secure               -> Strong memory management
- Widely Used          -> Backend, Android, Enterprise apps
```

---

## 2. Why Java?

```text
Java is widely used in real-world systems such as:
- Banking applications
- Government systems
- Enterprise backend services
```

### Simple Understanding

```text
Java = Reliable + Scalable + Industry Standard
```

---

## 3. What is OOP?

```text
OOP (Object-Oriented Programming) is a way of designing programs
using real-world objects.

Instead of writing only functions, we create objects that
contain both data and behavior.
```

---

## 4. Real-Life Example (Car System)

```text
           +----------------------+
           |        Car           |   <-- Class (Blueprint)
           +----------------------+
           | color                |
           | speed                |
           +----------------------+
           | drive()              |
           | brake()              |
           +----------------------+

                /         \
               /           \
              v             v

        +---------+   +---------+
        |  BMW    |   |  Audi   |   <-- Objects (Instances)
        +---------+   +---------+
```

---

## 5. Class vs Object

```text
+----------------+----------------------+
| Concept        | Meaning              |
+----------------+----------------------+
| Class          | Blueprint            |
| Object         | Real instance        |
+----------------+----------------------+
```

### Example

```text
Class  -> Car
Object -> BMW, Audi
```

---

## 6. Four Pillars of OOP

---

### 6.1 Encapsulation

```text
Definition:
Hiding data and allowing access only through methods
```

### Real-Life Example (ATM)

```text
User -> [ ATM Machine ] -> Bank System

You cannot directly access balance
You must use:
- checkBalance()
- deposit()
```

### ASCII Representation

```text
+----------------------+
|    BankAccount       |
+----------------------+
| - balance (private)  |
+----------------------+
| + getBalance()       |
| + deposit()          |
+----------------------+
```

### Pseudo Code

```text
class BankAccount:
    private balance

    method getBalance():
        return balance

    method deposit(amount):
        balance = balance + amount
```

---

### 6.2 Inheritance

```text
Definition:
One class can inherit properties and methods of another class
```

### Real-Life Example

```text
Animal
  |
  +---- Dog
  +---- Cat
```

### ASCII Representation

```text
        +--------+
        | Animal |
        +--------+
            |
    ----------------
    |              |
+--------+     +--------+
|  Dog   |     |  Cat   |
+--------+     +--------+
```

### Pseudo Code

```text
class Animal:
    method eat()

class Dog extends Animal:
    method bark()
```

---

### 6.3 Polymorphism

```text
Definition:
One method behaves differently based on input
```

### Real-Life Example

```text
Same person:
- Office -> Developer
- Home   -> Parent
```

### ASCII Representation

```text
         add()
        /  |  \
       /   |   \
  add(2,3) add(2,3,4)
```

### Pseudo Code

```text
method add(a, b):
    return a + b

method add(a, b, c):
    return a + b + c
```

---

### 6.4 Abstraction

```text
Definition:
Showing only important details and hiding complexity
```

### Real-Life Example (Car Driving)

```text
Driver uses:
- Steering
- Brake
- Accelerator

Driver does NOT see:
- Engine internals
- Fuel system
```

### ASCII Representation

```text
User --> [ Car Interface ] --> Internal System

User sees: start(), stop()
Hidden: engine logic
```

### Pseudo Code

```text
abstract class Vehicle:
    abstract method start()

class Car extends Vehicle:
    method start():
        print("Car starts with key")
```

---

## 7. Simple Java Example

```java
class Car {
    String color;

    void drive() {
        System.out.println("Car is driving");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.color = "Red";
        car.drive();
    }
}
```

---

## 8. Visual Summary

```text
OOP = Encapsulation + Inheritance + Polymorphism + Abstraction
```

```text
Encapsulation  -> Data hiding
Inheritance    -> Code reuse
Polymorphism   -> One interface, many forms
Abstraction    -> Hide complexity
```

---

## 9. Common Mistakes

```text
- Confusing class and object
- Not relating concepts to real-world examples
- Memorizing definitions without understanding
```

---

## 10. Interview Tips

```text
- Always explain concepts using real-life examples
- Be clear on differences:
    Encapsulation vs Abstraction
- Understand WHY OOP is used
```

---

## Final Thought

```text
If you understand OOP deeply, you understand the foundation of Java.
Everything in Java builds on these concepts.
```

---
