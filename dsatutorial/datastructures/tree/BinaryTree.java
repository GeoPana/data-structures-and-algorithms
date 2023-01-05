package dsatutorial.datastructures.tree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

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

    public void createBinaryTree() {
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);

        this.root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
    }

    // Recursive preorder
//    public void preOrder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        System.out.print(root.data + " ");
//        preOrder(root.left);
//        preOrder(root.right);
//    }

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

    // Recursive inorder
//    public void inOrder(TreeNode root) {
//        if (root == null)
//            return;
//        inOrder(root.left);
//        System.out.print(root.data + " ");
//        inOrder(root.right);
//    }

    // Iterative InOrder
    public void inOrder() {
        if (this.root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = this.root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    // Recursive PostOrder
//    public void postOrder(TreeNode root) {
//        if (root == null)
//            return;
//        postOrder(root.left);
//        postOrder(root.right);
//        System.out.print(root.data + " ");
//    }

    // Iterative PostOrder
    public void postOrder() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = this.root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            }else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data);
                    }
                }else {
                    current = temp;
                }
            }
        }
    }

    public void levelOrder() {
        if (this.root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
    }

    public int findMax() {
        if (this.root == null)
            throw new NoSuchElementException("The tree s empty. ");
        return this.findMax(this.root);
    }
    public int findMax(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if (left > result)
            result = left;
        if (right > result)
            result = right;

        return result;
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.levelOrder();
        System.out.println("\nMax: " + bt.findMax());
    }

}
