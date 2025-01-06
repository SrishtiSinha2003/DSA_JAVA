import java.util.*;
public class isEven {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("enter an integer:");
        num = sc.nextInt();
        if(isEvn(num)) {
            System.out.println("number is even");

        } else {
            System.out.println("number is odd");
        } sc.close();
    }
    public static boolean isEvn(int number) {
        if(number % 2 == 0) {
            return true;
        } else {
            return false;
        }
        
    }
}
