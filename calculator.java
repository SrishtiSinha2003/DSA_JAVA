import java.util.*;

public class calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of a: ");
        float a = sc.nextInt();
        System.out.print("Enter value of b: ");
        float b = sc.nextInt();
        System.out.println();

        System.out.println("1 : + (Addition) a + b");
        System.out.println("2 : - (Subtraction) a - b");
        System.out.println("3 : * (Multiplication) a * b");
        System.out.println("4 : / (Division) a / b");
        System.out.println("5 : % (Modulo or remainder) a % b");
        System.out.println("\nEnter no. to apply operation: ");
        int operation = sc.nextInt();

        switch (operation) {
            case 1:
                System.out.println("a + b is " + (a + b));
                break;
            case 2:
                System.out.println("a - b is " + (a - b));
                break;
            case 3:
                System.out.println("a * b is " + (a * b));
                break;
            case 4:
                System.out.println("a / b is " + (a / b));
                break;
            case 5:
                System.out.println("a % b is " + (a % b));
                break;

            default:
                System.out.println("Invalid!");
                break;
        }
        sc.close();
    }
}