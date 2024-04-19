class TreeNode1 {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode1(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class PrintHeadNodeBinaryTree {

    public static void printHeadNode(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println("Head node of subtree rooted at " + root.data + " is: " + getHeadNode(root).data);

        printHeadNode(root.left);
        printHeadNode(root.right);
    }

    public static TreeNode getHeadNode(TreeNode node) {
        while (node.left != null || node.right != null) {
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
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

        // Print head node of every node in the binary tree
        printHeadNode(root);
    }
}
