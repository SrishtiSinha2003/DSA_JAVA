public class BSTmaxSum {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    static class Info {
        int max;
        int min;
        boolean isBST;
        int sum;
        int currmax;

        public Info(int min, int max, boolean isBST, int sum, int currmax) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.sum = sum;
            this.currmax = currmax;
        }
        Info(){};
    }
    static class INT {
        int a;
    }
    public static Info MaxSum(Node root, INT maxsum) {
        if(root == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0, 0);
        }
        if(root.left == null && root.right == null) {
            maxsum.a = Math.max(maxsum.a, root.data);
            return new Info(root.data, root.data, true, root.data, maxsum.a);
        }

        Info leftInfo = MaxSum(root.left, maxsum);
        Info rightInfo = MaxSum(root.right, maxsum);

        Info BST = new Info();
        if(leftInfo.isBST && rightInfo.isBST && leftInfo.max < root.data && rightInfo.min > root.data) { 
            BST.max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
            BST.min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
            maxsum.a = Math.max(maxsum.a, rightInfo.sum +root.data + leftInfo.sum); 
            BST.sum = rightInfo.sum + root.data +leftInfo.sum;
            BST.currmax = maxsum.a;
            BST.isBST = true;
            return BST;
        }
        BST.isBST = false;
        BST.currmax = maxsum.a;
        BST.sum = rightInfo.sum + root.data + leftInfo.sum;
        return BST;
    }
    static int MaxSum(Node root) {
        INT maxsum = new INT();
        maxsum.a = Integer.MIN_VALUE;
        return MaxSum(root, maxsum).currmax;
    }
    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(14);
        root.right = new Node(3);
        root.left.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(9);
        root.left.left.right = new Node(1);

        System.out.println( MaxSum(root));
    }
}
