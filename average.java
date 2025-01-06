import java.util.*;

public class average {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the first number:");
        double x = sc.nextDouble();
        System.out.print("enter the second number:");
        double y = sc.nextDouble();
        System.out.print("enter the third number:");
        double z = sc.nextDouble();
        System.out.print("the average value is " + avg(x, y, z) + "\n");
        sc.close();
    } 
    public static double avg(double x, double y, double z) {
        return (x + y + z) / 3;
        
    } 

}
