public class queueFromLL {
    static class Node {   // to declare nodes
        int data;
        Node next;

        Node(int data) { // constructor ( initialization )
            this.data = data;
            this.next = null;
        }
    }
    static class Queue {
        static Node head = null;
        static Node tail = null;

        public boolean isEmpty() {
            return head == null && tail == null;
        }
        // add 
        public void add(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = tail = newNode; // single element
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        //remove
        public int remove() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front = head.data;  // store the data or element to be removed
            // if single element
            if(tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }
        public int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }
    }
    public static void main (String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
