import java.util.*;
public class queueStack {
    static class Stack { // class 
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }
        //add
        public void push(int data) {
            if(!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }
        // remove   tc O(n)
        public int pop() {
            if(isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;

            // case 1 Q1 is not empty
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty()) {
                        break;    // jb tk q1 empty na ho jaye tb tk q1 ka top ko remove kro or fir break kr jao
                    }
                    q2.add(top); // agr last element nae h to q2 m add kr do qunki sirf last elemnt ko return krna h baki ko q2 m dalna h
                }
            }
            // case 2 Q2 is not empty
            else {
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top; // last element
        }
        // peek
        public int peek() {
            if(isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;

            // case 1

            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            }
            // case 2
            else {
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }
    public static void main (String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
