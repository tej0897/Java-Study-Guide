# Day 6: Strings and String Handling

---

## Overview

```text
Goal:
Understand how to work with text data in Java and the various ways to manipulate strings

You will learn:
- What is a String
- String immutability
- String pool concept
- String vs StringBuilder vs StringBuffer
- Common String methods
- Memory behavior of Strings
- When to use each String type
```

---

## 1. What is a String?

```text
A String is a sequence of characters (text) stored as an object in Java.
Strings are immutable, meaning once created, they cannot be changed.
```

### Simple Understanding

```text
String = Text Data Type
"Hello" = String value
```

---

## 2. Real-Life Analogy

```text
Think of a DVD movie:

Once a DVD is written, you cannot change what's on it.
If you want different content, you need a new DVD.

Similarly:
String = Immutable (like written DVD)
String value = Content on DVD
```

---

## 3. Creating Strings

### Method 1: String Literal

```java
String name = "Tejas";
```

### Method 2: Using new Keyword

```java
String name = new String("Tejas");
```

### Difference

```text
Literal       → Created in String Pool (memory efficient)
new Keyword   → Created in Heap (separate object)
```

---

## 4. String Pool Concept

```text
What is String Pool?

String Pool is a special memory region in Java
where string literals are stored.

If same string literal is used multiple times,
only ONE copy is stored in pool.
```

### ASCII Representation

```text
String Pool (Memory)
+------------------+
| "Hello"   ← ref1 |
| "World"   ← ref2 |
+------------------+

String s1 = "Hello";  // Points to pool
String s2 = "Hello";  // Points to SAME pool object

s1 == s2  → true (same reference)
```

### Heap Memory

```text
Heap Memory
+------------------+
| "Hello" ← ref3    |
| "Hello" ← ref4    |
+------------------+

String s3 = new String("Hello");  // New object in heap
String s4 = new String("Hello");  // Another new object

s3 == s4  → false (different objects)
s3.equals(s4)  → true (same content)
```

---

## 5. String Immutability

```text
Definition:
Once a String is created, it CANNOT be modified.
Any operation on String creates a NEW String.
```

### Example

```java
String str = "Hello";
str = str + " World";

// What happens:
// 1. "Hello" exists (original)
// 2. " World" is created
// 3. Concatenation creates NEW string "Hello World"
// 4. str now points to new string
// 5. Old "Hello" may be garbage collected
```

### Visual Flow

```text
Original String (Immutable)
"Hello" → (cannot modify)

str = str + " World"  → Creates NEW string "Hello World"

Memory:
"Hello"        (old, eligible for GC)
"Hello World"  (new, str points here)
```

---

## 6. String Concatenation

### Method 1: + Operator

```java
String s1 = "Hello";
String s2 = "World";
String s3 = s1 + " " + s2;
// Result: "Hello World"
```

### Method 2: concat() Method

```java
String s3 = s1.concat(" ").concat(s2);
```

### Problem with Repeated Concatenation

```java
// INEFFICIENT: Creates multiple intermediate strings
String result = "";
for (int i = 0; i < 1000; i++) {
    result = result + i;  // Creates new String each time
}
// Performance issue: Creates 1000 String objects!
```

---

## 7. String vs StringBuilder vs StringBuffer

### Comparison Table

```text
+-------------------+---------------------+---------------------+
| Feature           | String              | StringBuilder       |
+-------------------+---------------------+---------------------+
| Immutable         | Yes                 | No                  |
| Thread-Safe       | Yes (inherent)      | No                  |
| Performance       | Slow (copies)       | Fast                |
| Memory Usage      | High (duplication)  | Low                 |
| Use Case          | When not modified   | Frequent changes    |
+-------------------+---------------------+---------------------+

StringBuffer = StringBuilder but Thread-Safe (slower)
```

---

## 8. When to Use Each Type?

### String

```text
✓ When string doesn't change
✓ When using string literals
✓ When thread safety is needed
✓ When performance of individual operations matters less
```

### Example

```java
String email = "user@example.com";
String name = "Tejas";
// Simple assignment - use String
```

---

### StringBuilder

```text
✓ When making many modifications
✓ Building complex strings in loops
✓ When NOT in multi-threaded environment
✓ When performance is critical
```

