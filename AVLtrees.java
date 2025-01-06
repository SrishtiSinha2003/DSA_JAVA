public class AVLtrees {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }
    public static Node root;

    public static int height (Node root) {
        if(root == null)
        return 0;
        return root.height;
    }

    // left rotate subtree with y
    public static Node leftRotate (Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // rotation
        x.right = y;
        y.left = T2;

        // update height
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) +1;

        return x;
    }

    public static Node rightRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) +1;
        y.height = Math.max(height(y.left), height(y.right)) +1;

        return y;
    }
    // get balance factor
    public static int getBalance(Node root) {
        if(root == null)
        return 0;
        return height(root.left) - height(root.right);
    }
    // insertion
    public static Node insert(Node root, int key) {
        if(root == null)
        return new Node(key);

        if(key<root.data)
        root.left=insert(root.left,key);

        else if(key>root.data)
        root.right=insert(root.right,key);

        else return root; // Duplicate keys not allowed

        // Update root height

        root.height=1+Math.max(height(root.left),height(root.right));

        // Get root's balance factor

        int bf=getBalance(root); 

        // Left Left Case

        if(bf > 1 && key < root.left.data)
        return rightRotate(root); 
          
        // Right Right Case

        if(bf < -1 && key > root.right.data)
        return leftRotate(root); 

        // Left Right Case 

        if(bf > 1 && key > root.left.data) { 
            root.left=leftRotate(root.left);
            return rightRotate(root);}

            // Right Left Case 

            if(bf < -1 && key < root.right.data) { 
                root.right=rightRotate(root.right);
                return leftRotate(root);
            }
            return root; // return avl tree
    }
    public static void preorder(Node root) { 
        if(root==null) { 
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]) { 
        root=insert(root,10);
        root=insert(root,20);
        root=insert(root,30);
        root=insert(root,40);
        root=insert(root,50);
        root=insert(root,25);
        preorder(root);
    }
}
