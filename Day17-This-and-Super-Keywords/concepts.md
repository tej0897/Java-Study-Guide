# Day 17: This and Super Keywords

---

## Overview

```text
Goal:
Master this and super keywords for object referencing

You will learn:
- this keyword usage
- super keyword usage
- Distinguishing between this and super
- Constructor chaining with this
- Method calling with super
```

---

## 1. This Keyword

### What is 'this'?

```text
'this' refers to current object
Used within instance methods and constructors
```

### Usage 1: Distinguish Variables

```java
class Person {
    String name;
    
    Person(String name) {
        this.name = name;  // this.name = property
    }
}
```

### Usage 2: Return Current Object

```java
class Builder {
    Builder setName(String name) {
        this.name = name;
        return this;  // Return current object
    }
}
```

### Usage 3: Call Another Constructor

```java
class Point {
    Point() {
        this(0, 0);  // Calls other constructor
    }
    
    Point(int x, int y) {
        // initialization
    }
}
```

---

## 2. Super Keyword

### What is 'super'?

```text
'super' refers to parent class
Used to access parent methods and constructors
```

### Usage 1: Call Parent Constructor

```java
class Animal {
    String name;
    Animal(String name) { this.name = name; }
}

class Dog extends Animal {
    String breed;
    Dog(String name, String breed) {
        super(name);  // Call parent constructor
        this.breed = breed;
    }
}
```

### Usage 2: Call Parent Method

```java
class Animal {
    void sound() { System.out.println("Sound"); }
}

class Dog extends Animal {
    @Override
    void sound() {
        super.sound();  // Call parent method
        System.out.println("Bark");
    }
}
```

---

## 3. This vs Super

```text
+------------------+--------------------+--------------------+
| Feature          | this               | super              |
+------------------+--------------------+--------------------+
| Refers to        | Current object     | Parent class       |
| Scope            | Instance methods   | Subclasses         |
| Call constructor | this()             | super()            |
| Call method      | this.method()      | super.method()     |
| Access           | Current class      | Parent class       |
+------------------+--------------------+--------------------+
```

---

## 4. Real-Life Example

```java
class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
}

class Manager extends Employee {
    String department;
    
    Manager(String name, String dept) {
        super(name);  // Call parent
        this.department = dept;  // Current object
    }
}
```

---

## 5. Key Takeaways

```text
- this: Current object reference
- super: Parent class reference
- this(): Call another constructor
- super(): Call parent constructor
- Both useful for constructor chaining
```

---


