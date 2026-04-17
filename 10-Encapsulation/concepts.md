# Day 10: Encapsulation

---

## Overview

```text
Goal:
Master the art of hiding internal details and exposing only what's necessary

You will learn:
- What is encapsulation
- Access modifiers (private, public, protected, default)
- Getters and Setters
- Benefits of encapsulation
- When to use each access modifier
- Real-world encapsulation patterns
- Data validation through encapsulation
```

---

## Definitions

```text
Encapsulation
  Bundling data (fields) + behavior (methods) in one unit (class) while
  hiding internal state and exposing a controlled public API.

Data hiding
  Keeping fields private so they cannot be modified directly.

Getter / Setter
  Methods that read or update state with validation and rules.

Invariant
  A rule that must always be true for an object (e.g., balance >= 0).
```

---

## Real-life analogies

```text
Car dashboard
  You can increase speed using the pedal.
  You cannot directly mutate the engine internals.

Bank account
  You cannot set balance directly.
  You must use deposit/withdraw which enforce rules.
```

---

## ASCII diagrams

```text
Without encapsulation (bad)
  account.balance = -999999;   // anyone can break rules

With encapsulation (good)
  +------------------------+
  | BankAccount            |
  +------------------------+
  | - balance (private)    |
  +------------------------+
  | + deposit(amount)      |
  | + withdraw(amount)     |
  | + getBalance()         |
  +------------------------+
```

---

## Code snippets

```java
class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount must be > 0");
        balance += amount;
    }
}
```

---

## Step-by-step explanations

```text
How to encapsulate a class (practical checklist):

1) Make fields private
2) Decide the valid range/format for values (invariants)
3) Provide public methods (getters/setters or domain methods)
4) Validate inputs before updating state
5) Keep object always valid (fail fast on invalid input)

Tip:
Prefer domain methods (deposit/withdraw) over raw setters (setBalance).
```

---

## Edge cases / common mistakes

```text
1) "Encapsulation = getters/setters"
   Not exactly. Encapsulation is controlled access; sometimes you expose
   behavior methods instead of setters.

2) Leaking internal mutable objects
   Returning internal lists directly breaks encapsulation.
   Prefer unmodifiable views / defensive copies.

3) Validation only in UI layer
   Validation must also exist in domain methods to protect the object.
```

---

## Interview tips

```text
Q) Why make fields private?
A) To protect invariants and allow future internal changes without breaking callers.

Q) Encapsulation vs Abstraction?
A) Encapsulation: protect state via controlled access.
   Abstraction: expose what, hide how (interface/abstract class).
```

---

## Summary

```text
+-------------------+----------------------------------------------+
| Topic             | Key point                                     |
+-------------------+----------------------------------------------+
| Encapsulation     | data hiding + controlled access               |
| private fields    | protects invariants                           |
| getters/setters   | controlled reads/writes with validation        |
| best practice     | prefer domain methods over raw setters        |
+-------------------+----------------------------------------------+
```

## 1. What is Encapsulation?

```text
Encapsulation is the bundling of data (properties) and methods (behavior)
into a single unit (class), while hiding internal details.

It's about:
✓ Data hiding
✓ Controlled access
✓ Protection from misuse
```

### Real-Life Analogy

```text
Think of a Car:

User sees:
- Steering wheel
- Brake pedal
- Accelerator
- Dashboard

User does NOT see:
- Engine internals
- Fuel system
- Electrical wiring

This is encapsulation: Hide complex details, expose simple interface.
```

---

## 2. Access Modifiers

### Types of Access Modifiers

```text
+------------------+-----------+----------+----------+
| Modifier         | Same Class| Package  | Subclass | World |
+------------------+-----------+----------+----------+
| public           | Yes       | Yes      | Yes      | Yes   |
| protected        | Yes       | Yes      | Yes      | No    |
| default (none)   | Yes       | Yes      | No       | No    |
| private          | Yes       | No       | No       | No    |
+------------------+-----------+----------+----------+
```

---

## 3. Public Access Modifier

### What is Public?

```text
Public modifier means:
- Accessible from anywhere
- No restrictions
- Use for interface that should be open
```

### Example

```java
class Student {
    public String name;  // Can be accessed from anywhere
    
    public void study() {  // Can be called from anywhere
        System.out.println(name + " is studying");
    }
}

// From any other class
Student s = new Student();
s.name = "Tejas";      // Direct access
s.study();             // Direct call
```

### When to Use Public?

```text
✓ Methods that form external interface
✓ Getter methods
✓ Public API
```

---

## 4. Private Access Modifier

### What is Private?

```text
Private modifier means:
- Accessible ONLY within the same class
- Completely hidden from outside
- Use for internal implementation
```

### Example

