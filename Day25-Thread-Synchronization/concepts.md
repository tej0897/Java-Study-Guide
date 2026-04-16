# Day 25: Thread Synchronization

---

## Overview

```text
Goal:
Master thread synchronization for safe data access

You will learn:
- Synchronized keyword
- Locks and monitors
- Deadlocks
- Volatile keyword
- Best practices
```

---

## 1. Thread Safety Problem

```text
Multiple threads accessing shared data can cause inconsistency
Need synchronization to prevent race conditions
```

---

## 2. Synchronized Methods

```java
synchronized void deposit(double amount) {
    balance += amount;
}
```

---

## 3. Synchronized Blocks

```java
synchronized(object) {
    // Critical section
}
```

---

## 4. Volatile Keyword

```java
volatile boolean flag = false;
```

---

## 5. Deadlock

```text
Two threads waiting for each other indefinitely
Avoid by maintaining lock ordering
```

---

## 6. Key Takeaways

```text
- Synchronization prevents race conditions
- Use synchronized methods for critical sections
- Volatile for single variable visibility
- Avoid deadlocks with proper design
```

---


