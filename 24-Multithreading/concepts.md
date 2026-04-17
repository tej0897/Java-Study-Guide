# Day 24: Multithreading Basics

---

## Overview

```text
Goal:
Master multithreading for concurrent programming

You will learn:
- Thread class
- Runnable interface
- Creating threads
- Thread states
- Thread scheduling
```

---

## 1. What is Thread?

```text
Lightweight process that runs concurrently
Multiple threads share same memory space
```

---

## 2. Creating Threads (Method 1: Extend Thread)

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}
```

```text
MyThread thread = new MyThread();
thread.start();
```

---

## 3. Creating Threads (Method 2: Implement Runnable)

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable running");
    }
}
```

```text
Thread thread = new Thread(new MyRunnable());
thread.start();
```

---

## 4. Thread Methods

```text
thread.start()      // Start execution
Thread.sleep(1000)  // Pause for milliseconds (static method)
thread.join()       // Wait for completion
thread.setPriority(10)
thread.getName()
```

---

## 5. Thread States

```text
NEW           - Just created
RUNNABLE      - Ready to run ("running" is an informal subset of RUNNABLE)
BLOCKED       - Waiting to acquire a monitor lock
WAITING       - Waiting indefinitely for another thread
TIMED_WAITING - Waiting for a specified time (sleep/join with timeout)
TERMINATED    - Finished execution
```

---

## 6. Key Takeaways

```text
- Call start(), not run()
- Implement Runnable preferred over extending Thread
- Threads run concurrently
- Thread safety important in shared data
```

---


