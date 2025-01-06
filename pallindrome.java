import java.util.*;
public class pallindrome {
    public static void main (String args[]) {
        int num;
        System.out.println("enter the number : ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        int revNum = 0, temp = num;
        while(temp > 0) {
            int rem = temp % 10;
            revNum = revNum * 10 + rem;
            temp = temp / 10;
        } 
        if(num == revNum) {
            System.out.println("num is pallindrome");
        } else {
            System.out.println("num is not pallindrome");
        } sc.close();
    } 
}
