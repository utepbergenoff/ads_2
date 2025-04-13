public class MyMinHeap<T extends Comparable<T>> {
    private T[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyMinHeap() {
        this.heap = (T[]) new Comparable[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Constructor to build heap from MyLinkedList
    public MyMinHeap(MyLinkedList<T> list) {
        this();
        for (T item : list) {
            add(item);
        }
    }

    public void add(T item) {
        if (size == heap.length) {
            resize();
        }
        heap[size] = item;
        siftUp(size);
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T result = heap[0];
        size--;
        heap[0] = heap[size];
        heap[size] = null;
        if (size > 0) {
            siftDown(0);
        }
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Convert heap to MyLinkedList
    public MyLinkedList<T> toLinkedList() {
        MyLinkedList<T> list = new MyLinkedList<>();
        // Create a copy to avoid modifying the heap
        MyMinHeap<T> temp = new MyMinHeap<>();
        for (int i = 0; i < size; i++) {
            temp.add(heap[i]);
        }
        while (!temp.isEmpty()) {
            list.add(temp.poll());
        }
        return list;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index].compareTo(heap[parent]) >= 0) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }

    private void siftDown(int index) {
        int minIndex = index;
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size && heap[left].compareTo(heap[minIndex]) < 0) {
                minIndex = left;
            }
            if (right < size && heap[right].compareTo(heap[minIndex]) < 0) {
                minIndex = right;
            }
            if (minIndex == index) {
                break;
            }
            swap(index, minIndex);
            index = minIndex;
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newHeap = (T[]) new Comparable[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }
}