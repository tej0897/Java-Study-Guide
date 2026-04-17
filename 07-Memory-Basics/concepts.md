# Day 7: Memory Basics (Stack vs Heap, Pass by Value)

---

## Overview

```text
Goal:
Understand how Java memory works, and how data is stored and accessed

You will learn:
- Stack vs Heap memory
- Primitive vs Reference types in memory
- Pass by value concept
- Memory allocation and deallocation
- Garbage collection basics
- Memory leaks and common issues
```

---

## Definitions

```text
Stack
  Per-thread memory region used for method call frames (local variables,
  parameters, return addresses). LIFO.

Heap
  Shared memory region where objects live (created via `new`).

Reference
  A value that points to an object (think: handle/address-like).

Pass-by-value
  Java always passes a COPY of the argument value into the method.
  - For primitives: copy of the primitive value
  - For references: copy of the reference (two refs point to same object)

Garbage Collection (GC)
  Automatic memory management that reclaims heap objects that are no longer reachable.
```

---

## Real-life analogies

```text
Stack
  Like a stack of plates at a cafeteria:
    last plate put on top is the first taken off (LIFO)

Heap
  Like a warehouse:
    big storage, items placed in different locations

Reference
  Like a shipping label number:
    the label is not the package; it points to where the package is stored
```

---

## ASCII diagrams

```text
Call stack example (top = current method)

┌───────────────────┐
│ modifyObject(...) │
├───────────────────┤
│ main(...)         │
└───────────────────┘

Heap example
  studentRef ---->  Student{name="Tejas", age=20}
```

---

## Code snippets

```java
// Pass-by-value with primitives
static void inc(int x) { x++; }

int a = 10;
inc(a);
System.out.println(a); // still 10
```

```java
// Pass-by-value with references
static void rename(Student s) { s.name = "New"; }

Student st = new Student("Old");
rename(st);
System.out.println(st.name); // "New" (same object mutated)
```

---

## Step-by-step explanations

```text
Why "Java is pass-by-value" even for objects:

1) The variable in main holds a reference value (ref1)
2) When calling method(ref1), Java copies ref1 into the parameter (ref1Copy)
3) Both references point to the same heap object
4) Mutating the object via either reference changes the same object
5) Reassigning the parameter changes only ref1Copy, not the original variable
```

---

## Edge cases / common mistakes

```text
1) "Java is pass-by-reference" (incorrect)
   It's pass-by-value. The confusion comes from reference types.

2) StackOverflowError
   Deep recursion can exhaust stack frames.

3) Memory leaks in Java
   Usually means: objects are still reachable due to references held in
   static fields, caches, listeners, ThreadLocals, etc.

4) String pool confusion
   Literals may be interned and shared; new String("x") creates a new object.
```

---

## Interview tips

```text
Q) Where are objects stored?
A) On the heap. (The reference variable may be on stack as a local variable.)

Q) Why does changing an object inside a method affect the caller?
A) Because both caller and callee have references to the same heap object.

Q) What causes StackOverflowError?
A) Too deep recursion / too many nested method calls.

Q) What is a memory leak in Java?
A) Holding references to objects that are no longer needed.
```

---

## Summary

```text
+---------------------+--------------------------------------------+
| Concept             | Key point                                  |
+---------------------+--------------------------------------------+
| Stack               | method frames + locals, LIFO, per-thread    |
| Heap                | objects, shared, managed by GC              |
| Pass-by-value       | always copies argument value                |
| Reference mutation  | can mutate same object via copied ref       |
+---------------------+--------------------------------------------+
```

## 1. What is Memory in Java?

```text
Memory is the temporary storage area in computer where data is stored.

Java uses TWO main memory areas:
1. Stack - for primitive values and method calls
2. Heap - for objects
```

---

## 2. Real-Life Analogy

```text
Think of a Library:

Stack = Checkout Counter
        - Organized, sequential
        - Fast access
        - Limited space
        - Items returned immediately

Heap = Storage Room
       - Unorganized, scattered
       - Slower access
       - Large space
       - Items may stay for long time
```

---

## 3. Stack Memory

### What is Stack?

```text
Stack is a memory region where:
- Primitive values are stored
- Method calls are tracked
- Local variables are stored
- Memory follows LIFO (Last In, First Out) principle
```

### How Stack Works

```text
When a method is called:
1. Method pushed onto stack
2. Local variables allocated
3. Method completes
4. Method popped from stack
5. Memory automatically freed
```

### ASCII Representation

