public class linkedListDelete {

     // With these we can access any node
     public static Node head;
     public static Node tail;
 
     public static class Node {
         int data;
         Node next;
 
         public Node(int data) { // create single node
             this.data = data;
             this.next = null;
         }
     }
 
     // method to add Last
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
    
    public static Node linkDelete(Node head, int M, int N) {
        int counter = 1;
        Node curr = head;

        Node resHead = null;
        Node resTail = null;

        while(curr!=null) {
            if(counter <= M) {
                // retain
                if(resTail == null) {
                    resHead = resTail = curr;
                } else {
                    resTail.next = curr;
                    resTail = curr;
                }
            }
            if(counter == (M + N)) {
                counter = 1;
            } else {
                counter ++;
            } curr = curr.next;
        }
        resTail.next = null;
        return resHead;
    }
    public static void main(String args []) {
        linkedListDelete list = new linkedListDelete();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);
        list.addLast(80);
        list.addLast(90);
        list.addLast(100);

        head = linkDelete(head, 3, 2);
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
