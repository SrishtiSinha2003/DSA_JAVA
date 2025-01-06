public class linkedListMergeSort {
    public static class Node {
        int data;
        Node next;
        //crrating node 
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // access nodes
    public static Node head;
    public static Node tail;

    // method to merge sort LL
    public static Node merge(Node l1, Node l2) {
        // base case
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
          // kaam
          if (l1.data <= l2.data) {
            Node res = l1;
            // recursive call
            l1.next = merge(l1.next, l2);
            return res;
        } else {
            Node res = l2;
            // recursive call
            l2.next = merge(l1, l2.next);
            return res;
        }
    }
    public static Node mergeKLists(Node [] lists) {
        Node res = null;

        for(int i=0; i<lists.length; i++) {
            res = merge(res, lists[i]);  // merge resultant with lists
        }
        return res;
    }
    // method to print LL
    public static void print() {
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

    public static void main(String[] args) {
        int k = 3;
        Node arr[] = new Node[k];
        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);
        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);
        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);
        head = mergeKLists(arr);
        print();
    }
}
