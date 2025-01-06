
// week 9 session 2
import java.util.*;

public class Q1_Palindrome {

    public static class Node {
        int data;
        Node next;

        public Node(int data) { // create single node
            this.data = data;
            this.next = null;
        }
    }

    // With these we can access any node
    public static Node head;
    public static Node tail;

    public void addLast(int data) {
        // step 1 - create new node
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2 - newNode next = head
        tail.next = newNode; // link ... address is stored

        // step 3 - tail = newNode
        tail = newNode;
    }

    public boolean isPalindrome(Node head) {
        Stack<Node> stk = new Stack<>(); // make stack of nodes

        // make a linked list loop to store in stack
        for (Node curr = head; curr != null; curr = curr.next) {
            stk.push(curr);
        }

        // pointer of original list and stack
        Node left = head, right = stk.peek();
        while (stk.size() > 0) {
            right = stk.pop();
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Q1_Palindrome ll = new Q1_Palindrome();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);

        System.out.println(ll.isPalindrome(head));
    }
}