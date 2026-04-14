# Day 3: Control Flow (if-else, switch, loops)

---

## Overview

```text id="r2x6c8"
Goal:
Learn how to control the flow of a program using conditions and loops

You will learn:
- Decision making (if, if-else, switch)
- Looping (for, while, do-while)
- Real-world logic building
```

---

## 1. What is Control Flow?

```text id="6a7x8y"
Control flow determines the order in which statements are executed in a program.
```

### Simple Understanding

```text id="lm9t1p"
Program = Instructions

Control Flow = Who runs first? What runs next?
```

---

## 2. Real-Life Analogy

```text id="m8f7k2"
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

```text id="q1w2e3"
Executes code only if condition is true
```

### Syntax

```java id="c2v9k1"
if (condition) {
    // code runs if condition is true
}
```

### Example

```java id="x8m3z2"
int age = 20;

if (age >= 18) {
    System.out.println("Eligible to vote");
}
```

---

### ASCII Flow

```text id="flow1"
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

```text id="a9b8c7"
Executes one block if true, another if false
```

### Example

```java id="j2h6k9"
int marks = 40;

if (marks >= 50) {
    System.out.println("Pass");
} else {
    System.out.println("Fail");
}
```

---

### ASCII Flow

```text id="flow2"
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

```text id="l1k2j3"
Used when multiple conditions exist
```

```java id="g7f5d3"
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

```text id="s4w2q1"
Used when you have multiple fixed choices
```

### Example

```java id="u8i7o6"
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

```text id="usecase1"
- Fixed values
- Cleaner than multiple if-else
```

---

## 5. Loops in Java

```text id="loopintro"
Loops are used to repeat a block of code multiple times
```

---

## 5.1 for Loop

```text id="forloop"
Used when number of iterations is known
```

### Syntax

```java id="for1"
for (initialization; condition; update) {
    // code
}
```

### Example

```java id="for2"
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

---

### ASCII Flow

```text id="flow3"
Start → Condition → Execute → Update → Repeat
```

---

## 5.2 while Loop

```text id="whileloop"
Used when condition is checked before execution
```

### Example

```java id="while1"
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

---

### ASCII Flow

```text id="flow4"
Condition → Execute → Repeat
```

---

## 5.3 do-while Loop

```text id="dowhile"
Executes at least once, even if condition is false
```

### Example

```java id="dowhile1"
int i = 1;

do {
    System.out.println(i);
    i++;
} while (i <= 5);
```

---

### ASCII Flow

```text id="flow5"
Execute → Condition → Repeat
```

---

## 6. Real-Life Example (Login System)

```text id="loginexample"
WHILE password is incorrect:
    Ask user again

IF password is correct:
    Login success
ELSE:
    Access denied
```

---

## 7. Key Takeaways

```text id="takeaways"
- Control flow decides execution order
- if-else is used for decisions
- switch is used for fixed choices
- loops are used for repetition
```

---

## 8. Common Mistakes

```text id="mistakes"
- Forgetting break in switch
- Infinite loops (missing update condition)
- Using == incorrectly in conditions
```

---

## 9. Interview Tips

```text id="tips"
- Know difference between for, while, do-while
- Be able to convert if-else to switch
- Understand loop execution flow clearly
```

---

## Final Thought

```text id="final"
Control flow is the brain of your program.
Without it, your program cannot make decisions.
```

---