```java
class BankAccount {
    private double balance;      // Only accessible in this class
    
    private boolean validateAmount(double amount) {  // Only for internal use
        return amount > 0;
    }
}

// From outside the class
BankAccount account = new BankAccount();
// account.balance = 1000;       // COMPILE ERROR! Private
// account.validateAmount(100);  // COMPILE ERROR! Private
```

---

### When to Use Private?

```text
✓ Internal properties that should not be changed directly
✓ Helper methods used only within class
✓ Implementation details
✓ Sensitive data
```

---

## 5. Default Access Modifier

### What is Default (Package-Private)?

```text
Default modifier (no modifier specified):
- Accessible within same package
- NOT accessible outside package
- Rarely used in professional code
```

### Example

```java
package com.company;

class Car {  // Default access
    String color;  // Default access
    
    void drive() {  // Default access
    }
}

// In same package: ACCESSIBLE
// In different package: NOT ACCESSIBLE
```

---

## 6. Protected Access Modifier

### What is Protected?

```text
Protected modifier means:
- Accessible within same package
- Accessible in subclasses (even outside package)
- Used with inheritance
```

### Example

```java
package animals;

class Animal {
    protected String name;  // Accessible in subclasses
}

package humans;

class Human extends Animal {  // Subclass
    void displayName() {
        System.out.println(name);  // CAN access protected
    }
}
```

---

## 7. Getters (Accessor Methods)

### What is a Getter?

```text
A getter is a method that READS a property value.
Allows controlled read-only access.
```

### Syntax

```java
private String name;

// Getter
String getName() {
    return name;
}
```

### Why Use Getters?

```text
✓ Controlled access to private data
✓ Can add logic before returning
✓ Allows read-only access
✓ Encapsulation
```

---

### Example

```java
class Student {
    private int age;
    
    // Getter
    int getAge() {
        return age;
    }
}

Student s = new Student();
System.out.println(s.getAge());  // Controlled read access
```

---

## 8. Setters (Mutator Methods)

### What is a Setter?

```text
A setter is a method that WRITES a property value.
Allows controlled write access with validation.
```

### Syntax

```java
private String email;

// Setter
void setEmail(String email) {
    this.email = email;
}
```

### Why Use Setters?

```text
✓ Validation before setting value
✓ Controlled write access
✓ Can add side effects
✓ Encapsulation
```

---

### Example: Setter with Validation

```java
class User {
    private int age;
    
    // Setter with validation
    void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }
    
    int getAge() {
        return age;
    }
}

User user = new User();
user.setAge(25);    // OK: valid
user.setAge(-5);    // Rejected: invalid
```

---

## 9. Benefits of Encapsulation

### Benefit 1: Data Protection

```java
class BankAccount {
    private double balance;
    
    // Controlled access
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdrawal");
        }
    }
}

// User cannot directly set balance to wrong value
// Can only withdraw through controlled method
```

---

### Benefit 2: Maintainability

```java
class Student {
    private int age;
    
    int getAge() {
        return age;
    }
}

// Later: Can change internal calculation without affecting users
int getAge() {
    return calculateAgeFromDateOfBirth();
}

// Users still call same method, don't care about internal change
```

---

### Benefit 3: Flexibility

```java
class Circle {
    private double radius;
    
    // User sets radius
    void setRadius(double r) {
        if (r > 0) {
            radius = r;
        }
    }
    
    // Internal calculation (user doesn't need to know)
    double getArea() {
        return Math.PI * radius * radius;
    }
}
```

---

### Benefit 4: Validation

```java
class Email {
    private String email;
    
    void setEmail(String email) {
        // Validation in one place
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("Invalid email format");
        }
    }
}
```

---

## 10. Complete Encapsulation Example

```java
class Employee {
    // Private properties
    private String name;
    private int age;
    private double salary;
    
    // Constructor
    Employee(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }
    
    // Getters (Read-only access)
    String getName() {
        return name;
    }
    
    int getAge() {
        return age;
    }
    
    double getSalary() {
        return salary;
    }
    
    // Setters (Write with validation)
    void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name");
        }
    }
    
    void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        } else {
            System.out.println("Invalid age for employment");
        }
    }
    
    void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative");
        }
    }
    
    // Business method
    void giveRaise(double percent) {
        if (percent > 0) {
            salary = salary * (1 + percent / 100);
        }
    }
}

// Usage
Employee emp = new Employee("Tejas", 25, 50000);
emp.giveRaise(10);  // 10% raise
System.out.println(emp.getSalary());  // 55000

// Invalid attempts (rejected)
emp.setAge(-5);        // Rejected
emp.setSalary(-1000);  // Rejected
```

---

## 11. Immutable Objects with Encapsulation

### What is Immutable Encapsulation?

```text
Immutable: Once created, cannot be changed
Properties: private final
No setters: Only getters
```

