import java.util.Scanner;
class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(), i = number-1;

        while(i >= 1) {
            if(number % i == 0) {
                System.out.println("Greatest Factor: " + i);
                break;
            }
            i--;
        }
    }
}
