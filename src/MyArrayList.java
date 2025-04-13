import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int size;
    private static final int capacity=10;


    public MyArrayList() {
        this.data = new Object[capacity];
        this.size = 0;
    }
    public void ensureCapacity() {
        if(size == data.length){
            Object[] newData = new Object[data.length*2];
            for(int i=0;i<data.length;i++){
                newData[i]=data[i];
            }
            data=newData;
        }
    }

    public void checkIndex(int index) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("out of bounds");
        }
    }

    public void checkIndexForAdd(int index){
        if(index<0 || index> size){
            throw new IndexOutOfBoundsException("out of range for add");
        }
    }


    public void add(T item) {
        ensureCapacity();
        data[size++]=item;
    }

    public void set(int index, T item) {
        checkIndex(index);
        data[index]=item;
    }

    public void add(int index, T item) {
        checkIndexForAdd(index);
        ensureCapacity();
        for(int i = size; i>index;i--){
            data[i]=data[i-1];
        }
        data[index]=item;
        size++;
    }

    public void addFirst(T item) {
        add(0, item);
    }

    public void addLast(T item) {
        add(item);
    }

    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size-1);
    }

    public void remove(int index) {
        checkIndex(index);
        for(int i=index;i<size-1;i++){
            data[i+1]=data[i];
        }
        data[--size]=null;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size-1);
    }

    public void sort() {
        for(int i =0; i<size-1;i++){
            for(int j = i+1;j<size;j++){
                Comparable<T> a = (Comparable<T>) data[i];
                T b = (T) data[j];
                if(a.compareTo(b)>0){
                    Object temp = data[i];
                    data[i]=data[j];
                    data[j]=temp;
                }
            }
        }

    }

    public int indexOf(Object object) {
        for(int i =0;i<size-1;i++){
            if(data[i].equals(object)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for(int i =size-1;i>=0;i--){
            if(data[i].equals(object)) return i;
        }
        return -1;
    }

    public boolean exists(Object object) {

        return indexOf(object) != 1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        for(int i=0;i<size;i++){
            array[i]=data[i];
        }
        return array;
    }

    public void clear() {
        for(int i=0;i<size;i++){
            data[i]=null;
        }
        size=0;
    }

    public int size() {
        return size;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int CurrentInd = 0;
            public boolean hasNext(){
                return (CurrentInd < size);
            }
            public T next(){
                return (T) data[CurrentInd++];
            }

        };
    }
}