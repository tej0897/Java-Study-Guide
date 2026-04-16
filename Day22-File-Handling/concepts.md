# Day 22: File Handling (I/O Streams)

---

## Overview

```text
Goal:
Master file operations and I/O streams

You will learn:
- File I/O basics
- Reading and writing files
- Byte streams vs Character streams
- Try-with-resources
- File operations
```

---

## 1. File Class

```java
File file = new File("data.txt");
file.exists()
file.isFile()
file.isDirectory()
file.getAbsolutePath()
```

---

## 2. Reading Files

### FileReader and BufferedReader

```java
try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
}
```

---

## 3. Writing Files

### FileWriter

```java
try (FileWriter writer = new FileWriter("output.txt")) {
    writer.write("Hello, World!");
}
```

---

## 4. Byte Streams

```java
FileInputStream fis = new FileInputStream("image.png");
FileOutputStream fos = new FileOutputStream("copy.png");
```

---

## 5. Try-With-Resources

```java
try (Scanner scanner = new Scanner(file)) {
    while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
    }
}
```

---

## 6. Common Operations

```text
Files.readAllLines(path)
Files.write(path, content)
Files.copy(source, target)
Files.delete(path)
Files.list(directory)
```

---

## 7. Key Takeaways

```text
- File I/O essential for data persistence
- Use try-with-resources for auto-close
- Character streams for text
- Byte streams for binary data
- BufferedReader/Writer for efficiency
```

---