### Example

```java
class Point {
    private final int x;
    private final int y;
    
    // Constructor: only way to set values
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Only getters, NO setters
    int getX() {
        return x;
    }
    
    int getY() {
        return y;
    }
}

Point p = new Point(5, 10);
// p.x = 20;  // COMPILE ERROR! final and private
// p.setX(20);  // ERROR! No setter exists
```

---

### Why Immutable?

```text
✓ Thread-safe (no synchronization needed)
✓ Cannot be corrupted
✓ Safe for use as map keys
✓ Predictable behavior
```

---

## 12. Encapsulation in Inheritance

### Protected Visibility

```java
class Animal {
    protected String name;  // Accessible in subclasses
    private int age;        // NOT accessible in subclasses
    
    protected void sound() {
        System.out.println(name + " makes sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println(name + " barks");  // OK: protected
        // System.out.println(age);  // ERROR: private
    }
}
```

---

## 13. Design Pattern: JavaBean

```text
JavaBean is a Java class with:
1. Private properties
2. Public getters and setters
3. No-argument constructor
4. Implements common conventions
```

### Example

```java
class Person {
    private String firstName;
    private String lastName;
    private int age;
    
    // No-argument constructor
    public Person() {
    }
    
    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
```

---

## 14. Real-Life Example: Bank Account

```java
class SecureBankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private static final double MIN_BALANCE = 100;
    
    SecureBankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0;
    }
    
    String getAccountNumber() {
        return accountNumber;
    }
    
    double getBalance() {
        return balance;
    }
    
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Cannot withdraw: Insufficient balance");
        }
    }
}
```

---

## 15. Common Mistakes to Avoid

### Mistake 1: Public Properties

```java
// WRONG: No encapsulation
class Car {
    public int speed;
}

car.speed = -100;  // Invalid state possible!

// RIGHT: Encapsulated
class Car {
    private int speed;
    
    void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
    }
}
```

---

### Mistake 2: No Validation in Setters

```java
// WRONG: No validation
void setAge(int age) {
    this.age = age;  // Can be -5 or 999!
}

// RIGHT: Validation
void setAge(int age) {
    if (age >= 0 && age <= 150) {
        this.age = age;
    }
}
```

---

### Mistake 3: Exposing Internal Collections

```java
// WRONG: Mutable internal data exposed
class Team {
    private List<Player> players = new ArrayList<>();
    
    List<Player> getPlayers() {
        return players;  // Returns reference!
    }
}

// User can modify:
team.getPlayers().clear();  // Team becomes empty!

// RIGHT: Return copy
List<Player> getPlayers() {
    return new ArrayList<>(players);  // Return copy
}
```

---

## 16. Interview Tips

```text
1. Encapsulation definition
   - Hide internal details
   - Expose only necessary interface
   - Data protection

2. Access modifiers
   - Know all four: public, private, protected, default
   - Know visibility scope
   - Use least permissive access

3. Getters and Setters
   - Getters for read access
   - Setters for controlled write with validation
   - Convention: get/set + PropertyName

4. Why encapsulation
   - Data protection
   - Validation
   - Flexibility (internal change without affecting users)
   - Maintainability

5. Private vs protected
   - Private: only within class
   - Protected: within class + subclasses + package

6. Immutability
   - final properties
   - No setters
   - Thread-safe

7. Common pattern: JavaBean
   - Private properties
   - Public getters/setters
   - No-arg constructor

8. Real-world example
   - Bank account with balance validation
   - Employee with salary constraints
```

---

## 17. Key Takeaways

```text
- Encapsulation hides internal details and exposes controlled interface
- Private: Most restrictive, only within class
- Public: Least restrictive, accessible from anywhere
- Protected: Accessible in subclasses
- Default: Accessible within package
- Getters provide controlled read access
- Setters provide controlled write access with validation
- Immutable objects use final properties
- Encapsulation enables safer, more maintainable code
- Use least permissive access modifier
- Validate in setters, not in getters
- Immutable collections when exposing internal data
```

---

## 18. Common Mistakes to Avoid

```text
❌ Making all properties public
   ✓ Use private + getters/setters

❌ Not validating in setters
   ✓ Add business logic to setters

❌ Exposing mutable internal data
   ✓ Return copies of collections

❌ Forgetting to use access modifiers
   ✓ Always specify (default is least permissive)

❌ Getter that modifies state
   ✓ Getters should be side-effect free

❌ Setter that returns value
   ✓ Setters should return void

❌ Making helper methods public
   ✓ Mark internal methods as private
```

---

## Final Thought

```text
Encapsulation is the shield of object-oriented programming.
It protects your data, enables flexibility, and ensures maintainability.
Master encapsulation, and you write code that lasts.
```

---


