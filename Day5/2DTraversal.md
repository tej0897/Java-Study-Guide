# 2D Array Traversal in Java (Deep Dive)

---

## Overview

```text id="ov2d"
Goal:
Understand how to traverse (iterate through) a 2D array clearly and confidently

You will learn:
- Row-wise traversal
- Column-wise traversal
- How nested loops work
- Mental models to avoid confusion
```

---

## 1. What is 2D Traversal?

```text id="def2dtrav"
Traversal means visiting every element in the 2D array.
```

---

## 2. Sample Matrix

```text id="matrix2d"
        Column →
        0   1   2
      +---+---+---+
Row 0 | 1 | 2 | 3 |
      +---+---+---+
Row 1 | 4 | 5 | 6 |
      +---+---+---+
```

---

## 3. Key Idea: Nested Loops

```text id="nested1"
Outer loop  → rows
Inner loop  → columns
```

---

## 4. Row-wise Traversal (Most Important)

---

### Code

```java id="rowwise1"
for (int i = 0; i < matrix.length; i++) {          // rows
    for (int j = 0; j < matrix[i].length; j++) {   // columns
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

## 5. Step-by-Step Execution

```text id="steps1"
i = 0 (Row 0)
    j = 0 → matrix[0][0] = 1
    j = 1 → matrix[0][1] = 2
    j = 2 → matrix[0][2] = 3

i = 1 (Row 1)
    j = 0 → matrix[1][0] = 4
    j = 1 → matrix[1][1] = 5
    j = 2 → matrix[1][2] = 6
```

---

## 6. Traversal Order

```text id="order1"
(0,0) → (0,1) → (0,2)
(1,0) → (1,1) → (1,2)
```

---

## 7. Visual Flow

```text id="flow1"
Row 0 → [1 2 3]
Row 1 → [4 5 6]
```

---

## 8. Mental Model (Very Important)

```text id="mental1"
Think like this:

"For each row,
    go through all columns"
```

---

## 9. Real-Life Analogy (Excel Sheet)

```text id="excel1"
        A   B   C
      +---+---+---+
Row1  | 1 | 2 | 3 |
Row2  | 4 | 5 | 6 |
```

Traversal:

* Read Row1 completely
* Then Row2

````

---

## 10. Common Confusion

```text id="confusion1"
matrix.length         → number of rows
matrix[i].length     → number of columns
````

---

## 11. Column-wise Traversal

---

### Code

```java id="colwise1"
for (int j = 0; j < matrix[0].length; j++) {       // columns
    for (int i = 0; i < matrix.length; i++) {      // rows
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

## 12. Column-wise Order

```text id="order2"
(0,0) → (1,0)
(0,1) → (1,1)
(0,2) → (1,2)
```

---

## 13. Row-wise vs Column-wise

```text id="compare1"
Row-wise:
Outer → rows
Inner → columns

Column-wise:
Outer → columns
Inner → rows
```

---

## 14. Common Mistakes

```text id="mist2d"
- Swapping i and j incorrectly
- Using wrong length (matrix vs matrix[i])
- Forgetting nested loop
```

---

## 15. Interview Tip

```text id="tip2d"
Always explain traversal like:
"Outer loop for rows, inner loop for columns"
```

---

## Final Thought

```text id="final2d"
If you master 2D traversal,
you unlock matrix problems, grids, and real-world data handling.
```

---
