import java.util.Scanner;
class Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ageA = sc.nextInt(), ageB = sc.nextInt(), ageC = sc.nextInt();
        double hA = sc.nextDouble(), hB = sc.nextDouble(), hC = sc.nextDouble();

        int youngest = Math.min(ageA, Math.min(ageB, ageC));
        double tallest = Math.max(hA, Math.max(hB, hC));

        System.out.println("Youngest age: " + youngest);
        System.out.println("Tallest height: " + tallest);
    }
}
