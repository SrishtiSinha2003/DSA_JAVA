public class triesCreate {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node(); // root of trie is always empty

    public static void insert(String word) {
        Node curr = root;
        for(int level=0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a'; // idx nikla if level pe character t h then t-a uska index dega
            if(curr.children[idx] == null) { // agr curr ka child nae hoga then
                curr.children[idx] = new Node();  // create new node
            }
            curr = curr.children[idx]; // and make new curr to created node
        }
        curr.eow = true; // last m at end of word
    }

    public static boolean search(String key) {
        Node curr = root;
        for(int level=0; level<key.length(); level++) {
            int idx = key.charAt(level) - 'a'; // idx nikla if level pe character t h then t-a uska index dega
            if(curr.children[idx] == null) { // agr curr ka child nae hoga then
                return false; 
            }
            curr = curr.children[idx];  // else see in next level
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        if(key.length() == 0) {
            return true;
        }
        for(int i=1; i<=key.length(); i++) { // substring always start from 1

            if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {

       // String words[] = {"the", "a", "there", "their", "any", "three"};
      //  for(int i=0; i<words.length; i++) {
       //     insert(words[i]);
       // }
       // System.out.println(search("there"));
      //  System.out.println(search("thor"));

        String arr[] = {"i", "like", "sam", "samsung", "moblie", "ice"};
        for(int i=0; i<arr.length; i++) {
            insert(arr[i]);
       }

    String key = "ilikesamsungbhiefi";
    System.out.println(wordBreak(key));

    }
}   
