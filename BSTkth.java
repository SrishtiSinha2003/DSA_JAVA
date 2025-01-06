public class BSTkth {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    static int count = 0;

    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        }
        if(root.data < val) {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static Node KthSmallest(Node root, int k) {
        if(root == null) {
            return null;
        }
        Node left = KthSmallest(root.left, k);
        if(left != null) {
            return left;
        } count ++;
        if(count == k) {
            return root;
        }
        return KthSmallest(root.right, k);
    }
    public static void printKthSmallest(Node root, int k) {
        Node res = KthSmallest(root, k);
        if(res == null) {
            System.out.println("there are less than k nodes");
        } else {
            System.out.println("kth smallest : " + res.data);
        }
    }
    public static void main(String args[]) {
        Node root = null;
        int keys[] = {20, 8, 22, 4, 12, 10, 14};
        for(int i : keys) {
            root = insert(root, i);
        }
        int k = 3;
        printKthSmallest(root, k);
    }
}
