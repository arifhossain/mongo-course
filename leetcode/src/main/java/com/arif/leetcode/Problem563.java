package com.arif.leetcode;

/**
 * Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 * Input:
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 */

public class Problem563 {

    int totalTilt = 0;

    public int findTilt(TreeNode root) {
        getSum(root);

        return totalTilt;
    }

    private int getSum(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftSum = getSum(node.left);
        int rightSum = getSum(node.right);

        totalTilt = totalTilt + Math.abs(leftSum - rightSum);

        return node.val + leftSum + rightSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        //setup left side
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(1);

        //setup right side
        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(8);
//        root.right.right.left = new TreeNode(7);
//        root.right.right.right = new TreeNode(9);

        System.out.println("Total tilt: " + new Problem563().findTilt(root));
    }


}
