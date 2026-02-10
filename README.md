# UserLinkedList – Custom LinkedList Implementation in Java

## Overview
This project implements a generic singly linked list in Java from scratch, without using Java’s built-in `LinkedList` class.  
It is designed to demonstrate a clear understanding of data structures, generics, pointer manipulation, and exception handling.

This repository is suitable for DSA practice, Java interviews, and learning how collections work internally.

---

## Features
- Generic `UserLinkedlist<E>` implementation
- Head and tail pointer optimization
- Index-based insertion and deletion
- Custom runtime exceptions
- Complete driver class for testing
- Clean and readable code

---

## Concepts Used
- Singly Linked List
- Generics in Java
- Custom Exception Handling
- Time and Space Complexity
- Node-based data structures

---

## Project Structure

---

## Supported Operations

### Insertion
- add(E element)
- addFirst(E element)
- addLast(E element)
- add(int index, E element)

### Removal
- remove()
- removeFirst()
- removeLast()
- remove(int index)

### Access & Search
- get(int index)
- getFirst()
- getLast()
- contains(Object o)
- indexOf(Object o)

### Utility
- size()
- isEmpty()
- clear()
- toString()

---

## Time Complexity

| Operation           | Complexity |
|--------------------|------------|
| addFirst           | O(1) |
| addLast            | O(1) |
| removeFirst        | O(1) |
| removeLast         | O(n) |
| get(index)         | O(n) |
| add(index)         | O(n) |
| remove(index)      | O(n) |
| contains/indexOf   | O(n) |
| clear              | O(1) |




