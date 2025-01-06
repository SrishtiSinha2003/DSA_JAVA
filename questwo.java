import java.util.*;
public class questwo {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            float pencil = sc.nextFloat();
            float pen = sc.nextFloat();
            float eraser = sc.nextFloat();
            float total = pencil + pen + eraser;
            System.out.println("bill is :" + total);

            // add on with 18% gst
            float newTotal = total + (0.18f * total);
            System.out.println("bill with gst :" + newTotal);
        }

    }
}
