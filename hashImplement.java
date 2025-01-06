import java.util.*;
public class hashImplement {
    static class HashMap<K, V> { // generic ie k and v can be of any type string integer

        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key= key;
                this.value = value;
            }
        }

            private int n; // n
            private int N;
            private LinkedList<Node> buckets[]; // N array type is linkedlist

            @SuppressWarnings("unchecked")
            public HashMap() {
                this.N = 4;
                this.buckets = new LinkedList[4];
                for(int i=0; i<4; i++) {
                    this.buckets[i] = new LinkedList<>();
                }
            }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucks[] = buckets; // to store old bucket info
            buckets = new LinkedList[N*2]; // new bucket of size N*2
            N = 2*N;
            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList<>(); // initialize linked list at every index of bucket
            }

            // nodes - > add in new bucket
            for(int i=0; i<buckets.length; i++) {
                LinkedList<Node> ll = oldBucks[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key); // 0 to size-1
            int di = SearchInLL(key, bi); // valid if found else -1 if not found // di = data index

            if(di != -1) {
                Node node = buckets[bi].get(di); // array k under bi and uss bi k under linked list ka konsa index di
                node.value = value; // value update
            } else {
                buckets[bi].add(new Node(key, value));
                n++; // buckets m bi index pe new node add kiye 
            }
            // rehashing
            double lambda = (double)n/N;
            if(lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key); // 0 to size-1
            int di = SearchInLL(key, bi); // valid if found else -1 if not found // di = data index

            if(di != -1) { // valid
                return true;
            } else {
                return false; 
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key); // 0 to size-1
            int di = SearchInLL(key, bi); // valid if found else -1 if not found // di = data index

            if(di != -1) {
                Node node = buckets[bi].remove(di); // array k under bi and uss bi k under linked list ka konsa index di
                n--;
                return node.value; // return removed value
            } else {
                return null; 
            }
        }

        public V get(K key) {
            int bi = hashFunction(key); // 0 to size-1
            int di = SearchInLL(key, bi); // valid if found else -1 if not found // di = data index

            if(di != -1) {
                Node node = buckets[bi].get(di); // array k under bi and uss bi k under linked list ka konsa index di
                return node.value; // coz key exist
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 50);
        hm.put("Bhutan", 30);
        hm.put("Nepal", 20);
        hm.put("Srilanka", 40);

        ArrayList<String> keys = hm.keySet();
        for(String key : keys) {
            System.out.println(key);
        }

        System.out.println(hm.get("India"));
    }
}
