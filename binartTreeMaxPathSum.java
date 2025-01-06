public class binartTreeMaxPathSum {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    class Res {
        public int val;
    }
    class Solution {
        Node root;
        int findMax(Node node, Res res) {
            if(node == null)
            return 0;

            int l = findMax(node.left, res);
            int r = findMax(node.right, res);

            int max_single = Math.max(Math.max(l, r) + node.data, node.data);
            int max_top = Math.max(max_single, l+r+node.data);
            res.val = Math.max(res.val, max_top);
            return max_single;
        }
        int findMaxSum() {
            return findMaxSum(root);
        }
        int findMaxSum(Node node) {
            Res res = new Res();
            res.val = Integer.MIN_VALUE;

            findMax(node, res);
            return res.val;
        }
    }
}
