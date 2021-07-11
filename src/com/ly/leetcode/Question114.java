package com.ly.leetcode;

/**
 * 前序遍历
 * @author ly.
 * @date 2021/7/11
 */
public class Question114 {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode node = new TreeNode();
        flatten(root,node);
        root.left = null;
        root.right = node.right.right;
    }

    private TreeNode flatten(TreeNode root,TreeNode resultNode) {
        TreeNode node = new TreeNode(root.val);
         resultNode.right = node;
        if(root.left == null && root.right == null) {
            return node;
        }
        TreeNode leftNode = null;
        if(root.left != null) {
            leftNode = flatten(root.left,resultNode.right);
        } else {
            leftNode = node;
        }
        TreeNode rightNode = null;
        if(root.right != null) {
            rightNode = flatten(root.right,leftNode);
        }
        if(rightNode != null) {
            return rightNode;
        }
        return leftNode;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        node.left = node2;
        node.right = node3;
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(6);
        node3.right = node6;
        new Question114().flatten(node);
        System.out.println(node);
    }
}
