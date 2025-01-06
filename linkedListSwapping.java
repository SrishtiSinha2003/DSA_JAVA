public class linkedListSwapping {
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

    // method to add last
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
            System.out.println("LL is empty.");
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
     // method to swap
     public void swapNodes(int X, int Y) {
        if (X == Y) // If both keys are same, no need to swap
        return;
        Node prevX = null, currX = head;
        while (currX != null && currX.data != X) {
            prevX = currX;
            currX = currX.next;
        }
        Node prevY = null, currY = head;
        while (currY != null && currY.data != Y) {
            prevY = currY;
            currY = currY.next;
        }
        if (currX == null || currY == null)
            return; // One or both keys not found, no swapping possible

        if (prevX != null)
            prevX.next = currY;
        else
            head = currY;

        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    public static void main(String args[]) {
        linkedListSwapping list = new linkedListSwapping();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Original list : ");
        list.print();
        list.swapNodes(3, 4);

        System.out.println("list after swapping nodes 3 and 4 : ");
        list.print();
    }
}
