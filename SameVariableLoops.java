public class SameVariableLoops {
    public static void main(String[] args) {

        int i;   
        int j;   

        System.out.println("For Loop:");
        for (i = 1; i <= 3; i++) {
            System.out.println("i = " + i);
        }

        i = 1;
        System.out.println("\nWhile Loop:");
        while (i <= 3) {
            System.out.println("i = " + i);
            i++;
        }

        i = 1;

        System.out.println("\nDo-While Loop:");
        do {
            System.out.println("i = " + i);
            i++;
        } while (i <= 3);

        System.out.println("\nStar Pattern:");
        for (i = 1; i <= 4; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }
}
