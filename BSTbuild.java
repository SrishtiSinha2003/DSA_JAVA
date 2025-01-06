import java.util.*;
public class BSTbuild {
    static class  Node {
        int data;
        Node left;
        Node right;

        Node(int data) {  // constructor
            this.data = data;
        }
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
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key) { //O(H)
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data > key) {
            return search(root.left, key);
        } else {
                return search(root.right, key);
            }
    }

    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        }
        else if (root.data > val) {
            root.left = delete(root.left, val);
        }
        else {
            // case 1 - leaf node
            if(root.left == null && root.right == null) {
                return null;
            }
            // case 2 - single child
            if(root.left == null) { // agr right child hoga
                return root.right;
            } 
            else if(root.right == null) { // agr left child hoga
                return root.left;
            }
            // case 3 - both children
            Node IS = findInorderSuccessor(root.right); // inorder successor always exist in the right subtree // inorder successor = left most node in the right subtree
            root.data = IS.data; // value replace hogya
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        // base case
        if(root == null) {
            return;
        }
        if(root.data >= k1 && root.data <=k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+ " "); // data of left subtree then root and then right subtree
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1) {
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null){
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) { // leaf node case
            printPath(path);
        }
        printRoot2Leaf(root.left, path); // left subtree wala print hogya
        printRoot2Leaf(root.right, path); // right subtree right hogya
        path.remove(path.size()-1); // path.size()-1 means last element ie root node usko delete krna sbse last m jb wo path m add ho jaye
    }
    public static boolean isValidBST(Node root, Node min, Node max) {
        // base case 
        if(root == null) {
            return true;
        }
        if(min != null && root.data <= min.data) {
            return false;
        }
        else if(max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left, min, root) 
             && isValidBST(root.right, root, max); // check in left subtree and in right subtree
        // for left subtree max value is root and for right subtree min value will be root
    }
    public static void main(String args[]) {
        int values[] = {1, 1, 1};
        Node root = null;
        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();

        if(search(root, 6)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }

        //delete(root, 5);
        //System.out.println();
        //inorder(root);

        //printInRange(root, 5, 12);

        //printRoot2Leaf(root, new ArrayList<>());
        if(isValidBST(root, null, null)) {
            System.out.println("valid");
        } else {
            System.out.println(" not valid");
        }
    }
}