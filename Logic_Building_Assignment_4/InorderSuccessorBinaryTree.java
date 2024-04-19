class TreeNode2 {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode2(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class InorderSuccessorBinaryTree {
    static TreeNode successor = null;

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
        if (node.right != null) {
            // If the right subtree of the node is not null,
            // the inorder successor is the leftmost node in the right subtree.
            return leftMostNode(node.right);
        } else {
            // If the right subtree is null, traverse up the tree
            // until we find a node whose left child is the current node.
            TreeNode parent = findParent(root, node);
            while (parent != null && node == parent.right) {
                node = parent;
                parent = findParent(root, parent);
            }
            return parent;
        }
    }

    public static TreeNode leftMostNode(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public static TreeNode findParent(TreeNode root, TreeNode node) {
        if (root == null || root == node) {
            return null;
        }
        if (root.left == node || root.right == node) {
            return root;
        }
        TreeNode left = findParent(root.left, node);
        TreeNode right = findParent(root.right, node);
        return (left != null) ? left : right;
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

        // Find the node whose inorder successor we want to find
        TreeNode node = root.left;

        TreeNode successor = inorderSuccessor(root, node);

        if (successor != null) {
            System.out.println("Inorder successor of " + node.data + " is " + successor.data);
        } else {
            System.out.println("No inorder successor found for " + node.data);
        }
    }
}