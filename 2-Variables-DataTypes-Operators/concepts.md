# Day 2: Variables, Data Types, and Operators

---

## Overview

```text
Goal:
Understand how Java stores and manipulates data

You will learn:
- What is a variable
- Types of data in Java
- Primitive vs Non-Primitive
- Operators in Java
```

---

## 1. What is a Variable?

```text
A variable is a container used to store data in memory.
```

### Simple Example

```text
int age = 25;
```

* `int` → type of data
* `age` → variable name
* `25` → value stored

---

## 2. Real-Life Analogy

```text
Variable = Box
Value    = Item inside the box
Type     = Type of box (size/shape restriction)
```

```text
+------------------+
|   age (int)      |
|------------------|
|       25         |
+------------------+
```

---

## 3. Data Types in Java

Java has two main types of data:

```text
+---------------------+
|     Data Types      |
+---------------------+
| 1. Primitive        |
| 2. Non-Primitive    |
+---------------------+
```

---

## 4. Primitive Data Types

```text
Primitive types store simple values
```

### List of Primitive Types

```text
+---------+---------+----------------------+
| Type    | Size    | Example              |
+---------+---------+----------------------+
| byte    | 1 byte  | byte b = 10;         |
| short   | 2 bytes | short s = 100;       |
| int     | 4 bytes | int x = 10;          |
| long    | 8 bytes | long l = 1000L;      |
| float   | 4 bytes | float f = 10.5f;     |
| double  | 8 bytes | double d = 10.5;     |
| char    | 2 bytes | char c = 'A';        |
| boolean | 1 bit   | boolean flag = true; |
+---------+---------+----------------------+
```

---

## 5. Non-Primitive Data Types

```text
Non-primitive types store references (addresses)
```

### Examples

```text
- String
- Arrays
- Classes
```

### Example

```text
String name = "Tejas";
```

---

## 6. Primitive vs Non-Primitive

```text
+----------------------+--------------------------+
| Primitive            | Non-Primitive            |
+----------------------+--------------------------+
| Stores actual value  | Stores reference         |
| Fixed size           | Dynamic size             |
| Faster               | Slightly slower          |
+----------------------+--------------------------+
```

---

## 7. Memory Representation

```text
Primitive:

Variable → Value
age → 25

Non-Primitive:

Variable → Address → Value
name → 0x101 → "Tejas"
```

---

## 8. Operators in Java

```text
Operators are used to perform operations on variables
```

---

### 8.1 Arithmetic Operators

```text
+----------------+----------------+
| Operator       | Example        |
+----------------+----------------+
| +              | a + b          |
| -              | a - b          |
| *              | a * b          |
| /              | a / b          |
| %              | a % b          |
+----------------+----------------+
```

---

### 8.2 Relational Operators

```text
+----------------+----------------+
| Operator       | Meaning        |
+----------------+----------------+
| ==             | Equal          |
| !=             | Not equal      |
| >              | Greater than   |
| <              | Less than      |
| >=             | Greater equal  |
| <=             | Less equal     |
+----------------+----------------+
```

---

### 8.3 Logical Operators

```text
+----------------+----------------+
| Operator       | Meaning        |
+----------------+----------------+
| &&             | AND            |
| ||             | OR             |
| !              | NOT            |
+----------------+----------------+
```

---

## 9. Real-Life Example (Student System)

```text
Student:
- age = 20
- marks = 85

Check:
if (marks > 50 && age > 18)
    → Eligible
```

---

## 10. ASCII Flow Example

```text
marks = 85

         marks > 50 ?
             |
         +---+---+
         |       |
       Yes      No
        |
   Eligible
```

---

## 11. Key Takeaways

```text
- Variables store data
- Data types define what kind of data can be stored
- Primitive = simple values
- Non-Primitive = reference types
- Operators help perform operations
```

---

## 12. Common Mistakes

```text
- Forgetting type suffix (e.g., 10.5f for float)
- Confusing == with =
- Not understanding primitive vs reference
```

---

## 13. Interview Tips

```text
- Be clear on primitive vs non-primitive
- Know default sizes of data types
- Understand how operators work in conditions
```

---

## Final Thought

```text
Everything in programming starts with data.
If you understand how data is stored and manipulated,
you understand the foundation of coding.
```

---
