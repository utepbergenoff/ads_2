# Data Structures Project (Java)

This project implements custom generic data structures in Java without using any `java.util` collections internally. All logic is built from scratch, using only core Java features.

## Implemented Data Structures

### 1. `MyList<T>` Interface
Defines the common operations for custom list implementations:
- `add(T item)`, `add(int index, T item)`
- `set(int index, T item)`, `get(int index)`
- `getFirst()`, `getLast()`
- `remove(int index)`, `removeFirst()`, `removeLast()`
- `sort()`
- `indexOf()`, `lastIndexOf()`, `exists()`
- `toArray()`
- `clear()`
- `size()`

### 2. `MyArrayList<T>`
- Dynamic array-based list
- Resizes automatically as needed

### 3. `MyLinkedList<T>`
- Doubly linked list implementation
- Optimized `getNode(int)` using index proximity

### 4. `MyStack<T>`
- LIFO stack built using `MyLinkedList<T>`
- Methods: `push(T)`, `pop()`, `peek()`, `isEmpty()`, `size()`, `clear()`

### 5. `MyQueue<T>`
- FIFO queue built using `MyLinkedList<T>`
- Methods: `enqueue(T)`, `dequeue()`, `peek()`, `isEmpty()`, `size()`, `clear()`

### 6. `MyMinHeap<T>`
- Min-heap priority queue implementation
- Backed by dynamic array (custom)
- Supports `add`, `poll`, `peek`, `size`, and `clear`

## How to Compile and Run
Make sure all `.java` files are in the same directory.

### Compile:
```bash
javac *.java
```

### Run Tests:
- ArrayList tests are inside the `main` method of the main file.
- LinkedList tests are located in the `TestMyLinkedList` class.

```bash
java Main  # or the file with MyArrayList test
java TestMyLinkedList
```

## Notes
- These implementations are for learning purposes and demonstrate manual memory and structure management in Java.
- Sorting is implemented using `Arrays.sort()` after converting to a temporary array.



---
Created by: Yerlan Utepbergenov

