class TreeNode0 {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode0(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeSearch {
    public static TreeNode search(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }

        // Search in the left subtree
        TreeNode leftResult = search(root.left, key);
        if (leftResult != null) {
            return leftResult;
        }

        // Search in the right subtree
        return search(root.right, key);
    }

    public static void main(String[] args) {
        // Constructing a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int key = 5;
        TreeNode result = search(root, key);

        if (result != null) {
            System.out.println("Node " + key + " found in the binary tree.");
        } else {
            System.out.println("Node " + key + " not found in the binary tree.");
        }
    }
}
