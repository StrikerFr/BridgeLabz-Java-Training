import java.util.Scanner;

class VotingCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[10];

        for(int i = 0; i < age.length; i++) {
            System.out.print("Enter age of student " + (i+1) + ": ");
            age[i] = sc.nextInt();
        }

        for(int i = 0; i < age.length; i++) {
            if(age[i] < 0) {
                System.out.println("Invalid age");
            } 
            else if(age[i] >= 18) {
                System.out.println("Student with age " + age[i] + " can vote.");
            } 
            else {
                System.out.println("Student with age " + age[i] + " cannot vote.");
            }
        }
    }
}
