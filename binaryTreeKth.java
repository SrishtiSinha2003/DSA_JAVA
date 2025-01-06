import java.util.*;
public class binaryTreeKth {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void Klevel(Node root, int level, int k) {
        if(root == null) {
            return;
        }
        if(level == k) {
            System.out.print(root.data + " ");
            return;
        }
        // calling left subtree and right subtree
        Klevel(root.left, level+1, k);
        Klevel(root.right, level+1, k);
    }
    public static boolean getPath(Node root, int n, ArrayList<Node> path)  { // root node, node n and arraylist
        // base case 
        if(root == null) {
            return false;
        }
        path.add(root); // adding root node
        if(root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path); // check in the left subtree
        boolean foundRight = getPath(root.right, n, path); // check in the right subtree

        if(foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size()-1);// agr left or right subtree m nae mila means jo root node h wo exist nae krta h path m to root node ko remove kr denge
        return false;
    }
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2); // calculate the path from root to n2 and store in array list path2

        //last common ancestor
        int i=0; //initialise pointer i
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)) { // same value nae h isly break
                break;
            }
        }
        // last common node -> i-1th index pe coz ith index pe to uncommon value h isly minus one
        Node lca = path1.get(i-1);
        return lca;
    }

    public static Node lca2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);

        // left subtree gives valid ans and right subtree gives null value coz n1 and n2 doesnt exist in right subtree
        if(rightlca == null) {
            return leftlca;
        }
        if(leftlca == null) {
            return rightlca;
        }
        return root; //n1 exist in left subtree and n2 exist in right subtree hence lca will be node
    }

    public static int lcaDist(Node root, int n) {
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return 0;
        }
        int leftDist = lcaDist(root.left, n); //left distance from lca 
        int rightDist = lcaDist(root.right, n); // right distance from lca

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        } else if(leftDist == -1) {
            return rightDist+1;
        } else {
            return leftDist+1;
        }
    }
    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int kthAnces(Node root, int n, int k) {
        // base case
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return 0;
        }
        int leftDist = kthAnces(root.left, n, k); // searching in left subtree
        int rightDist = kthAnces(root.right, n, k);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if(max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int transform(Node root) {
        if(root == null) {
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild; // new value and old value
        return data;
    }
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 2;
        int n1 = 4, n2 = 7;
        Klevel(root, 1, k);
        System.err.println();
        System.out.println(lca(root, n1, n2).data);
        System.out.println();
        System.out.println(lca2(root, n1, n2).data);
        System.out.println(minDist(root, n1, n2));
        kthAnces(root, n2, k);
        transform(root);
        preorder(root);
    }
}
