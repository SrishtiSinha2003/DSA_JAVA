public class BSTcloset {
    static int min_diff, min_diff_key; // two static variable // min_diff dega minimum diff // min_diff_key 
    static class Node{
        int key;
        Node left, right;
    }
    static Node newNode(int key) {
        Node node = new Node(); // Node root = new Node
        node.key = key; // node.data = data;
        node.left = node.right = null;
        return node;
    }
    public static void maxDiff(Node ptr, int k) { // max diff kisi v do node k beech ek node hoga ptr dusra node ka value hoga k
        if(ptr == null) {
            return;
        }
        if(ptr.key == k) { // root.data == k 
            min_diff_key = k;
            return;
        }
        if(min_diff > Math.abs(ptr.key - k)) {
            min_diff = Math.abs(ptr.key - k);
            min_diff_key = ptr.key;
        }
        if(k < ptr.key) {
            maxDiff(ptr.left, k);
        } else {
            maxDiff(ptr.right, k);
        }
    }
    static int maxDif(Node root, int k) {
        min_diff = 99999999;
        min_diff_key = -1;
        maxDiff(root, k);
        return min_diff_key;
    }
    public static void main (String args[]) {
        Node root = newNode(9); 
        root.left = newNode(4);
        root.right = newNode(17);
        root.left.left = newNode(3);
        root.left.right = newNode(6);
        root.left.right.left = newNode(5);
        root.left.right.right = newNode(7);
        root.right.right = newNode(22);
        root.right.right.left = newNode(20);

        int k = 18;
        System.out.println( maxDif(root, k));
    }
}
