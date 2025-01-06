public class linkedListEvenOrOdd {
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
    // method to print LL
    public void print() {
        if (head == null) {
            System.err.println("LL is empty.");
            return;
        }
        // create temp node
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public Node oddEvenLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;

        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) { // even number
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            } else { // odd number
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            }

            current = current.next;
        }
        // Terminate both lists
        if (evenTail != null) {
            evenTail.next = null;
        }
        if (oddTail != null) {
            oddTail.next = null;
        }

        if (oddHead != null) { // If there are odd numbers
            oddTail.next = evenHead; // Link oddTail to evenHead
            return oddHead;
        } else { // If there are only even numbers
            return evenHead;
        }
    }
    public static void main(String[] args) {
        linkedListEvenOrOdd ll = new linkedListEvenOrOdd();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.oddEvenLinkedList(head);
        ll.print();
    }
}

