import java.util.Arrays;

public class testlinkedlist {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        // Add elements
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("After add: " + java.util.Arrays.toString(list.toArray()));

        // Add at index
        list.add(1, "X");
        System.out.println("After insert at index 1: " + java.util.Arrays.toString(list.toArray()));

        // Get elements
        System.out.println("Get index 2: " + list.get(2));
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        // Set element
        list.set(2, "Y");
        System.out.println("After set index 2 to 'Y': " + java.util.Arrays.toString(list.toArray()));

        // Remove by index
        list.remove(1);
        System.out.println("After remove index 1: " + java.util.Arrays.toString(list.toArray()));

        // Remove first and last
        list.removeFirst();
        list.removeLast();
        System.out.println("After removeFirst and removeLast: " + java.util.Arrays.toString(list.toArray()));

        // Exists
        System.out.println("Exists 'Y': " + list.exists("Y"));
        System.out.println("Exists 'Z': " + list.exists("Z"));

        // Add duplicates and test indexOf and lastIndexOf
        list.add("D");
        list.add("E");
        list.add("D");
        System.out.println("Index of 'D': " + list.indexOf("D"));
        System.out.println("Last index of 'D': " + list.lastIndexOf("D"));

        // Sort
        list.add("D");
        list.add("E");
        list.add("D");
        System.out.println("Before sort: " + Arrays.toString(list.toArray()));

        list.sort();
        System.out.println("After sort: " + java.util.Arrays.toString(list.toArray()));

        // Clear
        list.clear();
        System.out.println("After clear: size = " + list.size());
        System.out.println("Array after clear: " + java.util.Arrays.toString(list.toArray()));

        // Iterator test
        list.add("One");
        list.add("Two");
        list.add("Three");
        System.out.print("Using iterator: ");
        for (String item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
