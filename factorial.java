import java.util.*;
public class factorial {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num; // to hold number
        int fact = 1; // to hold factorial
        System.out.print("enter any positive integer: ");
        num = sc.nextInt();
        for(int i=1; i<=num; i++) {
            fact *= i;
        }
        System.out.println("Factorial: "+ fact);
        sc.close();
    }
}
