# Day 3: Control Flow (if-else, switch, loops)

---

## Overview

```text
Goal:
Learn how to control the flow of a program using conditions and loops

You will learn:
- Decision making (if, if-else, switch)
- Looping (for, while, do-while)
- Real-world logic building
```

---

## Definitions

```text
Control flow
  The order in which program statements execute.

Branch
  A decision point that chooses one of multiple paths (if/else, switch).

Loop
  Repeats a block of code while/for as long as a condition holds.

Condition
  An expression that evaluates to true or false.
```

## 1. What is Control Flow?

```text
Control flow determines the order in which statements are executed in a program.
```

### Simple Understanding

```text
Program = Instructions

Control Flow = Who runs first? What runs next?
```

---

## 2. Real-Life Analogy

```text
Morning Routine:

IF alarm rings → Wake up
ELSE → Sleep more

WHILE hungry → Eat

FOR each day → Go to work
```

---

## 3. Decision Making (if, if-else)

---

### 3.1 if Statement

```text
Executes code only if condition is true
```

### Syntax

```java
if (condition) {
    // code runs if condition is true
}
```

### Example

```java
int age = 20;

if (age >= 18) {
    System.out.println("Eligible to vote");
}
```

---

### ASCII Flow

```text
        condition?
           |
       +---+---+
       |       |
     true    false
       |
   execute
```

---

### 3.2 if-else Statement

```text
Executes one block if true, another if false
```

### Example

```java
int marks = 40;

if (marks >= 50) {
    System.out.println("Pass");
} else {
    System.out.println("Fail");
}
```

---

### ASCII Flow

```text
        condition?
           |
       +---+---+
       |       |
     true    false
       |       |
     Pass     Fail
```

---

### 3.3 if-else-if Ladder

```text
Used when multiple conditions exist
```

```java
int marks = 85;

if (marks >= 90) {
    System.out.println("Grade A");
} else if (marks >= 75) {
    System.out.println("Grade B");
} else {
    System.out.println("Grade C");
}
```

---

## 4. switch Statement

```text
Used when you have multiple fixed choices
```

### Example

```java
int day = 2;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Invalid day");
}
```

---

### When to Use switch?

```text
- Fixed values
- Cleaner than multiple if-else
```

---

## 5. Loops in Java

```text
Loops are used to repeat a block of code multiple times
```

---

## 5.1 for Loop

```text
Used when number of iterations is known
```

### Syntax

```java
for (initialization; condition; update) {
    // code
}
```

### Example

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

---

### ASCII Flow

```text
Start → Condition → Execute → Update → Repeat
```

---

## 5.2 while Loop

```text
Used when condition is checked before execution
```

### Example

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

---

### ASCII Flow

```text
Condition → Execute → Repeat
```

---

## 5.3 do-while Loop

```text
Executes at least once, even if condition is false
```

### Example

```java
int i = 1;

do {
    System.out.println(i);
    i++;
} while (i <= 5);
```

---

### ASCII Flow

```text
Execute → Condition → Repeat
```

---

## 6. Real-Life Example (Login System)

```text
WHILE password is incorrect:
    Ask user again

IF password is correct:
    Login success
ELSE:
    Access denied
```

---

## 7. Key Takeaways

```text
- Control flow decides execution order
- if-else is used for decisions
- switch is used for fixed choices
- loops are used for repetition
```

---

## 8. Common Mistakes

```text
- Forgetting break in switch
- Infinite loops (missing update condition)
- Using == incorrectly in conditions
```

---

## 9. Interview Tips

```text
- Know difference between for, while, do-while
- Be able to convert if-else to switch
- Understand loop execution flow clearly
```

---

## Final Thought

```text
Control flow is the brain of your program.
Without it, your program cannot make decisions.
```

---

## Code snippets

```java
// Common pattern: validate input and return early
int age = 17;
if (age < 0) {
    throw new IllegalArgumentException("age must be non-negative");
}
if (age < 18) {
    System.out.println("Minor");
    return;
}
System.out.println("Adult");
```

---

## Step-by-step explanations

```text
How to choose between if-else and switch:

1) Use if/else when
   - conditions are ranges (marks >= 90) or complex expressions
   - you have boolean combinations (&&, ||)

2) Use switch when
   - you match one variable against many fixed constants
   - you want a cleaner table-style branching

Loop selection:
  for      -> when iteration count is known
  while    -> when you loop until a condition becomes false
  do-while -> when you must execute at least once
```

---

## Edge cases / common mistakes

```text
1) switch fall-through
   If you forget break, execution continues into the next case.

2) Infinite loops
   Common causes:
     - condition never changes
     - wrong update direction

3) Off-by-one errors
   for (i = 0; i < n; i++) is correct for arrays of length n.
   for (i = 0; i <= n; i++) will overflow the last index.
```

---

## Summary

```text
+-------------+-----------------------------------------------+
| Construct   | Best used for                                 |
+-------------+-----------------------------------------------+
| if/else     | ranges and complex conditions                   |
| switch      | fixed choices for a single value               |
| for         | known number of iterations                      |
| while       | loop until condition changes                     |
| do-while    | must run at least once                           |
+-------------+-----------------------------------------------+
```

---

