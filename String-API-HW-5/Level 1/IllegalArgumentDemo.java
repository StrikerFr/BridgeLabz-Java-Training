public class IllegalArgumentDemo {

    public static void generate(String text) {
        System.out.println(text.substring(5, 2));
    }

    public static void handle(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Handled: " + e);
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception: " + e);
        }
    }

    public static void main(String[] args) {
        String text = "HelloWorld";

        // generate(text);
        handle(text);
    }
}
