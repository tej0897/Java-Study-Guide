# Day 1: Introduction to Java and OOP Concepts

---

## 1. What is Java?

Java is a high-level, object-oriented programming language used to build applications such as web apps, mobile apps, and enterprise systems.

### Key Features:

* Platform independent (Write Once, Run Anywhere)
* Object-Oriented
* Secure and robust
* Widely used in backend development

---

## 2. Why Java?

Java is popular because:

* It is easy to learn for beginners
* It is used in real-world applications (banking systems, enterprise software)
* It has strong community support
* It is widely used in frameworks like Spring Boot

---

## 3. What is Object-Oriented Programming (OOP)?

Object-Oriented Programming is a way of designing programs using **objects and classes**.

Instead of writing everything as functions, we model real-world entities as objects.

---

## 4. Real-Life Example to Understand OOP

Consider a **Car**.

* Car → Class
* BMW, Audi → Objects
* Color, Speed → Properties (variables)
* Drive(), Brake() → Methods (functions)

### Simple Understanding:

A class is a blueprint, and an object is a real-world instance of that blueprint.

---

## 5. Four Pillars of OOP

---

### 5.1 Encapsulation

Encapsulation means **hiding data and allowing access through methods only**.

#### Real-Life Example:

Think of an ATM machine.

* You cannot directly access your bank balance.
* You must use operations like "check balance".

#### Key Idea:

* Data is private
* Access is controlled

#### Pseudo Code:

```
class BankAccount:
    private balance

    method getBalance():
        return balance

    method deposit(amount):
        balance = balance + amount
```

---

### 5.2 Inheritance

Inheritance means **one class can use properties and methods of another class**.

#### Real-Life Example:

A Dog is an Animal.

* Dog inherits behavior like eat(), sleep() from Animal.

#### Key Idea:

* Reusability of code

#### Pseudo Code:

```
class Animal:
    method eat()

class Dog extends Animal:
    method bark()
```

---

### 5.3 Polymorphism

Polymorphism means **one action can behave differently in different situations**.

#### Real-Life Example:

A person can:

* Work as a Developer at office
* Act as a Parent at home

Same person, different behavior.

#### Types:

* Compile-time (method overloading)
* Runtime (method overriding)

#### Pseudo Code:

```
method add(a, b):
    return a + b

method add(a, b, c):
    return a + b + c
```

---

### 5.4 Abstraction

Abstraction means **showing only essential details and hiding complexity**.

#### Real-Life Example:

When you drive a car:

* You use steering, brake, accelerator
* You do not know how the engine works internally

#### Key Idea:

* Focus on what to do, not how it works

#### Pseudo Code:

```
abstract class Vehicle:
    abstract method start()

class Car extends Vehicle:
    method start():
        print("Car starts with key")
```

---

## 6. Class vs Object

| Concept | Meaning               |
| ------- | --------------------- |
| Class   | Blueprint or template |
| Object  | Instance of a class   |

### Example:

* Class: Car
* Object: BMW, Audi

---

## 7. Simple Java Example

```
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

## 8. Key Takeaways

* Java is an object-oriented language
* Everything revolves around classes and objects
* OOP helps in writing clean and reusable code
* The four pillars are fundamental for any Java developer

---

## 9. Common Mistakes

* Treating class and object as the same
* Not understanding real-life mapping of OOP concepts
* Jumping to advanced topics without strong basics

---

## 10. Interview Tips

* Always explain OOP with real-life examples
* Be clear on the difference between abstraction and encapsulation
* Understand "why" OOP is used, not just definitions

---
