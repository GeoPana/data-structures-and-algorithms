package dsatutorial.datastructures.tree;

import java.util.Stack;

public class BinarySearchTree {

    private TreeNode root;
    private class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Iterative PreOrder
    public void preOrder() {
        if (this.root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(this.root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
    }

    public void inOrder() {
        inOrder(this.root);
    }
    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void insert(int value) {
        this.root = this.insert(this.root, value);
    }
    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    public TreeNode searchKey(int key) {
        return searchKey(this.root, key);
    }
    public TreeNode searchKey(TreeNode root, int key) {
        if (root == null || key == root.data)
            return root;

        if (key < root.data)
            return searchKey(root.left, key);
        else
            return searchKey(root.right, key);
    }

    public boolean isValid() {
        return isValid(this.root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        boolean left = isValid(root.left, min, root.data);
        if (left) {
            boolean right = isValid(root.right, root.data, max);
            return right;
        }
        return false;
    }


        public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);

        bst.inOrder();

        int searchKey = 1;
        if (bst.searchKey(searchKey) != null) {
            System.out.println("\nKey " + searchKey + " found. ");
        }else {
            System.out.println("\nKey " + searchKey + " not found. ");
        }

        if (bst.isValid()) {
            System.out.println("Is Binary Search Tree. ");
        }else {
            System.out.println("Is Not Binary Search Tree. ");
        }
    }

}
