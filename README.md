# JUnit 5 Learning Guide

This README documents my learning journey and practical understanding of **JUnit 5**, focusing on writing effective unit tests using assertions, lifecycle annotations, and advanced testing features.

---

## 📘 Introduction to JUnit 5

JUnit 5 is the modern testing framework for Java applications. It provides powerful annotations, assertions, lifecycle management, and flexible testing structures.

JUnit 5 consists of:

* **JUnit Platform** – Runs tests
* **JUnit Jupiter** – Programming model + API
* **JUnit Vintage** – Supports older JUnit versions

---

## ⚙️ Maven Project Setup

### Step 1: Create Maven Project

```bash
mvn archetype:generate
```

### Step 2: Add JUnit 5 Dependency

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Step 3: Configure Maven Surefire Plugin

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
        </plugin>
    </plugins>
</build>
```

---

## ✅ Assertions in JUnit 5

Assertions validate expected outcomes in test cases.

### AssertEquals

```java
assertEquals(5, calculator.add(2,3));
```

### AssertNotEquals

```java
assertNotEquals(10, calculator.add(2,3));
```

### AssertTrue

```java
assertTrue(user.isActive());
```

### AssertFalse

```java
assertFalse(user.isBlocked());
```

### AssertThrows

```java
assertThrows(IllegalArgumentException.class, () -> {
    calculator.divide(10,0);
});
```

---

## 🏷️ Test Metadata Annotations

### @DisplayName

Provides readable test names.

```java
@DisplayName("Addition should return correct result")
```

### @Disabled

Skips execution of a test.

```java
@Disabled("Feature under development")
```

---

## 🔄 Test Lifecycle Annotations

### @BeforeEach

Runs before every test.

```java
@BeforeEach
void setup() {}
```

### @AfterEach

Runs after every test.

```java
@AfterEach
void cleanup() {}
```

### @BeforeAll

Runs once before all tests.

```java
@BeforeAll
static void initAll() {}
```

### @AfterAll

Runs once after all tests.

```java
@AfterAll
static void tearDownAll() {}
```

---

## 🧠 Test Instance Lifecycle

Controls test object creation.

```java
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
```

Options:

* PER_METHOD (default)
* PER_CLASS

---

## ⚠️ Assumptions

Used to execute tests only when conditions are satisfied.

```java
assumeTrue("DEV".equals(System.getenv("ENV")));
```

If assumption fails → test is skipped.

---

## 🧩 Nested Tests

Used to group related tests.

```java
@Nested
class LoginTests {

    @Test
    void validLogin() {}
}
```

---

## 🔁 Repeated Tests

Runs the same test multiple times.

```java
@RepeatedTest(5)
void repeatedExample() {}
```

---

## 🎯 Learning Summary

✔ Maven setup for JUnit 5
✔ Core Assertions
✔ Lifecycle annotations
✔ Test metadata annotations
✔ Assumptions and conditions
✔ Nested testing structure
✔ Repeated test execution

**Author:** Saranga Samarakoon
**Topic:** JUnit 5 Unit Testing Learning Journey
