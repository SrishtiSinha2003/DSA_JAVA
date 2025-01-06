public class triesPrefix {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for(int i=0; i<children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int level=0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a'; // idx nikla if level pe character t h then t-a uska index dega
            if(curr.children[idx] == null) { // agr curr ka child nae hoga then
                curr.children[idx] = new Node();  // create new node
            } else {
            curr.children[idx].freq++ ; 
            }
            curr = curr.children[idx]; // curr updated
        }
        curr.eow = true;
    }

    public static void findPre(Node root, String ans) {

        if(root == null) {
            return;
        }

        if(root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for(int i=0; i<root.children.length; i++) {
            if(root.children[i] != null) {
                findPre(root.children[i], ans+(char)(i+'a')); // call for next level and add curr letter in ans
            }
        }
    }

    public static void main(String args[]) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        for(int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }

        root.freq = -1;

        findPre(root, "");
    }
}
