public class queueFromArray {
    static class Queue {
        static int arr[];  // it will stimulate the queue
        static int size;
        static int rear;    // rear changes each time when a new element is added
        Queue(int n) {  //constructor of queue // int n size of array
            arr = new int[n];
            size = n;
            rear = -1;
        }
        public boolean isEmpty() {
            return rear == -1;   // no element
        }
        //add
        public void add(int data) {
            if(rear == size-1) {  // queue is full
                System.out.println("queue is full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }
        //remove
        public int remove() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front = arr[0];
            for(int i=0; i<rear; i++) { // shifting elements of the queue
                arr[i] = arr[i+1];
            }
            rear = rear - 1;
            return front;
        }
        public int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main (String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
