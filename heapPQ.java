import java.util.*;
public class heapPQ {
    static class Student implements Comparable <Student> { //interface
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }
        public static void main(String args[]) {
        //PriorityQueue <Integer> pq = new PriorityQueue<>();
        //PriorityQueue <Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // for descending order
        
        PriorityQueue <Student> pq = new PriorityQueue<>();

        pq.add(new Student("A",4));
        pq.add(new Student("B",1));
        pq.add(new Student("C", 9));
        pq.add(new Student("D",6));
        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
            //ascending order
        }
    }
}
