public class TwoSum {
    public static void main(String[] args) {

        int[] num = {2, 7, 11, 15};
        int target = 9;
        boolean found = false;

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {

                if (num[i] + num[j] == target) {
                    System.out.println("Pair found at index: " + i + " and " + j);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No pair found");
        }
    }
}
