import java.util.Scanner;
public class LeapYear1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if (year < 1582)
            System.out.println("Invalid Year");
        else if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    System.out.println("Leap Year");
                else
                    System.out.println("Not Leap Year");
            } else
                System.out.println("Leap Year");
        } else
            System.out.println("Not Leap Year");
    }
}
