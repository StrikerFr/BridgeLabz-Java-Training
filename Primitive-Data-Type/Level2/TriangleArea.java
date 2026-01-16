import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double baseCm = input.nextDouble();
        double heightCm = input.nextDouble();

        double areaCm = 0.5 * baseCm * heightCm;
        double areaInches = areaCm / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " +
                areaInches + " and sq cm is " + areaCm);
    }
}
