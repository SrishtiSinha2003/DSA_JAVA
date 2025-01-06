import java.util.*;
public class queueFromStack {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }
        //add
        public void add(int data) {
            while(!s1.isEmpty()) { // jb tk s1 khali na ho jaye tb tk s1 k elements ko s2 m push kr do and s1 ko khali kr do
                s2.push(s1.pop());
            }
            s1.push(data); // ek baar s1 khali ho jaye then push the data

            while(!s2.isEmpty()) {
                s1.push(s2.pop());   // wapas se s2 k data ko s1 m push kr do
            }
        }
        // remove
        public int remove() {
            if(isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return s1.pop();    // s1 ka jo top element h ussi ko pop krna h
        }
        // peek
        public int peek() {
            if(isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return s1.peek(); 
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
