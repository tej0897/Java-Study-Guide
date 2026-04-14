# Day 4: Methods and Functions in Java

---

## Overview

```text id="ov1"
Goal:
Understand how to write reusable blocks of code using methods

You will learn:
- What is a method
- Why methods are important
- Method structure
- Parameters and return types
```

---

## 1. What is a Method?

```text id="def1"
A method is a block of code that performs a specific task
and can be reused multiple times.
```

---

## 2. Real-Life Analogy

```text id="real1"
Think of a Coffee Machine:

Input  → Coffee powder, water
Process → Brewing
Output → Coffee
```

```text id="diagram1"
        +-------------------+
Input → |   Coffee Machine  | → Output
        +-------------------+
```

👉 A method works exactly like this:

* Takes input
* Processes it
* Returns output

---

## 3. Why Use Methods?

```text id="why1"
- Avoid code duplication
- Improve readability
- Make code reusable
- Easier to maintain
```

---

## 4. Method Structure

```text id="structure1"
returnType methodName(parameters) {
    // method body
    return value;
}
```

---

### Example

```java id="ex1"
int add(int a, int b) {
    return a + b;
}
```

---

## 5. Breaking Down the Method

```text id="break1"
int        → return type
add        → method name
(int a,b)  → parameters
return     → output
```

---

## 6. Types of Methods

---

### 6.1 Method with Return Value

```java id="m1"
int square(int number) {
    return number * number;
}
```

---

### 6.2 Method without Return (void)

```java id="m2"
void printMessage() {
    System.out.println("Hello");
}
```

---

### ASCII Comparison

```text id="cmp1"
With return:
Input → Method → Output

Without return:
Method → Action only
```

---

## 7. Parameters vs Arguments

```text id="param1"
Parameters → variables in method definition
Arguments  → actual values passed
```

---

### Example

```java id="param2"
void greet(String name) {   // parameter
    System.out.println(name);
}

greet("Tejas");             // argument
```

---

## 8. Method Flow Visualization

```text id="flow1"
main()
  |
  v
add(2,3)
  |
  v
return 5
```

---

## 9. Method Call Stack (Basic Idea)

```text id="stack1"
Top of Stack
+----------------+
| add(2,3)       |
+----------------+
| main()         |
+----------------+
```

👉 Methods are executed in a stack (last called → first executed)

---

## 10. Real-Life Example (Calculator)

```text id="calc1"
User → enters numbers

Method:
add(a,b)

Output:
sum
```

---

## 11. Key Takeaways

```text id="take1"
- Methods make code reusable
- They reduce duplication
- They improve readability
- Parameters allow flexibility
```

---

## 12. Common Mistakes

```text id="mist1"
- Forgetting return statement
- Wrong return type
- Confusing parameters and arguments
```

---

## 13. Interview Tips

```text id="tip1"
- Be clear on method syntax
- Understand return types vs void
- Know difference between parameters and arguments
```

---

## Final Thought

```text id="final1"
Methods are the building blocks of clean code.
If you master methods, you start thinking like a developer.
```

---
