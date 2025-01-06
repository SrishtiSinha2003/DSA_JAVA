public class linkedListIntersection {
    public static class Node {
        int data;
        Node next;

        public Node(int data) { // create single node
            this.data = data;
            this.next = null;
        }
    }
    public int getSize(Node head) {
        int counter = 0;
        Node curr = head; // current node head hoga

        while(curr != null) {
            counter++;
            curr = curr.next; // ek ek node aage badhega
        }
        return counter;
    }
    public Node getIntersection(Node headA, Node headB) {
        int sizeA = getSize(headA); // head A ka size
        int sizeB = getSize(headB);

        while(sizeA > sizeB) {
            headA = headA.next;
            sizeA --;   // head ko tab tk badhana hai jb tk dono nodes ka size equal na ho jaye
        }
        while(sizeB > sizeA) {
            headB = headB.next;
            sizeB --;   // head ko tab tk badhana hai jb tk dono nodes ka size equal na ho jaye
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;    //jb tk dono node ka head same nae ho jata
        }
        return headA;
    }
    public static void main(String args[]) {
        linkedListIntersection list = new linkedListIntersection();
        Node headA, headB;
        headA = new Node(10);
        headB = new Node(3);
        Node newNode = new Node(6);
        headB.next = newNode;

        newNode = new Node(9);
        headB.next.next = newNode;

        newNode = new Node(15);
        headA.next = newNode;
        headB.next.next.next = newNode;

        newNode = new Node(30);
        headA.next.next = newNode;
        headA.next.next.next = null;

        Node intersectionPoint = list.getIntersection(headA, headB);
        System.out.println(intersectionPoint.data);
    }
}
