# Day 19: Collections Framework - List

---

## Overview

```text
Goal:
Master List collection for storing ordered elements

You will learn:
- List interface
- ArrayList
- LinkedList
- List operations
- Iteration
- Performance considerations
```

---

## 1. What is List?

```text
Ordered collection (maintains insertion order)
Allows duplicates
Indexed access (get by position)
```

---

## 2. ArrayList

### Declaration

```java
List<String> list = new ArrayList<>();
```

### Operations

```java
list.add("Java");        // Add
list.get(0);             // Access
list.remove(0);          // Remove
list.size();             // Size
```

---

## 3. LinkedList

```java
List<String> list = new LinkedList<>();
```

### When to Use

```text
ArrayList:  Fast access, slow insertion
LinkedList: Slow access, fast insertion
```

---

## 4. Iteration

### For Loop

```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
```

### Enhanced For

```java
for (String item : list) {
    System.out.println(item);
}
```

### Iterator

```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

---

## 5. Common Methods

```text
add(E e)              - Add element
remove(int index)     - Remove by index
get(int index)        - Get by index
size()                - Get size
contains(E e)         - Check existence
clear()               - Remove all
```

---

## 6. Real-Life Example

```java
List<String> students = new ArrayList<>();
students.add("John");
students.add("Jane");
students.add("Bob");

for (String student : students) {
    System.out.println(student);
}
```

---

## 7. Key Takeaways

```text
- List maintains insertion order
- ArrayList for random access
- LinkedList for frequent insertions
- Iteration methods: for, enhanced for, iterator
- Collections.sort() for sorting
```

---


