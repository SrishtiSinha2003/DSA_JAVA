import java.util.*;
public class stackNextGreater {
    public static void main(String args[]) {
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--) {
            // 1st step
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {  // jab tk stack empty nae h ya jb tk small elemnts h stack m pop
                s.pop();
            }
            // 2nd step
            if(s.isEmpty()) {
                nextGreater[i] = -1;   // stack empty h to NG = -1
            } else {
                nextGreater[i] = arr[s.peek()];   // stack empty nae h to jo stack ka elemnt hoga
            }
            // 3rd step
            s.push(i);  // we are pushing the index of the element
        }
        for(int i=0; i<nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();
    }
}
