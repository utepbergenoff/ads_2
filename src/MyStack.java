public class MyStack<T>{
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T item){
        list.addLast(item);
    }
    public boolean isEmpty(){
        return list.size()==0;
    }
    public T pop(){
        if (isEmpty()) throw new IndexOutOfBoundsException();
        T item = list.getLast();
        list.removeLast();
        return  item;
    }

    public T peek(){
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return list.getLast();
    }
    public int size(){
        return list.size();
    }
    public void clear(){
        list.clear();
    }
    public Object[] toArray(){
        return list.toArray();
    }
    public String toString(){
        return java.util.Arrays.toString(toArray());
    }
}