```text
Stack Memory (LIFO)
┌─────────────┐
│ method3()   │  ← Top of stack (Last added)
├─────────────┤
│ method2()   │
├─────────────┤
│ method1()   │
├─────────────┤
│ main()      │  ← Bottom of stack (First added)
└─────────────┘

Execution order: method1 → method2 → method3 → pop method3 → pop method2 → pop method1
```

---

### Stack Characteristics

```text
+---------------------------+---------------------------+
| Feature                   | Characteristic            |
+---------------------------+---------------------------+
| Size                      | Limited (smaller)         |
| Allocation                | Automatic                 |
| Deallocation              | Automatic                 |
| Access Speed              | Fast                      |
| Thread Safety             | Each thread has own stack |
| Data Type                 | Primitives + References   |
+---------------------------+---------------------------+
```

---

### Stack Example

```java
public void demo() {
    int age = 25;           // Allocated on stack
    int score = 95;         // Allocated on stack
    String name = "Tejas";  // Reference on stack, object on heap
}
// All stack variables freed when method ends
```

### Visual Stack Layout

```text
Stack (when inside demo() method)

Top →  ┌──────────────┐
       │ name: 0x101  │  (reference to string on heap)
       ├──────────────┤
       │ score: 95    │  (primitive value)
       ├──────────────┤
       │ age: 25      │  (primitive value)
       └──────────────┘
```

---

## 4. Heap Memory

### What is Heap?

```text
Heap is a memory region where:
- Objects are stored
- Dynamically allocated
- Larger than stack
- Shared across all methods
- Memory managed by Garbage Collector
```

### How Heap Works

```text
Objects are created with 'new' keyword:
String name = new String("Tejas");

1. 'new' allocates memory on heap
2. Reference stored on stack
3. Object persists until no references remain
4. Garbage collector frees memory
```

---

### Heap Characteristics

```text
+---------------------------+---------------------------+
| Feature                   | Characteristic            |
+---------------------------+---------------------------+
| Size                      | Large                     |
| Allocation                | Manual (with new)         |
| Deallocation              | Automatic (GC)            |
| Access Speed              | Relatively slower         |
| Thread Safety             | Shared (needs care)       |
| Data Type                 | Only Objects              |
+---------------------------+---------------------------+
```

---

### Heap Example

```java
String name = new String("Tejas");
int[] arr = new int[5];
Car car = new Car();

// name, arr, car are references on stack
// String object, array, Car object are on heap
```

---

## 5. Stack vs Heap Comparison

```text
+------------------+-------------------+-------------------+
| Aspect           | Stack             | Heap              |
+------------------+-------------------+-------------------+
| Size             | Small (limited)   | Large             |
| Speed            | Fast              | Slower            |
| Data Stored      | Primitives, refs  | Objects only      |
| Lifetime         | Until method end  | Until no refs     |
| Thread Safe      | Each thread own   | Shared (risky)    |
| Memory Mgmt      | Automatic         | Automatic (GC)    |
| Overflow         | StackOverflow     | OutOfMemory       |
+------------------+-------------------+-------------------+
```

---

## 6. Primitive Types in Memory

### Storage

```text
Primitive types store ACTUAL values on stack

int age = 25;

Stack:
┌─────────────┐
│ age: 25     │  (actual value stored)
└─────────────┘
```

### Example

```java
int x = 10;
int y = x;  // y gets value 10 (copy)

x = 20;     // Changes x only

System.out.println(x);  // 20
System.out.println(y);  // 10 (unchanged)
```

### Memory Diagram

```text
Initial:
Stack:
┌─────────────┐
│ x: 10       │
├─────────────┤
│ y: 10       │
└─────────────┘

After x = 20:
Stack:
┌─────────────┐
│ x: 20       │
├─────────────┤
│ y: 10       │
└─────────────┘

x and y are INDEPENDENT
```

---

## 7. Reference Types in Memory

### Storage

```text
Reference types store REFERENCE (address) on stack
OBJECT stored on heap

String name = "Tejas";

Stack:           Heap:
┌─────────────┐  ┌─────────────────┐
│ name: 0x101 │─→│ "Tejas" object  │
└─────────────┘  └─────────────────┘
     ref              object
(on stack)         (on heap)
```

---

### Example

```java
String s1 = new String("Hello");
String s2 = s1;  // s2 gets reference to same object

s1 = new String("World");  // s1 points to different object

System.out.println(s1);  // "World"
System.out.println(s2);  // "Hello"
```

