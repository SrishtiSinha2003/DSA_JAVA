import java.util.*;

public class Q4_Generate_Binary_Number {

    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < N; i++) {
            String front = queue.remove();
            System.out.print(front + " ");

            String nextOne = front + "0";
            String nextTwo = front + "1";

            queue.add(nextOne);
            queue.add(nextTwo);
        }
    }

    public static void main(String[] args) {
        int N = 5; // Sample input N = 5
        generateBinaryNumbers(N);
    }
}

/*
 * Suppose N = 5:
 * 
 * Start with the queue containing "1".
 * Dequeue "1", print it, enqueue "10" and "11".
 * Dequeue "10", print it, enqueue "100" and "101".
 * Dequeue "11", print it, enqueue "110" and "111".
 * Dequeue "100", print it, enqueue "1000" and "1001".
 * Dequeue "101", print it, and enqueue "1010" and "1011".
 * The process ends after 5 iterations, and we've generated binary numbers from
 * 1 to 5.
 */