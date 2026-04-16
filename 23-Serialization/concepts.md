# Day 23: Serialization and Deserialization

---

## Overview

```text
Goal:
Master object serialization for persistence

You will learn:
- Serializable interface
- Object serialization
- Object deserialization
- Transient keyword
- SerialVersionUID
```

---

## 1. Serialization

```text
Converting object to byte stream for storage or transmission
```

---

## 2. Serializable Interface

```java
class Person implements Serializable {
    private String name;
    private int age;
}
```

---

## 3. Writing Object

```java
ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.dat"));
out.writeObject(person);
out.close();
```

---

## 4. Reading Object

```java
ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.dat"));
Person person = (Person) in.readObject();
in.close();
```

---

## 5. Transient Fields

```java
class User implements Serializable {
    String username;
    transient String password;  // Not serialized
}
```

---

## 6. SerialVersionUID

```java
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
}
```

---

## 7. Key Takeaways

```text
- Serialization converts objects to bytes
- Implement Serializable interface
- Use transient for sensitive data
- SerialVersionUID for version control
```

---


