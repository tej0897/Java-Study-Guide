# Day 18: Exception Handling

---

## Overview

```text
Goal:
Master exception handling for robust code

You will learn:
- What are exceptions
- try-catch blocks
- finally block
- throw keyword
- Custom exceptions
- Best practices
```

---

## 1. What is Exception?

```text
Exception is an error event that disrupts normal program flow

Can be handled instead of crashing
```

---

## 2. Try-Catch

### Syntax

```java
try {
    // Code that might throw exception
} catch (ExceptionType e) {
    // Handle exception
}
```

### Example

```java
try {
    int result = 10 / 0;  // ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

---

## 3. Finally Block

```java
try {
    // Code
} catch (Exception e) {
    // Handle
} finally {
    // Always executes
}
```

---

## 4. Throw Keyword

```java
if (age < 0) {
    throw new IllegalArgumentException("Age cannot be negative");
}
```

---

## 5. Custom Exceptions

```java
class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

throw new InvalidAgeException("Invalid age");
```

---

## 6. Common Exceptions

```text
ArithmeticException     - Math errors
NullPointerException    - null reference
ArrayIndexOutOfBounds  - Invalid array access
NumberFormatException  - Invalid number conversion
```

---

## 7. Try-With-Resources (Java 7+)

```java
try (Scanner scanner = new Scanner(file)) {
    // scanner auto-closed
} catch (IOException e) {
    // handle
}
```

---

## 8. Key Takeaways

```text
- Exceptions disrupt normal flow
- try-catch handles exceptions
- finally always executes
- throw creates exceptions
- Create custom exceptions
- Use appropriate exception types
```

---


