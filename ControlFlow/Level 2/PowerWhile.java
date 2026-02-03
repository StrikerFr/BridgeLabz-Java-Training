import java.util.Scanner;
class PowerWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(), power = sc.nextInt();
        int result = 1, count = 0;

        while(count < power) {
            result *= number;
            count++;
        }

        System.out.println(result);
    }
}
