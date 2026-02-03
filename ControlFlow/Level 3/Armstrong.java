import java.util.Scanner;
public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0, temp = num;

        while (temp != 0) {
            int d = temp % 10;
            sum += d*d*d;
            temp /= 10;
        }

        if (sum == num) System.out.println("Armstrong");
        else System.out.println("Not Armstrong");
    }
}
