class UserNoSuchElementException extends RuntimeException {
    UserNoSuchElementException() {
        super("No such element present");
    }
}

class UserIndexOutOfBoundsException extends RuntimeException {
    UserIndexOutOfBoundsException(String desc) {
        super(desc);
    }
}

class UserLinkedlist<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    private class Node<E> {
        E ele;
        Node<E> next;

        Node(E ele) {
            this.ele = ele;
        }
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        Node<E> curr = head;
        String resp = "[";

        while (curr.next != null) {
            resp += curr.ele + ", ";
            curr = curr.next;
        }
        resp += curr.ele + "]";
        return resp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // ================= ADD METHODS =================

    public boolean add(E ele) {
        addLast(ele);
        return true;
    }

    public void addLast(E ele) {
        Node<E> newNode = new Node<>(ele);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(E ele) {
        Node<E> newNode = new Node<>(ele);
        newNode.next = head;
        head = newNode;

        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E ele) {
        if (index < 0 || index > size)
            throw new UserIndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (index == 0) {
            addFirst(ele);
            return;
        }
        if (index == size) {
            addLast(ele);
            return;
        }

        Node<E> curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        Node<E> newNode = new Node<>(ele);
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    // ================= GET METHODS =================

    public E getFirst() {
        if (size == 0)
            throw new UserNoSuchElementException();
        return head.ele;
    }

    public E getLast() {
        if (size == 0)
            throw new UserNoSuchElementException();
        return tail.ele;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new UserIndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.ele;
    }

    // ================= REMOVE METHODS =================

    public E removeFirst() {
        if (size == 0)
            throw new UserNoSuchElementException();

        E data = head.ele;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }
        return data;
    }

    public E removeLast() {
        if (size == 0)
            throw new UserNoSuchElementException();

        if (size == 1) {
            E data = head.ele;
            head = tail = null;
            size--;
            return data;
        }

        Node<E> curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }

        E data = tail.ele;
        curr.next = null;
        tail = curr;
        size--;
        return data;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new UserIndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (index == 0)
            return removeFirst();

        if (index == size - 1)
            return removeLast();

        Node<E> curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        Node<E> temp = curr.next;
        curr.next = temp.next;
        temp.next = null;
        size--;
        return temp.ele;
    }

    public E remove() {
        return removeLast();
    }

    // ================= SEARCH METHODS =================

    public boolean contains(Object obj) {
        Node<E> curr = head;
        while (curr != null) {
            if (curr.ele.equals(obj))
                return true;
            curr = curr.next;
        }
        return false;
    }

    public int indexOf(Object obj) {
        Node<E> curr = head;
        int index = 0;

        while (curr != null) {
            if (curr.ele.equals(obj))
                return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    // ================= CLEAR =================

    public void clear() {
        head = tail = null;
        size = 0;
    }
}


public class UserLinkedListDriver {

    public static void main(String[] args) {

        UserLinkedlist<Integer> list = new UserLinkedlist<>();

        // ================= ADD =================
        System.out.println("Adding elements:");
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);   // [10, 20, 30]

        list.addFirst(5);
        list.addLast(40);
        System.out.println(list);   // [5, 10, 20, 30, 40]

        list.add(2, 15);
        System.out.println(list);   // [5, 10, 15, 20, 30, 40]

        // ================= GET =================
        System.out.println("\nGetting elements:");
        System.out.println("First: " + list.getFirst()); // 5
        System.out.println("Last: " + list.getLast());   // 40
        System.out.println("Index 3: " + list.get(3));   // 20

        // ================= SIZE =================
        System.out.println("\nSize: " + list.size());    // 6

        // ================= CONTAINS =================
        System.out.println("\nContains 20? " + list.contains(20)); // true
        System.out.println("Contains 99? " + list.contains(99));   // false

        // ================= INDEX OF =================
        System.out.println("\nIndex of 15: " + list.indexOf(15)); // 2
        System.out.println("Index of 99: " + list.indexOf(99));   // -1

        // ================= REMOVE =================
        System.out.println("\nRemoving elements:");
        System.out.println("Removed First: " + list.removeFirst());
        System.out.println(list);

        System.out.println("Removed Last: " + list.removeLast());
        System.out.println(list);

        System.out.println("Removed index 1: " + list.remove(1));
        System.out.println(list);

        // ================= IS EMPTY =================
        System.out.println("\nIs Empty? " + list.isEmpty());

        // ================= CLEAR ==
