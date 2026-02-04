import java.util.Arrays;

public class Arrays {
    public static void main(String[] args) {

        int[] num = {40, 10, 30, 20, 50};
        int[] num2 = {40, 10, 30, 20, 50};

        System.out.println("Original Array: " + Arrays.toString(num));

        Arrays.sort(num);
        System.out.println("Sorted Array: " + Arrays.toString(num));

        int index = Arrays.binarySearch(num, 30);
        System.out.println("Element 30 found at index: " + index);

        boolean equal = Arrays.equals(num, num2);
        System.out.println("Are arrays equal? " + equal);

        int[] copy = Arrays.copyOf(num, num.length);
        System.out.println("Copied Array: " + Arrays.toString(copy));

        Arrays.fill(copy, 99);
        System.out.println("After Fill: " + Arrays.toString(copy));
    }
}