### Memory Diagram

```text
Initial:
Stack:                  Heap:
┌─────────────┐        ┌────────────┐
│ s1: 0x101   │───────→│ "Hello"    │
├─────────────┤        └────────────┘
│ s2: 0x101   │─┐
└─────────────┘ │
                └──→ (same object)

After s1 = new String("World"):
Stack:                  Heap:
┌─────────────┐        ┌────────────┐
│ s1: 0x102   │───────→│ "World"    │
├─────────────┤        └────────────┘
│ s2: 0x101   │───────→┌────────────┐
└─────────────┘        │ "Hello"    │
                       └────────────┘

s1 and s2 now point to DIFFERENT objects
```

---

## 8. Pass by Value Concept

### Fundamental Rule

```text
Java ALWAYS passes by VALUE.

Meaning:
- Copy of data is passed to method
- Changes inside method don't affect original
```

---

### Pass by Value with Primitives

```java
public void changeValue(int x) {
    x = 100;  // Changes local copy only
}

int age = 25;
changeValue(age);

System.out.println(age);  // Still 25 (unchanged)
```

### Memory Diagram

```text
Before calling changeValue():
Stack:
┌──────────────────┐
│ age: 25          │
└──────────────────┘

Inside changeValue():
Stack:
┌──────────────────┐
│ (in main) age: 25│
├──────────────────┤
│ (in method) x: 25│  (copy of age)
└──────────────────┘

Inside changeValue() after x = 100:
Stack:
┌──────────────────┐
│ (in main) age: 25│  (unchanged)
├──────────────────┤
│ (in method) x: 100│ (local copy changed)
└──────────────────┘

After method ends:
Stack:
┌──────────────────┐
│ age: 25          │  (still 25)
└──────────────────┘
```

---

### Pass by Value with References (Important!)

```java
public void changeObject(Student student) {
    student.name = "Changed";  // Modifies OBJECT
    student = new Student();   // Doesn't change original reference
}

Student s = new Student();
s.name = "Original";
changeObject(s);

System.out.println(s.name);  // "Changed" (object modified)
```

### Memory Explanation

```text
Important: Reference is passed by VALUE
Meaning: Copy of REFERENCE is passed, not copy of object

Stack:                      Heap:
┌──────────────────┐        ┌────────────┐
│ (main) s: 0x101  │───────→│ Student    │
│                  │        │ name:"Orig"│
├──────────────────┤        └────────────┘
│ (method)         │
│ student: 0x101   │───────→(same object)
│                  │
│ (after new)      │
│ student: 0x102   │───────→┌────────────┐
└──────────────────┘        │ new Student│
                            └────────────┘

Key point:
- student.name = "Changed" → modifies 0x101 object ✓ affects original
- student = new Student() → changes local reference only ✗ doesn't affect s
```

---

## 9. Complete Memory Example

```java
class Car {
    String color = "Red";
}

public void demo() {
    int price = 1000000;
    Car car = new Car();
    String model = "Tesla";
}
```

### Memory Layout Inside demo()

```text
Stack:                              Heap:
┌──────────────────────┐           ┌──────────────┐
│ model: 0x102         │──────────→│ "Tesla"      │
├──────────────────────┤           ├──────────────┤
│ car: 0x101           │──────────→│ Car object   │
│                      │           │ color:"Red"  │
├──────────────────────┤           └──────────────┘
│ price: 1000000       │
└──────────────────────┘

Stack stores:
- price = primitive value
- car = reference to object
- model = reference to string

Heap stores:
- Car object
- String "Tesla"
```

---

## 10. Garbage Collection

### What is Garbage Collection?

```text
Garbage Collection is automatic memory cleanup.
When an object has NO references pointing to it,
GC marks it for deletion and frees memory.
```

### Example

```java
String str = new String("Hello");  // Object created, reference exists
str = null;                        // Reference removed
// Object is now eligible for garbage collection
```

### Visual

```text
Before:
str: 0x101 ──→ "Hello" object

After str = null:
str: null

"Hello" object → no references → eligible for GC → memory freed
```

---

## 11. Memory Leaks

### What is a Memory Leak?

```text
Memory leak occurs when objects are no longer needed
but still referenced somewhere, so GC cannot free them.
```

### Example 1: Static Collections

```java
static List<String> cache = new ArrayList<>();

public void addToCache(String data) {
    cache.add(data);  // Added but never removed
    // Memory leak: cache keeps growing
}
```

### Example 2: Circular References (Java handles this)

