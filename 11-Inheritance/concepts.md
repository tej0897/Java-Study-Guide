# Day 11: Inheritance

---

## Overview

```text
Goal:
Master inheritance and understand how to reuse code and build hierarchies

You will learn:
- What is inheritance
- Inheritance hierarchy
- Parent and child classes
- 'extends' keyword
- Method overriding
- Method overloading vs overriding
- Types of inheritance
- Single and multilevel inheritance
- Super keyword
- Real-world inheritance patterns
```

---

## Definitions

```text
Inheritance
  An OOP mechanism where a subclass reuses/extends the state and behavior of a superclass.

Superclass (parent/base class)
  The class being extended.

Subclass (child/derived class)
  The class that extends the superclass.

IS-A relationship
  A design relationship: if B extends A, then "B is an A".

Override
  A subclass provides a new implementation of a superclass method
  with the SAME signature.

super
  Refers to the parent part of the current object (constructor/method access).
```

---

## Real-life analogies

```text
Vehicle hierarchy
  Vehicle (common behavior) -> Car/Bike (specialized behavior)

Company roles
  Employee -> Developer/Manager
  Both share common fields (name/id) and add role-specific behavior.
```

---

## ASCII diagrams

```text
        +----------------+
        |    Vehicle     |
        +----------------+
        | start(), stop()|
        +----------------+
           ^          ^
           |          |
   +-------+--+   +---+-------+
   |   Car     |   |   Bike    |
   +-----------+   +-----------+
   | openTrunk |   | kickStart |
   +-----------+   +-----------+
```

---

## Code snippets

```java
class Vehicle {
    void start() { System.out.println("Vehicle starts"); }
}

class Car extends Vehicle {
    @Override
    void start() { System.out.println("Car starts with key"); }
}

Vehicle v = new Car();
v.start(); // prints: Car starts with key (runtime dispatch)
```

---

## Step-by-step explanations

```text
What happens when you call a method on a parent reference:

1) The reference type (Vehicle) decides what methods are accessible at compile time
2) The actual object type (Car) decides which overridden implementation runs at runtime

This behaviour is called dynamic dispatch and is the base of runtime polymorphism.
```

---

## Edge cases / common mistakes

```text
1) Misusing inheritance where composition fits better
   If it is not a true IS-A relationship, prefer composition (HAS-A).

2) Forgetting @Override
   Without it, you might overload by mistake (different signature).

3) Calling overridden methods from constructors
   Avoid calling overridable methods inside constructors; the child might not be initialized yet.

4) Access modifiers in override
   You cannot reduce visibility when overriding (public -> cannot become protected/private).
```

---

## Interview tips

```text
Q) Difference between overloading and overriding?
A) Overloading: same name, different params (compile-time).
   Overriding : same signature, different implementation (runtime).

Q) Why do we use super()?
A) To initialize the superclass part of the object.

Q) Can Java support multiple inheritance?
A) Not for classes. Java supports multiple inheritance of type via interfaces.
```

---

## Summary

```text
+-------------------+----------------------------------------------+
| Topic             | Key point                                     |
+-------------------+----------------------------------------------+
| Inheritance       | reuse + specialization (IS-A)                 |
| extends           | creates parent-child relationship             |
| Override          | same signature, different implementation      |
| super             | access parent state/constructor/method        |
| Best practice     | prefer composition if not a true IS-A         |
+-------------------+----------------------------------------------+
```

## 1. What is Inheritance?

```text
Inheritance is a mechanism where a class inherits (acquires)
properties and methods from another class.

Key Idea:
Code reuse through class hierarchy
```

### Real-Life Analogy

```text
Think of a family:

Grandfather (Grandparent)
    ↓
Father (Parent) - inherits traits from Grandfather
    ↓
Son (Child) - inherits traits from Father

Similarly in Java:
Animal (Parent) → Dog (Child)
Dog inherits: eat(), sleep()
Dog adds: bark()
```

---

## 2. Inheritance Terminology

```text
+--------------------+--------------------------------------+
| Term               | Meaning                              |
+--------------------+--------------------------------------+
| Parent Class       | Class being inherited from (base)    |
| Child Class        | Class inheriting from parent         |
| Superclass         | Another name for parent class        |
| Subclass           | Another name for child class         |
| Inheritance        | Process of acquiring properties      |
| extends            | Keyword used for inheritance         |
+--------------------+--------------------------------------+
```

---

## 3. Basic Inheritance Syntax

### Parent Class (Superclass)

```java
class Animal {
    String name;
    
    Animal(String name) {
        this.name = name;
    }
    
    void eat() {
        System.out.println(name + " is eating");
    }
}
```

### Child Class (Subclass)

```java
class Dog extends Animal {
    // Inherits: name, eat()
    // Adds new behavior
    
    void bark() {
        System.out.println(name + " barks");
    }
}
```

