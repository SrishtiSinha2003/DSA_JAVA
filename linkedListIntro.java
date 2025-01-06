public class linkedListIntro {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        //step 1 = create new node
        Node newNode = new Node(data);
        size++;
        if(head == null ) {
            head = tail = newNode;
            return;
        }
        // step 2 -newNode next = head
        newNode.next = head;

        // step 3 - head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // prev : i = size-2
        Node prev = head;
        for(int i=0; i<size-2; i++) {
            prev = prev.next;
        }

        int val = tail.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key) {
        Node temp = head;
        int i=0;
 
        while (temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        } 
        // key not found
        return -1;
    }

    public int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {    // O(n)
        Node prev = null;
        Node curr = tail = head;   // right to left first curr value will be head then tail
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd (int n) {
        //calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            sz++;
        }
        if(n == sz) {
            head = head.next;
            return;
        }

        // sz-n
        int i =1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node findMid(Node head) {  // helper
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; //+2
        }
        return slow; // slow is my midNode
    }

    public boolean checkPalindrome() {
        if(head == null || head.next == null) {   // empty linked list or linked list has one element
            return true;
        }
        // step1 - find mid
        Node midNode = findMid(head);
        // step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half ka head
        Node left = head;
        // step3 - check left half and second half
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                cycle = true;
                break;
            }
        }

        if(cycle == false) {
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null; // last node
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle  ->  last.next = null
        prev.next = null;
    }

    public void ZigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alternate merge 
        while ( left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
    public static void main(String args[]) {
       linkedListIntro ll = new linkedListIntro();
       // ll.head = new Node(1);
       // ll.head.next = new Node(2);
     //  ll.print();
      // ll.addFirst(2);
     //  ll.print();
     //  ll.addFirst(1);
     //  ll.print();
      //  ll.addLast(3);
     //   ll.print();
     //   ll.addLast(4);
       // ll.add(2, 9);
    //    ll.print();
      //  System.out.println(linkedListIntro.size);
      //  ll.removeFirst();
        //ll.print();
      //  ll.removeLast();
      //  ll.print();
      //  System.out.println(linkedListIntro.size);
     //   System.out.println(ll.recSearch(3));
     //   System.out.println(ll.itrSearch(10));
       // ll.reverse();
      //  ll.print();
      //  ll.deleteNthFromEnd(3);
      //  ll.print();

      //  ll.addLast(1);
        //ll.addLast(2);
      //  ll.addLast(2);
      //  ll.addLast(1);

       // ll.print();
      //  System.out.println(ll.checkPalindrome());

     // head = new Node(1);
     // Node temp = new Node(2);
    //  head.next = temp;
     // head.next.next = new Node(3);
     // head.next.next.next = temp;
     // System.out.println(isCycle());
     // removeCycle();;
      //System.out.println(isCycle());

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.print();
        ll.ZigZag();
        ll.print();
    }
}
