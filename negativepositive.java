import java.util.*;
public class negativepositive {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x > 0) {
            System.out.println("x is positive number");
        } else {
            System.out.println("x is negative number");
        }
        sc.close();
    }
}