### Example

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);  // Efficient
}
String result = sb.toString();
```

---

### StringBuffer

```text
✓ Same as StringBuilder
✓ BUT in multi-threaded environment
✓ Slightly slower due to synchronization
```

### Example

```java
StringBuffer sb = new StringBuffer();
// In multi-threaded code (safe but slower)
```

---

## 9. Common String Methods

### Method to Check Content

```text
+----------------------------------+----------------------------------+
| Method                           | Purpose                          |
+----------------------------------+----------------------------------+
| length()                         | Returns length of string         |
| isEmpty()                        | Checks if string is empty        |
| equals(String)                   | Compares two strings (content)   |
| equalsIgnoreCase(String)         | Compares (ignores case)          |
| compareTo(String)                | Compares lexicographically       |
+----------------------------------+----------------------------------+
```

### Method to Access Content

```text
+----------------------------------+----------------------------------+
| Method                           | Purpose                          |
+----------------------------------+----------------------------------+
| charAt(int)                      | Returns character at index       |
| substring(int)                   | Extracts substring from index    |
| substring(int, int)              | Extracts between indices         |
| indexOf(String)                  | Finds first occurrence           |
| lastIndexOf(String)              | Finds last occurrence            |
+----------------------------------+----------------------------------+
```

### Method to Modify Content

```text
+----------------------------------+----------------------------------+
| Method                           | Purpose                          |
+----------------------------------+----------------------------------+
| concat(String)                   | Concatenates strings             |
| replace(char, char)              | Replaces all occurrences         |
| replaceAll(String, String)       | Regex-based replacement          |
| toUpperCase()                    | Converts to uppercase            |
| toLowerCase()                    | Converts to lowercase            |
| trim()                           | Removes leading/trailing spaces  |
| split(String)                    | Splits by delimiter              |
+----------------------------------+----------------------------------+
```

---

## 10. String Method Examples

### length() and isEmpty()

```java
String str = "Hello";
System.out.println(str.length());     // 5
System.out.println(str.isEmpty());    // false
```

### charAt() and substring()

```java
String str = "Hello";
System.out.println(str.charAt(0));     // 'H'
System.out.println(str.substring(1));  // "ello"
System.out.println(str.substring(1, 4)); // "ell"
```

### indexOf() and lastIndexOf()

```java
String str = "hello world hello";
System.out.println(str.indexOf("hello"));     // 0
System.out.println(str.lastIndexOf("hello")); // 12
```

### replace() and split()

```java
String str = "Java is great";
String replaced = str.replace("Java", "Python");
// Result: "Python is great"

String[] words = str.split(" ");
// Result: ["Java", "is", "great"]
```

### toUpperCase() and toLowerCase()

```java
String str = "Hello World";
System.out.println(str.toUpperCase());  // "HELLO WORLD"
System.out.println(str.toLowerCase());  // "hello world"
```

---

## 11. Comparing Strings - Common Mistakes

### WRONG: Using == for comparison

```java
String s1 = "Hello";
String s2 = new String("Hello");

if (s1 == s2) {  // FALSE! Compares references, not content
    System.out.println("Same");
}
// s1 points to pool, s2 points to heap
// Different references!
```

### RIGHT: Using equals()

```java
String s1 = "Hello";
String s2 = new String("Hello");

if (s1.equals(s2)) {  // TRUE! Compares content
    System.out.println("Same");
}
```

### Visual Explanation

```text
Using ==

String s1 = "Hello";  → Points to pool
String s2 = new String("Hello");  → Points to heap

s1 == s2  → false (different memory locations)

Using equals()

s1.equals(s2)  → true (same content: "Hello")
```

---

## 12. Memory Behavior of Strings

### Case 1: String Literals

```java
String s1 = "Hello";
String s2 = "Hello";

// Both point to SAME object in String Pool
s1 == s2  → true
```

### Case 2: Using new Keyword

```java
String s1 = new String("Hello");
String s2 = new String("Hello");

// Both are DIFFERENT objects in Heap
s1 == s2  → false
s1.equals(s2)  → true
```

### Case 3: Reassignment

```java
String s1 = "Hello";
s1 = s1 + " World";  // Creates new String object

