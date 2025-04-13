
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Test add
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After add: " + java.util.Arrays.toString(list.toArray()));

        // Test add(index, item)
        list.add(1, 15);
        System.out.println("After insert at index 1: " + java.util.Arrays.toString(list.toArray()));

        // Test get
        System.out.println("Get index 2: " + list.get(2));

        // Test set
        list.set(2, 25);
        System.out.println("After set index 2 to 25: " + java.util.Arrays.toString(list.toArray()));

        // Test getFirst and getLast
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        // Test remove
        list.remove(1);
        System.out.println("After remove index 1: " + java.util.Arrays.toString(list.toArray()));

        // Test removeFirst and removeLast
        list.removeFirst();
        list.removeLast();
        System.out.println("After removeFirst and removeLast: " + java.util.Arrays.toString(list.toArray()));

        // Test exists
        System.out.println("Exists 25: " + list.exists(25));
        System.out.println("Exists 99: " + list.exists(99));

        // Test indexOf and lastIndexOf
        list.add(25);
        list.add(25);
        System.out.println("Index of 25: " + list.indexOf(25));
        System.out.println("Last index of 25: " + list.lastIndexOf(25));

        // Test sort
        list.add(5);
        list.add(100);
        list.sort();
        System.out.println("After sort: " + java.util.Arrays.toString(list.toArray()));

        // Test clear and size
        list.clear();
        System.out.println("After clear: size = " + list.size());
        System.out.println("Array after clear: " + java.util.Arrays.toString(list.toArray()));

        // Test iterator
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.print("Using iterator: ");
        for (int item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}