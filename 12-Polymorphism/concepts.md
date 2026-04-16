# Day 12: Polymorphism

---

## Overview

```text
Goal:
Master polymorphism and understand how to write flexible, extensible code

You will learn:
- What is polymorphism
- Compile-time polymorphism (Method Overloading)
- Runtime polymorphism (Method Overriding)
- Parent-child references
- Polymorphic method calls
- Benefits of polymorphism
- Real-world polymorphism patterns
```

---

## 1. What is Polymorphism?

```text
Polymorphism means "many forms"

Same object behaves differently based on context.
Same method name, different behavior.
```

### Real-Life Analogy

```text
Same person, different roles:
- At office → Developer
- At home → Parent
- At gym → Athlete

Same person, different behavior depending on context
```

---

## 2. Types of Polymorphism

```text
+------------------------+-------------------------+
| Type                   | When                    |
+------------------------+-------------------------+
| Compile-time           | Compile time (overload) |
| Runtime                | Runtime (override)      |
+------------------------+-------------------------+
```

---

## 3. Compile-Time Polymorphism (Method Overloading)

```text
Same method name, different parameters
Method selected at COMPILE time
```

### Example

```java
class Calculator {
    // add(int, int)
    int add(int a, int b) {
        return a + b;
    }
    
    // add(double, double)
    double add(double a, double b) {
        return a + b;
    }
    
    // add(int, int, int)
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

// Compile time decides which to call
calc.add(5, 10);           // Calls add(int, int)
calc.add(5.5, 10.5);       // Calls add(double, double)
calc.add(5, 10, 15);       // Calls add(int, int, int)
```

---

## 4. Runtime Polymorphism (Method Overriding)

```text
Child class overrides parent method
Method selected at RUNTIME based on actual object type
```

### Example

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}

// Runtime decides based on actual object
Animal a1 = new Dog();
a1.sound();  // Calls Dog.sound() → "Bark"

Animal a2 = new Cat();
a2.sound();  // Calls Cat.sound() → "Meow"
```

---

## 5. Parent-Child Reference

### Key Concept

```text
Parent reference can point to child object
But the actual behavior is child's
```

### Example

```java
Animal dog = new Dog();    // Parent ref, child object
dog.sound();               // Calls Dog.sound()

Dog actualDog = (Dog) dog; // Casting to child type
```

---

## 6. Polymorphic Collections

```text
Store multiple child objects in parent array
```

### Example

```java
Animal[] animals = new Animal[3];
animals[0] = new Dog();
animals[1] = new Cat();
animals[2] = new Lion();

// Loop and call polymorphic method
for (Animal animal : animals) {
    animal.sound();  // Each calls its own version
}

// Output:
// Bark
// Meow
// Roar
```

---

## 7. Benefits of Polymorphism

### Benefit 1: Flexibility

```java
// Without polymorphism (rigid)
if (animal instanceof Dog) {
    Dog dog = (Dog) animal;
    dog.sound();
} else if (animal instanceof Cat) {
    Cat cat = (Cat) animal;
    cat.sound();
}

// With polymorphism (flexible)
animal.sound();  // Works for any animal
```

---

### Benefit 2: Extensibility

```java
// Easy to add new animals without changing code
class Parrot extends Animal {
    @Override
    void sound() {
        System.out.println("Squawk");
    }
}

// Existing code still works
animals[2] = new Parrot();  // Just works!
```

---

### Benefit 3: Maintainability

```text
Changes in one child class don't affect others
Code stays clean and organized
```

---

## 8. Method Overloading vs Overriding

```text
+------------------+------------------+------------------+
| Feature          | Overloading      | Overriding       |
+------------------+------------------+------------------+
| Inheritance      | Not needed       | Parent & child   |
| Binding time     | Compile-time     | Runtime          |
| Method name      | SAME             | SAME             |
| Parameters       | Different        | SAME             |
| Return type      | Can differ       | Must be same     |
| Polymorphism     | Compile-time     | Runtime          |
+------------------+------------------+------------------+
```

---

## 9. Real-Life Example: Payment Systems

```java
abstract class PaymentMethod {
    abstract void processPayment(double amount);
    abstract void refund(double amount);
}

class CreditCard extends PaymentMethod {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing CC payment: $" + amount);
    }
    
    @Override
    void refund(double amount) {
        System.out.println("Credit card refund: $" + amount);
    }
}

class PayPal extends PaymentMethod {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
    
    @Override
    void refund(double amount) {
        System.out.println("PayPal refund: $" + amount);
    }
}

// Usage
PaymentMethod payment1 = new CreditCard();
PaymentMethod payment2 = new PayPal();

payment1.processPayment(100);  // Calls CreditCard version
payment2.processPayment(100);  // Calls PayPal version
```

---

## 10. Type Casting

### Upcasting (Implicit)

```java
Dog dog = new Dog();
Animal animal = dog;  // Upcasting (automatic)
```

---

### Downcasting (Explicit)

```java
Animal animal = new Dog();
Dog dog = (Dog) animal;  // Downcasting (explicit)
```

---

### instanceof Check

```java
if (animal instanceof Dog) {
    Dog dog = (Dog) animal;  // Safe casting
}
```

---

## 11. Late Binding

```text
Method call resolved at runtime based on object type
Not known at compile time
```

### Example

```java
Animal animal = getAnimal();  // Don't know what animal

animal.sound();  // Resolved at runtime
// Actual type determines which sound() is called
```

---

## 12. Common Mistakes

### Mistake 1: Forgetting @Override

```java
// WRONG: Typo, not override
class Dog extends Animal {
    void soun() { }  // Not override!
}

// RIGHT: Use @Override
class Dog extends Animal {
    @Override
    void sound() { }  // Compiler checks
}
```

---

### Mistake 2: Unsafe Casting

```java
// WRONG: No check
Animal animal = new Dog();
Cat cat = (Cat) animal;  // ClassCastException!

// RIGHT: Check first
if (animal instanceof Cat) {
    Cat cat = (Cat) animal;
}
```

---

## 13. Interview Tips

```text
1. Polymorphism definition
   - Many forms, same interface

2. Compile-time vs Runtime
   - Overloading: Compile-time
   - Overriding: Runtime

3. Parent-child references
   - Parent can point to child
   - Behavior is child's (runtime binding)

4. Benefits
   - Flexibility, extensibility, maintainability

5. Real-world example
   - Different payment methods
   - Different database implementations
   - Different shapes in graphics

6. Type casting
   - Upcasting: automatic
   - Downcasting: explicit, needs instanceof check

7. Late binding
   - Method resolved at runtime
   - Based on actual object type

8. Practical usage
   - Polymorphic collections
   - Substituting implementations
   - Plugin architectures
```

---

## 14. Key Takeaways

```text
- Polymorphism enables same interface, multiple behaviors
- Compile-time polymorphism through method overloading
- Runtime polymorphism through method overriding
- Parent reference can hold child object
- Actual behavior determined at runtime
- Benefits: flexibility, extensibility, maintainability
- Use instanceof before downcasting
- Late binding resolves methods at runtime
```

---

## Final Thought

```text
Polymorphism is the power of object-oriented programming.
It allows you to write code that works with multiple types
without knowing the specific type at compile time.
Master it, and your code becomes truly flexible.
```

---


