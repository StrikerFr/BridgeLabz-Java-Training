import java.util.Scanner;

public class Handshakes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int handshakes = (n * (n - 1)) / 2;

        System.out.println("Maximum number of handshakes is " + handshakes);
    }
}
