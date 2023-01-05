package dsatutorial.codinginterviwqestions;

/*
--------------- Symmetric Tree - LeetCode #101 ---------------
Given the root of a binary tree, check whether it is a mirror
of itself (i.e., symmetric around its center).
--------------------------------------------------------------
 */

import java.util.Stack;

public class SymmetricTree {
     // Definition for a binary tree node.
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {

         }
         TreeNode(int val) {
             this.val = val;
         }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public static boolean isSymmetric(TreeNode root) {
         if (root == null)
             return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null || node1.val != node2.val)
                return false;
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        TreeNode left11 = new TreeNode(3);
        TreeNode left12 = new TreeNode(4);
        TreeNode right11 = new TreeNode(4);
        TreeNode right12 = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        left1.left = left11;
        left1.right = left12;
        right1.left = right11;
        right1.right = right12;

        System.out.println(isSymmetric(root));
    }
}
