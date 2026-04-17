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
# Day 1: Introduction to Java and OOP Concepts

---

## Overview

```text
Goal:
Build a correct mental model of Java and Object-Oriented Programming (OOP).

By the end of this day you should be able to:
- Explain what Java is and why it is platform-independent
- Explain how a .java file becomes a running program
- Distinguish class vs object vs reference
- Explain and recognize the 4 pillars of OOP
- Read and write small Java programs confidently
```

---

## Definitions

```text
Java
  A high-level, class-based programming language.
  Source code (.java) compiles to bytecode (.class).

JDK (Java Development Kit)
  Tools to DEVELOP Java applications (javac, java, javadoc, etc.).

JRE (Java Runtime Environment)
  Everything needed to RUN Java applications (includes a JVM and libraries).

JVM (Java Virtual Machine)
  The "engine" that executes Java bytecode on a specific OS/CPU.

Class
  A blueprint: defines fields (data) and methods (behavior).

Object
  A runtime instance of a class; occupies memory.

Reference
  A variable that points to an object (holds an address-like handle).

OOP (Object-Oriented Programming)
  A way to model software using interacting objects.
```

---

## Real-life analogies

```text
Class vs Object
  Class  = Blueprint of a car model
  Object = An actual car built from that blueprint

Reference
  Reference = A parking ticket number
  Object    = The actual car parked somewhere

Encapsulation
  ATM machine: you cannot touch bank database tables directly.
  You must use actions (withdraw/deposit/checkBalance).

Inheritance
  "ElectricCar" is a specialized type of "Car".

Polymorphism
  Same action name ("pay") works differently:
    pay(Cash)
    pay(Card)
    pay(UPI)

Abstraction
  Driving a car: you interact with steering + pedals.
  You do not manage fuel injection and spark timing manually.
```

---

## ASCII diagrams

### How Java runs (very simplified)

```text
  Source code              Bytecode             Running

  Hello.java     javac     Hello.class      java Hello
      |            |           |                |
      v            v           v                v
  (human)     (compiler)     (portable)       (JVM)
```

### Class, object, reference

```text
Car class (blueprint)
  fields: color, speed
  methods: drive()

Reference variable (on stack):
  carRef  ----->  [Car object in heap]
                 color = "Red"
                 speed = 60
```

### 4 pillars (map)

```text
OOP
 |
 +-- Encapsulation: control access to state
 |
 +-- Inheritance   : reuse + specialization
 |
 +-- Polymorphism  : "one name, many forms"
 |
 +-- Abstraction   : expose WHAT, hide HOW
```

---

## Code snippets

### Smallest runnable Java program

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### Class + object + method call

```java
final class Car {
    String color;
    int speed;

    void drive() {
        System.out.println("Driving at " + speed + " km/h");
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.color = "Red";
        car.speed = 60;
        car.drive();
    }
}
```

---

## Step-by-step explanations

### Step-by-step: running a Java program

```text
1) Write source code: HelloWorld.java
2) Compile: javac HelloWorld.java
     - produces: HelloWorld.class
3) Run: java HelloWorld
     - JVM loads the class
     - finds main(String[] args)
     - executes your instructions
```

### Step-by-step: class vs object

```text
1) class Car { ... } defines a type
2) new Car() creates an object in memory
3) a reference variable holds "where" that object is
4) car.drive() calls behavior ON that object
```

### Step-by-step: the 4 pillars with minimal examples

```text
Encapsulation
  - Make fields private
  - Expose behavior via methods

Inheritance
  - A child class extends a parent class

Polymorphism
  - Overloading (compile-time): same method name, different params
  - Overriding (runtime): child redefines parent method behavior

Abstraction
  - Define a contract (interface / abstract class)
  - Implement the details in a concrete class
```

---

## Edge cases / common mistakes

```text
1) "Java is purely OOP" (common claim)
   Java has primitive types (int, boolean, char) which are not objects.
   Wrapper types (Integer, Boolean, Character) are objects.

2) Confusing == vs .equals() (will become critical later)
   == compares references for objects, not their content.

3) File naming rule
   If a file has a public class, the filename must match the public class.
     public class App { }  -> App.java

4) main method signature must be exact
   public static void main(String[] args)

5) Thinking "reference" is the object
   The reference is not the object; it points to the object.
```

---

## Interview tips

```text
Be ready to answer these confidently:

Q) Why is Java platform-independent?
A) Java compiles to bytecode (.class). JVM exists on each platform and
   executes the same bytecode.

Q) Encapsulation vs Abstraction?
A) Encapsulation controls access to state (private fields + methods).
   Abstraction hides implementation details and exposes a contract.

Q) Compile-time vs runtime polymorphism?
A) Compile-time: method overloading.
   Runtime: method overriding + dynamic dispatch.
```

---

## Summary

```text
+----------------------+----------------------------------------------+
| Topic                | What to remember                              |
+----------------------+----------------------------------------------+
| Java                 | Compile to bytecode, run on JVM               |
| Class                | Blueprint (definition)                        |
| Object               | Instance (runtime memory)                     |
| Reference            | Handle pointing to an object                  |
| Encapsulation        | Protect state, provide controlled access       |
| Inheritance          | Reuse + specialization                         |
| Polymorphism         | Same name, different behavior                 |
| Abstraction          | Hide how, show what                            |
+----------------------+----------------------------------------------+
```
