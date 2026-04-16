# Day 16: Final Keyword

---

## Overview

```text
Goal:
Master the final keyword and understand immutability and constants

You will learn:
- final variables (constants)
- final methods (prevent overriding)
- final classes (prevent inheritance)
- Initialization rules
- Best practices with final
- Immutability patterns
```

---

## 1. What is Final?

```text
'final' keyword means "cannot be changed"

Applied to:
- Variables: Cannot reassign value
- Methods: Cannot override
- Classes: Cannot extend
```

---

## 2. Final Variables

### Constant Declaration

```java
final int MAX_SIZE = 100;
final String APP_NAME = "MyApp";

// MAX_SIZE = 200;  // ERROR: cannot reassign
```

### When to Initialize

```text
Option 1: At declaration
final int x = 10;

Option 2: In constructor
final int x;
void Constructor() {
    x = 10;  // OK: initialize once
}

Option 3: In static block
static final int x;
static {
    x = 10;
}
```

---

## 3. Final Methods

### Purpose

```text
Method cannot be overridden by child class
```

### Example

```java
class Parent {
    final void criticalMethod() {
        // Child cannot override
    }
}

class Child extends Parent {
    // void criticalMethod() { }  // ERROR: cannot override
}
```

---

## 4. Final Classes

### Purpose

```text
Class cannot be extended
No subclasses allowed
```

### Example

```java
final class ImmutableClass {
    // Cannot be extended
}

// class Child extends ImmutableClass { }  // ERROR
```

---

## 5. Real-World Examples

### String is Final

```java
final public class String { }
// Cannot extend String
```

### Immutable Integer

```java
final public class Integer {
    private final int value;
}
```

---

## 6. When to Use Final

```text
Variables:
✓ Constants
✓ Configuration values
✓ Immutable data

Methods:
✓ Security-critical methods
✓ Performance-sensitive code
✓ Methods you're sure shouldn't change

Classes:
✓ Immutable classes
✓ Utility classes
✓ Security-sensitive classes
```

---

## 7. Benefits of Final

### Performance

```text
Compiler can optimize
Java can inline method calls
```

---

### Security

```text
Prevents unexpected changes
Ensures immutability
```

---

### Design

```text
Makes intent clear
Documents contracts
```

---

## 8. Interview Tips

```text
1. Final variable: Cannot reassign
2. Final method: Cannot override
3. Final class: Cannot extend
4. Immutability: Use final for fields
5. Performance: Compiler optimizations
```

---

## Key Takeaways

```text
- final variables are constants
- final methods prevent overriding
- final classes prevent inheritance
- Use final to enforce immutability
- Use final to document intent
- Performance benefits from final
```

---

## Final Thought

```text
Final is about certainty and immutability.
Use it to make your design intentions clear.
```

---