```java
class Node {
    Node next;
}

Node n1 = new Node();
Node n2 = new Node();
n1.next = n2;
n2.next = n1;  // Circular reference

n1 = null;
n2 = null;  // Even with circular ref, GC handles this
// Java GC is smart enough to detect and clean
```

---

## 12. Stack Overflow

### Cause

```text
Stack has limited size.
Too many method calls create StackOverflowError.
```

### Example: Infinite Recursion

```java
public void recursiveMethod() {
    recursiveMethod();  // Calls itself infinitely
    // Each call → method pushed to stack
    // Stack overflows!
}
```

### Visual

```text
Stack growing:
┌─────────────────────┐
│ recursiveMethod #10 │
├─────────────────────┤
│ recursiveMethod #9  │
├─────────────────────┤
│ ...                 │
├─────────────────────┤
│ recursiveMethod #1  │
├─────────────────────┤
│ main()              │
└─────────────────────┘

Eventually → Stack Overflow!
```

---

## 13. Out of Memory

### Cause

```text
Heap is full, no space for new objects.
Occurs when too many large objects created.
```

### Example

```java
List<byte[]> list = new ArrayList<>();

// Creating many large objects
for (int i = 0; i < 1000000; i++) {
    list.add(new byte[1024 * 1024]);  // 1MB each
}
// Eventually → OutOfMemoryError
```

---

## 14. Memory Best Practices

### Best Practice 1: Avoid Unnecessary Object Creation

```java
// WRONG: Creates new String in each iteration
for (int i = 0; i < 10000; i++) {
    String str = new String("Hello");
}

// RIGHT: Reuse String
String str = "Hello";
for (int i = 0; i < 10000; i++) {
    // Use str
}
```

---

### Best Practice 2: Manage References Properly

```java
// After use, set to null if long-living objects
large bigObject = new LargeObject();
// Use bigObject
bigObject = null;  // Eligible for GC
```

---

### Best Practice 3: Use Try-with-Resources

```java
// Auto closes resource
try (Scanner scanner = new Scanner(file)) {
    // Use scanner
}
// Resource automatically closed and freed
```

---

## 15. Real-Life Example: Memory Usage Tracking

```java
// Tracking what's on stack vs heap:

public void processData() {
    // STACK
    int count = 0;          // Stack: 4 bytes
    boolean flag = true;    // Stack: 1 bit
    
    // HEAP
    String data = new String("Important");  // Stack: reference, Heap: String object
    int[] array = new int[100];             // Stack: reference, Heap: array of 100 ints
    
    // When processData() ends:
    // - All stack variables freed
    // - Heap objects freed only when no references exist
}
```

---

## 16. Interview Tips

```text
1. Stack vs Heap differences
   - Know size, speed, lifetime characteristics

2. Pass by value explanation
   - Always emphasize: Java passes by VALUE
   - References are passed by VALUE (copy of reference)

3. Memory diagram
   - Be able to draw stack and heap
   - Show how references work

4. Garbage collection understanding
   - Automatic cleanup when no references
   - Cannot force GC (System.gc() is just request)

5. Memory leaks
   - Static collections that keep growing
   - Unclosed resources

6. Stack vs Heap with examples
   - Primitives on stack
   - Objects on heap
   - References on stack pointing to heap
```

---

## 17. Key Takeaways

```text
- Stack: Fast, limited, automatic, for primitives and references
- Heap: Slower, large, automatic (GC), for objects
- Primitives stored as actual values on stack
- References stored as addresses on stack, objects on heap
- Java passes by VALUE (copies are passed)
- With reference types, copy of reference is passed (still points to same object)
- Garbage collection automatically frees unused objects
- Memory leaks occur when objects referenced but not needed
- Stack overflow from too many method calls
- Out of memory from too many/large objects
```

---

## 18. Common Mistakes to Avoid

```text
❌ Confusing pass by value with pass by reference
   ✓ Always: Java passes by VALUE

❌ Thinking you can free memory manually
   ✓ Garbage collector handles this automatically

❌ Creating objects unnecessarily in loops
   ✓ Reuse objects when possible

❌ Assuming == works for object comparison
   ✓ Use equals() for content comparison

❌ Not closing resources (files, streams)
   ✓ Use try-with-resources or finally blocks
```

---

## Final Thought

```text
Understanding memory is crucial for writing efficient Java code.
Know where data lives (stack vs heap) and why, 
and you'll write programs that are both fast and reliable.
```

---


