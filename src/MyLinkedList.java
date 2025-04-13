public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(T item) {
        addLast(item);
    }

    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T item) {
        checkIndexForAdd(index);
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            Node curr = getNode(index);
            Node newNode = new Node(item);
            Node prev = curr.prev;

            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = curr;
            curr.prev = newNode;

            size++;
        }
    }

    public void set(int index, T item) {
        Node node = getNode(index);
        node.data = item;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public T getFirst() {
        if (head == null) throw new IndexOutOfBoundsException();
        return head.data;
    }

    public T getLast() {
        if (tail == null) throw new IndexOutOfBoundsException();
        return tail.data;
    }

    public void remove(int index) {
        checkIndex(index);
        Node toRemove = getNode(index);
        removeNode(toRemove);
    }

    public void removeFirst() {
        if (head == null) return;
        removeNode(head);
    }

    public void removeLast() {
        if (tail == null) return;
        removeNode(tail);
    }

    private void removeNode(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
    }

    public void sort() {
        if (size < 2) return;
        // Convert to array, sort, then rebuild list
        Object[] arr = toArray();
        java.util.Arrays.sort(arr);
        clear();
        for (Object o : arr) add((T) o);
    }

    public int indexOf(Object object) {
        int i = 0;
        for (Node curr = head; curr != null; curr = curr.next, i++) {
            if (curr.data.equals(object)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        int i = size - 1;
        for (Node curr = tail; curr != null; curr = curr.prev, i--) {
            if (curr.data.equals(object)) return i;
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (Node curr = head; curr != null; curr = curr.next) {
            arr[i++] = curr.data;
        }
        return arr;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node curr;
        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) curr = curr.next;
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) curr = curr.prev;
        }
        return curr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            Node current = head;
            public boolean hasNext() {
                return current != null;
            }
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
