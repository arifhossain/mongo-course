package com.arif.leetcode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric
 */

public class Problem101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        //root.right.right = new TreeNode(3);

        System.out.println("IsSymmetric: " + new Problem101().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null || isLeaf(root)) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if(isLeaf(left) && isLeaf(right)) {
            return left.val == right.val;
        }

        if(left.left!=null && left.right!=null && right.left!=null && right.right!=null) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        } else {
            return false;
        }
    }

    public boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
