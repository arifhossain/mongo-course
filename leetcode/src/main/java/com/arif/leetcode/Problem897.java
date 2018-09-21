package com.arif.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem897 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        //setup left side
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        //setup right side
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        Problem897 solution = new Problem897();
        TreeNode newRoot = solution.increasingBST(root);

        System.out.println(newRoot.val + " : " + newRoot.right);
    }


    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> intList = new ArrayList<>();
        inorder(root, intList);

        TreeNode newRoot = new TreeNode(intList.get(0));
        TreeNode prev = newRoot;
        for (int i = 1; i < intList.size(); i++) {
            prev.right = new TreeNode(intList.get(i));
            prev = prev.right;
        }

        return newRoot;
    }

    public void inorder(TreeNode root, List<Integer> intList) {
        if(root.left != null) {
            inorder(root.left, intList);
        }
        intList.add(root.val);

        if(root.right != null) {
            inorder(root.right, intList);
        }
    }
}
