import java.util.*;
public class greedyMinAbDiff {
    public static void main (String args[]) {
        int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};

        //sort arrays
        Arrays.sort(A);
        Arrays.sort(B);

        //variable to store min diff

        int minDiff = 0;

        for(int i=0; i<A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println("min difference : " + minDiff);
    }
}