// s1 now points to new string "Hello World"
// Old string may be garbage collected
```

### Memory Diagram

```text
String Pool          Heap
+---------+          +--------+
| "Hello" |          | "Hello" |
+---------+          +--------+
  ↑ s1, s2           ↑ s3, s4

String s1 = "Hello";
String s2 = "Hello";
String s3 = new String("Hello");
String s4 = new String("Hello");

s1 == s2  → true (same pool object)
s1 == s3  → false (different locations)
s3 == s4  → false (different heap objects)
```

---

## 13. StringBuilder Performance

### Inefficient (Multiple String Objects)

```java
String result = "";
for (int i = 0; i < 100; i++) {
    result = result + i;  // 100 String objects created!
}

Memory: O(n²) due to multiple intermediate strings
Time: O(n²) due to copying
```

### Efficient (Single StringBuilder)

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 100; i++) {
    sb.append(i);  // Modifies single buffer
}
String result = sb.toString();

Memory: O(n)
Time: O(n)
```

---

## 14. Real-Life Example (Email Validation)

```java
String email = "user@example.com";

// Check if valid email
if (email.contains("@") && email.contains(".")) {
    System.out.println("Valid email");
}

// Extract domain
String domain = email.substring(email.indexOf("@") + 1);
// Result: "example.com"
```

---

## 15. Real-Life Example (String Processing)

```java
String data = "Java:Python:C++:JavaScript";

// Split by colon
String[] languages = data.split(":");
// Result: ["Java", "Python", "C++", "JavaScript"]

// Process each
for (String lang : languages) {
    System.out.println("Learning " + lang);
}
```

---

## 16. String Interning

```text
String interning is the process of storing only one copy
of duplicate string literals in memory.
```

### intern() Method

```java
String s1 = new String("Hello");
String s2 = s1.intern();  // Moves to String Pool

String s3 = "Hello";

s2 == s3  → true (both point to pool now)
```

```text
Note: Use intern() carefully - it has performance implications
for large scale applications.
```

---

## 17. Edge Cases and Common Mistakes

### Edge Case 1: null String

```java
String str = null;
if (str.equals("Hello")) {  // NullPointerException!
    // ...
}

// FIX: Check null first
if (str != null && str.equals("Hello")) {
    // ...
}
```

### Edge Case 2: Empty vs null

```java
String str = "";
System.out.println(str.isEmpty());  // true
System.out.println(str == null);    // false

// Empty is not null!
```

### Edge Case 3: Whitespace

```java
String str = "  Hello  ";
System.out.println(str.length());      // 9 (includes spaces)
System.out.println(str.trim().length()); // 5 (spaces removed)
```

---

## 18. Interview Tips

```text
1. Explain String immutability clearly
   - Once created, cannot change
   - New objects created on modification

2. String vs StringBuilder distinction
   - String for unchanging data
   - StringBuilder for frequent modifications

3. == vs equals() difference
   - == compares references
   - equals() compares content

4. String Pool concept
   - Memory optimization
   - Helps reuse duplicate literals

5. Performance implications
   - String concatenation in loops is inefficient
   - Use StringBuilder for concatenation

6. Memory diagram
   - Be able to draw String Pool vs Heap
   - Explain why s1 == s2 might be true or false
```

---

## 19. Key Takeaways

```text
- String is immutable (cannot be modified after creation)
- String literals go to String Pool (memory efficient)
- new String() creates object in Heap (separate copy)
- Use == for reference comparison (rarely needed)
- Use equals() for content comparison (usually what you want)
- StringBuilder for frequent string modifications
- StringBuffer for multi-threaded environments
- String methods provide powerful text manipulation
- Understand memory behavior to write efficient code
```

---

## 20. Common Mistakes to Avoid

```text
❌ Using == to compare string content
   ✓ Use equals() instead

❌ Concatenating strings in loops
   ✓ Use StringBuilder

❌ Not checking for null before equals()
   ✓ Always check null first

❌ Confusing String, StringBuilder, StringBuffer
   ✓ Know use cases for each

❌ Assuming substring includes both indices
   ✓ Remember: excludes end index (substring(0, 3) → indices 0, 1, 2)
```

---

## Final Thought

```text
Strings are fundamental to programming.
Master string handling, and you can process any text data efficiently.
Understanding immutability teaches you about memory and performance.
```

---


