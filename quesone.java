import java.util.*;
public class quesone {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int side = sc.nextInt ();
            int area = side * side;
            System.out.println("area of the square is : " + area);
        }

    }
}
