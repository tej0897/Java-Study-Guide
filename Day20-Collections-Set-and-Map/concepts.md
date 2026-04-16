# Day 20: Collections Framework - Set and Map

---

## Overview

```text
Goal:
Master Set and Map collections

You will learn:
- Set interface (unique elements)
- HashSet, TreeSet
- Map interface (key-value pairs)
- HashMap, TreeMap
- When to use each
```

---

## 1. Set Collection

### Characteristics

```text
- No duplicates
- No guaranteed order
- Fast lookup
```

### HashSet

```java
Set<String> set = new HashSet<>();
set.add("Java");
set.add("Python");
set.add("Java");  // Ignored (duplicate)
```

### TreeSet

```java
Set<String> set = new TreeSet<>();  // Sorted order
```

---

## 2. Set Operations

```java
set.add(e)
set.remove(e)
set.contains(e)
set.size()
set.clear()
```

---

## 3. Map Collection

### Characteristics

```text
- Key-value pairs
- Keys are unique
- Fast lookup by key
```

### HashMap

```java
Map<String, Integer> map = new HashMap<>();
map.put("John", 25);
map.put("Jane", 23);
System.out.println(map.get("John"));  // 25
```

---

## 4. Map Operations

```java
map.put(key, value)
map.get(key)
map.remove(key)
map.containsKey(key)
map.keySet()
map.values()
```

---

## 5. TreeMap

```text
Sorted by key
Slower than HashMap
Better for sorted iteration
```

---

## 6. Real-World Example

```java
Map<String, String> capitals = new HashMap<>();
capitals.put("USA", "Washington");
capitals.put("India", "NewDelhi");

for (String country : capitals.keySet()) {
    System.out.println(country + " -> " + capitals.get(country));
}
```

---

## 7. Key Takeaways

```text
- Set: Unique elements, no order
- HashSet: Fast operations
- TreeSet: Sorted order
- Map: Key-value pairs
- HashMap: Fast lookup
- TreeMap: Sorted by key
```

---