### Using Child Class

```java
Dog dog = new Dog("Buddy");
dog.eat();   // Inherited method
dog.bark();  // New method
```

---

## 4. Inheritance Hierarchy

### Single Inheritance

```text
      Vehicle (Parent)
           ↑
           |
           |
         Car (Child)
```

### Multilevel Inheritance

```text
      Vehicle (Level 1)
           ↑
           |
         Car (Level 2)
           ↑
           |
      SportsCar (Level 3)
```

### Hierarchical Inheritance

```text
         Animal (Parent)
        /        |        \
       /         |         \
     Dog       Cat       Bird (Children)
```

---

## 5. Method Overriding

### What is Method Overriding?

```text
When child class provides different implementation
of a method that exists in parent class.

Same method name
Same parameters
Different body
```

### Example

```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override  // Annotation (optional but recommended)
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

// Usage
Animal dog = new Dog();
dog.sound();  // "Dog barks"

Animal cat = new Cat();
cat.sound();  // "Cat meows"
```

---

## 6. 'super' Keyword

### What is 'super'?

```text
'super' refers to the parent class.
Used to:
1. Call parent constructor
2. Call parent method
3. Access parent properties
```

### Using 'super' to Call Parent Constructor

```java
class Animal {
    String name;
    
    Animal(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    String breed;
    
    Dog(String name, String breed) {
        super(name);  // Calls parent constructor
        this.breed = breed;
    }
}
```

### Using 'super' to Call Parent Method

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        super.sound();  // Calls parent method
        System.out.println("Dog barks");
    }
}

// Output:
// Animal sound
// Dog barks
```

---

## 7. Constructor Inheritance

### Default Constructor Chain

```text
When child object is created:
1. Child constructor called
2. Parent constructor automatically called
3. Initialization goes bottom-to-top in hierarchy
```

### Example

```java
class Vehicle {
    Vehicle() {
        System.out.println("Vehicle constructor");
    }
}

class Car extends Vehicle {
    Car() {
        System.out.println("Car constructor");
    }
}

Car car = new Car();

// Output:
// Vehicle constructor (parent called first)
// Car constructor (child called next)
```

---

## 8. Types of Inheritance

### Single Inheritance

```text
One parent, one child

         Parent
           ↑
           |
          Child
```

### Multilevel Inheritance

```text
Chain of inheritance

      Grandparent
           ↑
           |
         Parent
           ↑
           |
          Child
```

### Hierarchical Inheritance

```text
One parent, multiple children

         Parent
        /  |  \
       /   |   \
     C1   C2   C3
```

### Note: Multiple Inheritance

```text
Java does NOT support multiple inheritance directly

❌ WRONG:
class Car extends Vehicle, Transport { }

✓ RIGHT: Use interfaces (learned later)
```

---

## 9. Method Overloading vs Overriding

### Comparison Table

```text
+------------------+------------------+------------------+
| Feature          | Overloading      | Overriding       |
+------------------+------------------+------------------+
| Occurs in        | Same class       | Parent & child   |
| Method name      | SAME             | SAME             |
| Parameters       | Different        | SAME             |
| Return type      | Can differ       | MUST be same     |
| Access modifier  | Can differ       | Same or broader  |
| Purpose          | Flexibility      | Polymorphism     |
+------------------+------------------+------------------+
```

### Overloading Example

```java
class Calculator {
    // Same method name, different parameters
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```

### Overriding Example

```java
class Animal {
    void sound() { System.out.println("Sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Bark"); }
}
```

---

## 10. Inheritance and Access Modifiers

### Protected Access

```text
Protected members are accessible in:
1. Same class (private scope)
2. Same package
3. Child class (even different package)
```

### Example

```java
class Vehicle {
    protected String color;  // Accessible in child class
    private int speed;       // NOT accessible in child class
    
    protected void start() {
        System.out.println("Vehicle started");
    }
}

class Car extends Vehicle {
    void displayColor() {
        System.out.println(color);    // OK: protected
        // System.out.println(speed);  // ERROR: private
    }
    
    void customStart() {
        start();  // OK: protected
    }
}
```

---

## 11. Real-Life Example: Bank Accounts

```java
class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected String accountHolder;
    
    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    protected void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }
    
    protected void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
    }
    
    double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    
    SavingsAccount(String accountNumber, String accountHolder, double balance, double rate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = rate;
    }
    
    void applyInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
        System.out.println("Interest applied: $" + interest);
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    
    CheckingAccount(String accountNumber, String accountHolder, double balance, double limit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = limit;
    }
    
    @Override
    protected void withdraw(double amount) {
        if (amount <= (balance + overdraftLimit)) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Exceeds overdraft limit");
        }
    }
}

