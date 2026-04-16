# Day 5: Arrays in Java (1D and 2D)

---

## Overview

```text id="ov5"
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

```text id="def5"
An array is a collection of elements of the same data type
stored in a contiguous memory location.
```

---

## 2. Real-Life Analogy

```text id="real5"
Think of a row of lockers:

Each locker → stores one value
All lockers → together form an array
```

```text id="diagram5"
Index →   0     1     2     3
        +-----+-----+-----+-----+
Array → | 10  | 20  | 30  | 40  |
        +-----+-----+-----+-----+
```

---

## 3. Key Concept: Index

```text id="index5"
- Index starts from 0
- Used to access elements
```

Example:

```java id="ex5"
arr[0] → first element
arr[1] → second element
```

---

## 4. 1D Array (Single Dimension)

---

### Declaration

```java id="d5_1"
int[] arr;
```

---

### Initialization

```java id="d5_2"
arr = new int[4];
```

---

### Combined

```java id="d5_3"
int[] arr = {10, 20, 30, 40};
```

---

### Accessing Elements

```java id="d5_4"
System.out.println(arr[0]); // 10
```

---

### ASCII Representation

```text id="ascii1d"
Index →   0     1     2     3
        +-----+-----+-----+-----+
Value → | 10  | 20  | 30  | 40  |
        +-----+-----+-----+-----+
```

---

## 5. Looping Through Array

```java id="loop1"
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

---

### Flow

```text id="flow5_1"
i=0 → arr[0]
i=1 → arr[1]
i=2 → arr[2]
...
```

---

## 6. 2D Array (Matrix)

```text id="def2d"
A 2D array is an array of arrays (rows and columns)
```

---

### Declaration

```java id="d5_5"
int[][] matrix;
```

---

### Initialization

```java id="d5_6"
matrix = new int[2][3];
```

---

### Example

```java id="d5_7"
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
```

---

### ASCII Representation

```text id="ascii2d"
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

```java id="d5_8"
matrix[0][1] → 2
matrix[1][2] → 6
```

---

## 7. Looping 2D Array

```java id="loop2"
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
}
```

---

### Flow Visualization

```text id="flow2d"
(0,0) → (0,1) → (0,2)
(1,0) → (1,1) → (1,2)
```

---

## 8. Real-Life Example

```text id="realexample"
Marks of students:

Student 1 → [80, 90, 85]
Student 2 → [70, 75, 80]

This is a 2D array
```

---

## 9. Key Takeaways

```text id="take5"
- Arrays store multiple values
- Index starts from 0
- 1D = single list
- 2D = table (rows and columns)
```

---

## 10. Common Mistakes

```text id="mist5"
- Accessing invalid index (ArrayIndexOutOfBounds)
- Forgetting array length
- Confusing rows and columns in 2D array
```

---

## 11. Interview Tips

```text id="tip5"
- Be comfortable with indexing
- Know how to loop arrays
- Understand 2D traversal clearly
```

---

## Final Thought

```text id="final5"
Arrays are the first step toward handling collections of data.
Master arrays, and you unlock real problem-solving.
```

---
