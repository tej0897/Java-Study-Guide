# Day 14: Access Modifiers and Packages

---

## Overview

```text
Goal:
Master access control and organize code into packages

You will learn:
- All four access modifiers (public, private, protected, default)
- Packages and package structure
- import statements
- Organizing code
- Access levels across packages
- Best practices for organizing code
```

---

## 1. Packages

### What is a Package?

```text
Package is a namespace for organizing related classes
Prevents naming conflicts
Groups related functionality
```

### Package Declaration

```java
package com.example.utils;  // Package name

public class StringUtils {
    // Class in package
}
```

---

## 2. Access Modifiers Summary

```text
+------------------+--------+--------+---------+-------+
| Modifier         | Same   | Package| Package | World |
|                  | Class  |        | (child) |       |
+------------------+--------+--------+---------+-------+
| public           | Yes    | Yes    | Yes     | Yes   |
| protected        | Yes    | Yes    | Yes     | No    |
| default (none)   | Yes    | Yes    | No      | No    |
| private          | Yes    | No     | No      | No    |
+------------------+--------+--------+---------+-------+
```

---

## 3. Public Access

```java
public class PublicClass { }
public void publicMethod() { }

// Accessible from anywhere
```

---

## 4. Private Access

```java
private int privateVariable;
private void privateMethod() { }

// Accessible only within same class
```

---

## 5. Protected Access

```java
protected String protectedVariable;
protected void protectedMethod() { }

// Accessible in same package + subclasses (even outside package)
```

---

## 6. Default (Package-Private) Access

```java
class DefaultClass { }  // No modifier
void defaultMethod() { }

// Accessible only within same package
```

---

## 7. Import Statements

### Specific Import

```java
import java.util.ArrayList;
import java.util.HashMap;
```

---

### Wildcard Import

```java
import java.util.*;  // Import all from java.util
```

---

## 8. Package Structure

```text
com
└── example
    ├── utils
    │   ├── StringUtils.java
    │   └── DateUtils.java
    ├── models
    │   ├── User.java
    │   └── Product.java
    └── controllers
        └── UserController.java
```

---

## 9. Real-Life Example: Bank Package

```java
// In package: com.bank.account

package com.bank.account;

public class BankAccount {
    private double balance;  // Private to class
    protected String accountNumber;  // Protected, for subclasses
    
    public void deposit(double amount) {  // Public interface
    }
    
    private void validateAmount(double amount) {  // Internal method
    }
}

class InternalHelper {  // Default: only in package
    void helperMethod() { }
}
```

---

## 10. Best Practices

### Principle 1: Use Least Restrictive Access

```text
✓ Start with private
✓ Expand only when needed
✓ Default: private unless reason to change
```

---

### Principle 2: Organize by Functionality

```text
Good:
com.bank.accounts
com.bank.transactions
com.bank.reports

Bad:
com.bank.all
com.bank.classes
```

---

### Principle 3: One Public Class Per File

```java
// Good: File UserController.java
public class UserController {
}

// Bad: Multiple public classes in one file
public class UserController {
}
public class ProductController {
}
```

---

## 11. Interview Tips

```text
1. Access modifiers
   - Know all four
   - Know visibility scope for each
   - Protected vs default difference

2. Packages
   - Group related classes
   - Prevent naming conflicts
   - Organize large projects

3. import statements
   - Specific vs wildcard
   - Import resolves fully qualified names

4. Best practices
   - Use appropriate modifier
   - Organize logically
   - Use packages effectively

5. Real-world structure
   - Multi-layer architecture
   - Separation of concerns
   - Clear responsibilities
```

---

## 12. Key Takeaways

```text
- Packages organize code into namespaces
- Four access modifiers control visibility
- public: accessible everywhere
- private: only within same class
- protected: within package + subclasses
- default: only within same package
- Use least restrictive access needed
- Organize packages by functionality
```

---

## Final Thought

```text
Good code organization is as important as good code design.
Use packages and access modifiers wisely to create clean,
maintainable, and secure code.
```

---


