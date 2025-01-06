public class BSTrangeSum {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static int rangeSum(Node root, int low, int high) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        if(root.data < low) {
            sum = rangeSum(root.right, low, high); 
        } else if(root.data > high) {
            sum = rangeSum(root.left, low, high);
        } else {
            sum += root.data;
            sum += rangeSum(root.left, low, high);
            sum += rangeSum(root.right, low, high);
        }
        return sum;
    }
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
    public static void main(String args[]) {
        Node root = null;
        root = insert(root, 10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 3);
        insert(root, 7);
        insert(root, 18);
        
        int low = 3, high = 10;
        System.out.print(rangeSum(root, low, high));
    }
}
