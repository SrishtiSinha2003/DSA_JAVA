public class queueCircular {
    static class Queue {
        static int arr[];  // it will stimulate the queue
        static int size;
        static int rear;   // rear changes each time when a new element is added
        static int front;
        Queue(int n) {  //constructor of queue // int n size of array
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        public boolean isEmpty() {
            return rear == -1 && front == -1;   // no element
        }
        public static boolean isFull(){
            return (rear+1) % size == front;
        }
        //add
        public void add(int data) {
            if(isFull()) {  // queue is full
                System.out.println("queue is full");
                return;
            }
            if(front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }
        //remove
        public int remove() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int result = arr[front];
            if(rear == front){ // last elemnt is being deleted
                rear = front = -1;
            } else{
                front = (front+1)%size;
            }
            return result;
        }
        public int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main (String args[]) {
        Queue q = new Queue(3);
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
