import java.util.*;

public class sol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers:");

        int number;
        do {
            number = scanner.nextInt();

            if (number % 10 != 0) {
                System.out.println("number: " + number);
            } else {
                System.out.println("multiple of 10 excluded : " + number);
            }

        } while (number != 0);

        scanner.close();
    }
}
