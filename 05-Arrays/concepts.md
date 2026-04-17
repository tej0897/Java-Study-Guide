# Day 5: Arrays in Java (1D and 2D)

---

## Overview

```text
Goal:
Learn how to store and manage multiple values using arrays

You will learn:
- What is an array
- 1D arrays
- 2D arrays
- Indexing and memory representation
```

---

## 1. What is an Array?

```text
An array is a collection of elements of the same data type
stored in a contiguous memory location.
```

---

## Definitions

```text
Array
  Fixed-size, indexed collection of same-type elements.

Index
  Zero-based position used to read/write an element.

Length
  Number of elements in an array (arr.length).

2D array
  An array of arrays (matrix-like structure).
```

---

## 2. Real-Life Analogy

```text
Think of a row of lockers:

Each locker → stores one value
All lockers → together form an array
```

```text
Index →   0     1     2     3
        +-----+-----+-----+-----+
Array → | 10  | 20  | 30  | 40  |
        +-----+-----+-----+-----+
```

---

## 3. Key Concept: Index

```text
- Index starts from 0
- Used to access elements
```

Example:

```java
arr[0] → first element
arr[1] → second element
```

---

## 4. 1D Array (Single Dimension)

---

### Declaration

```java
int[] arr;
```

---

### Initialization

```java
arr = new int[4];
```

---

### Combined

```java
int[] arr = {10, 20, 30, 40};
```

---

### Accessing Elements

```java
System.out.println(arr[0]); // 10
```

---

### ASCII Representation

```text
Index →   0     1     2     3
        +-----+-----+-----+-----+
Value → | 10  | 20  | 30  | 40  |
        +-----+-----+-----+-----+
```

---

## 5. Looping Through Array

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

---

### Flow

```text
i=0 → arr[0]
i=1 → arr[1]
i=2 → arr[2]
...
```

---

## 6. 2D Array (Matrix)

```text
A 2D array is an array of arrays (rows and columns)
```

---

### Declaration

```java
int[][] matrix;
```

---

### Initialization

```java
matrix = new int[2][3];
```

---

### Example

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
```

---

### ASCII Representation

```text
        Column →
        0   1   2
      +---+---+---+
Row 0 | 1 | 2 | 3 |
      +---+---+---+
Row 1 | 4 | 5 | 6 |
      +---+---+---+
```

---

### Accessing Elements

```java
matrix[0][1] → 2
matrix[1][2] → 6
```

---

## 7. Looping 2D Array

```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
}
```

---

### Flow Visualization

```text
(0,0) → (0,1) → (0,2)
(1,0) → (1,1) → (1,2)
```

---

## 8. Real-Life Example

```text
Marks of students:

Student 1 → [80, 90, 85]
Student 2 → [70, 75, 80]

This is a 2D array
```

---

## 9. Key Takeaways

```text
- Arrays store multiple values
- Index starts from 0
- 1D = single list
- 2D = table (rows and columns)
```

---

## 10. Common Mistakes

```text
- Accessing invalid index (ArrayIndexOutOfBounds)
- Forgetting array length
- Confusing rows and columns in 2D array
```

---

## 11. Interview Tips

```text
- Be comfortable with indexing
- Know how to loop arrays
- Understand 2D traversal clearly
```

---

## Final Thought

```text
Arrays are the first step toward handling collections of data.
Master arrays, and you unlock real problem-solving.
```

---

## Edge cases / common mistakes

```text
1) ArrayIndexOutOfBoundsException
   Happens when you access index < 0 or index >= arr.length.

2) Default values
   new int[3] gives {0,0,0}
   new boolean[3] gives {false,false,false}
   new String[3] gives {null,null,null}

3) 2D arrays can be jagged (array-of-arrays)
   int[][] a = new int[2][];
   a[0] and a[1] can have different lengths.
```

---

## Summary

```text
+--------------------+-------------------------------------------+
| Topic              | Key point                                  |
+--------------------+-------------------------------------------+
| 1D array           | Fixed size, indexed                         |
| arr.length         | Number of elements                          |
| 2D array           | Array of arrays (can be jagged)             |
| Common errors      | bounds errors, wrong loop conditions        |
+--------------------+-------------------------------------------+
```

---

