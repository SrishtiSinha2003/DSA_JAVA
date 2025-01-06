public class BSTmirror {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node mirror(Node root) {
        if(root == null) {
            return null;
        }
        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static Node createBST(int arr[], int st, int end) {
        if(st > end) {
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }
    public static void main(String args[]) {
        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        //Node root = new Node(8);
        //root.left = new Node(5);
        //root.right = new Node(10);
        //root.left.left = new Node(3);
        //root.left.right = new Node(6);
        //root.right.right = new Node(11);

        //root = mirror(root);
        //preorder(root);
        Node root = createBST(arr, 0, arr.length-1);
        preorder(root);
    }
}
