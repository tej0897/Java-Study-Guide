# Day 40: Clean Architecture Basics (Controller → Service → Repository)

---

## Overview

```text
Goal:
Understand how to structure a backend application into layers so it is:
- Easier to test
- Easier to maintain
- Easier to change (e.g., swap database, change REST framework)

You will learn:
- Controller layer (API / input boundary)
- Service layer (business logic)
- Repository layer (data access)
- DTOs (data transfer objects)
- Why dependencies should point inward (toward business rules)
```

---

## 1. Typical Layered Flow

```text
Client -> Controller -> Service -> Repository -> Database

Controller:
- Parses request
- Validates input (basic)
- Calls service
- Maps result to response

Service:
- Holds business logic
- Orchestrates repositories
- Throws domain/business exceptions

Repository:
- Talks to data source (DB, file, API)
- Returns domain objects
```

---

## 2. Dependency Rule (Simple)

```text
High-level code (business logic) should NOT depend on low-level details.

Prefer:
Service depends on an interface (Repository)
Repository implementation provides the details.
```

---

## 3. Key Takeaways

```text
- Keep controllers thin
- Put business rules in services
- Hide data access behind repositories
- Use interfaces at layer boundaries when it helps testing
- Consistent error handling belongs at the boundary (controller layer)
```

---

