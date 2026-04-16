# Day 21: Generics

---

## Overview

```text
Goal:
Master generics for type-safe collections

You will learn:
- Generic classes
- Generic methods
- Wildcards
- Bounded types
- Type safety
```

---

## 1. What are Generics?

```text
Allow you to write code that works with different types
while maintaining type safety at compile time
```

---

## 2. Generic Classes

```java
class Box<T> {
    private T item;
    
    void put(T item) { this.item = item; }
    T get() { return item; }
}

Box<String> stringBox = new Box<>();
Box<Integer> intBox = new Box<>();
```

---

## 3. Generic Methods

```java
<T> void print(T item) {
    System.out.println(item);
}

<T> T getFirst(List<T> list) {
    return list.get(0);
}
```

---

## 4. Bounded Generics

```java
<T extends Number> void process(T item) {
    // Only Number types allowed
}
```

---

## 5. Wildcards

```java
List<?> list;  // Any type
List<? extends Animal>  // Any subclass of Animal
List<? super Dog>  // Dog or superclass
```

---

## 6. Benefits

```text
✓ Type safety at compile time
✓ No casting needed
✓ Better code readability
✓ Catch errors early
```

---

## 7. Key Takeaways

```text
- Generics provide type safety
- Reduce casting
- Work with collections safely
- Wildcards for flexibility
```

---


