public class binaryTreeUni {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean isUnival(Node root) {
        if(root == null) {
            return true;
        }
        if (root.left != null && root.data != root.left.data) {
            return false;
        }
        if(root.right != null && root.data != root.right.data) {
            return false;
        }
        return isUnival(root.left) && isUnival(root.right);
    }
    static class BinaryTree {
        static int idx = -1;
        //function
        public Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode  = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
        public void inorder(Node root) {
            if(root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    public static Node mirror (Node node) {
        if(node == null) { // base case
            return node;
        }

        Node newNode = new Node(node.data);
        Node left = mirror(node.left); // mirror of left subtree
        Node right = mirror(node.right); // mirror of right subtree

        // swap the left and right subtrees
        newNode.left = right;
        newNode.right = left;

        return newNode;
    }

    static Node deleteLeaves(Node root, int x) {
        if(root == null) {
            return null;
        }
        // delete leaf node in left subtree
        root.left = deleteLeaves(root.left, x);

        // delete leaf node in right subtree
        root.right = deleteLeaves(root.right, x);

        // if leaf node and val is same, remove that node
        if(root.data == x && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
    public static void main(String args []) {
        int nodes[] = {1, 2, 4, -1, -1, 3, -1, -1, 3, -1, 3, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        //tree.inorder(root);
        //Node mirror = mirror(root);
        //System.out.println("");
        //tree.inorder(mirror);

        //Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(3);
        root.right.left = new Node(7);
        root.right.right = new Node(3);

        deleteLeaves(root, 3);
        System.out.print("inorder traversal : ");
        tree.inorder(root);
        //System.out.println(isUnival(root));
        
    }
}