// Usage
SavingsAccount savings = new SavingsAccount("SA123", "John", 5000, 5);
savings.deposit(1000);
savings.applyInterest();
System.out.println("Balance: $" + savings.getBalance());

CheckingAccount checking = new CheckingAccount("CA456", "Jane", 2000, 500);
checking.withdraw(2300);  // OK: within overdraft
checking.withdraw(2800);  // ERROR: exceeds overdraft
```

---

## 12. Object Class (Ultimate Parent)

### Implicit Inheritance

```text
Every class in Java implicitly extends Object class

class Dog extends Animal { }

Is equivalent to:

class Animal extends Object { }
class Dog extends Animal { }
```

### Common Object Methods

```text
+--------------------+---------------------------------------+
| Method             | Purpose                               |
+--------------------+---------------------------------------+
| toString()         | String representation of object       |
| equals()           | Compare two objects                   |
| hashCode()         | Get hash code                         |
| getClass()         | Get runtime class                     |
+--------------------+---------------------------------------+
```

---

## 13. Method Resolution Order (MRO)

### How Java Finds Methods

```text
When you call a method:
1. Look in child class first
2. If not found, look in parent class
3. If not found, look in parent's parent
4. Continue until Object class
5. If still not found → CompileError

This is called "method lookup path"
```

### Example

```java
class A {
    void display() { System.out.println("A"); }
}

class B extends A {
    void display() { System.out.println("B"); }
}

B b = new B();
b.display();  // Output: "B" (found in B first)
```

---

## 14. Edge Cases and Common Mistakes

### Mistake 1: Forgetting super() in Constructor

```java
// WRONG: Parent constructor not called
class Dog extends Animal {
    Dog(String name) {
        // Animal constructor not called
        // name is not initialized
    }
}

// RIGHT: Call parent constructor
class Dog extends Animal {
    Dog(String name) {
        super(name);  // Parent initialized
    }
}
```

---

### Mistake 2: Not Using @Override Annotation

```java
// WRONG: Typo in method name (no error, just different method)
class Dog extends Animal {
    void sound() { }  // Override
    void soun() { }   // Typo! Not override
}

// RIGHT: Use annotation to catch errors
class Dog extends Animal {
    @Override
    void sound() { }  // Compiler checks this overrides parent
}
```

---

### Mistake 3: Changing Return Type

```java
// WRONG: Cannot change return type
class Animal {
    Animal makeSound() { return this; }
}

class Dog extends Animal {
    String makeSound() { return "bark"; }  // COMPILE ERROR!
}

// RIGHT: Keep same return type
class Dog extends Animal {
    @Override
    Animal makeSound() { return this; }
}
```

---

## 15. Interview Tips

```text
1. Inheritance definition
   - Code reuse through hierarchy
   - Parent provides base, child extends

2. Difference from composition
   - Inheritance: IS-A relationship
   - Composition: HAS-A relationship

3. Method overriding
   - Same name and parameters
   - Different implementation
   - Polymorphic behavior

4. Super keyword usage
   - Call parent constructor: super()
   - Call parent method: super.method()
   - Access parent property: super.property

5. Access modifiers in inheritance
   - protected: accessible in child class
   - private: NOT accessible in child class
   - public: accessible everywhere

6. Constructor chain
   - Child constructor calls parent constructor
   - Goes up hierarchy until Object

7. Common mistakes
   - Forgetting super() call
   - Changing return type
   - Typo in method name (forgetting @Override)

8. When to use inheritance
   - When classes have IS-A relationship
   - When code reuse makes sense
   - When creating hierarchy
```

---

## 16. Key Takeaways

```text
- Inheritance enables code reuse through class hierarchy
- Child class inherits properties and methods of parent
- 'extends' keyword used for inheritance
- Method overriding allows child to provide different behavior
- 'super' keyword refers to parent class
- Constructor automatically calls parent constructor
- Use @Override annotation for safety
- Single, multilevel, hierarchical inheritance are common patterns
- protected makes members accessible in child class
- Multiple inheritance not supported (interfaces used instead)
```

---

## 17. Common Mistakes to Avoid

```text
❌ Changing method signature during override
   ✓ Keep parameters and return type same

❌ Forgetting to call super() in constructor
   ✓ Always initialize parent

❌ Using private for inherited behavior
   ✓ Use protected for methods meant to be overridden

❌ Not using @Override annotation
   ✓ Always use @Override to catch typos

❌ Confusing inheritance with composition
   ✓ Inheritance: IS-A, Composition: HAS-A

❌ Assuming you can modify parent class features
   ✓ Child cannot access private members
```

---

## Final Thought

```text
Inheritance is the cornerstone of object-oriented programming.
It enables building complex systems from simple, reusable components.
Master inheritance, and you master OOP.
```

---


