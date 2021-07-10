package com.ly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 改进方法：可以先将上一层点的size保存起来,就可以不用两个队列,在while循环里面用for循环
 * @author ly.
 * @date 2021/7/10
 */
public class Question107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queueOne = new LinkedBlockingDeque<TreeNode>();
        Queue<TreeNode> queueTwo = new LinkedBlockingDeque<TreeNode>();
        queueOne.add(root);
        List<Integer> subList;
        TreeNode node;
        List<List<Integer>> tmpList = new ArrayList<List<Integer>>();
        while(!queueOne.isEmpty() || !queueTwo.isEmpty()) {
            subList = new ArrayList<Integer>();
            while (!queueOne.isEmpty()) {
                node = queueOne.poll();
                subList.add(node.val);
                if(node.left != null) {
                    queueTwo.add(node.left);
                }
                if(node.right != null) {
                    queueTwo.add(node.right);
                }
            }
            if(!subList.isEmpty()) {
                tmpList.add(subList);
            }
            subList = new ArrayList<Integer>();
            while (!queueTwo.isEmpty()) {
                node = queueTwo.poll();
                subList.add(node.val);
                if(node.left != null) {
                    queueOne.add(node.left);
                }
                if(node.right != null) {
                    queueOne.add(node.right);
                }
            }
            if(!subList.isEmpty()) {
                tmpList.add(subList);
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = tmpList.size()-1; i>= 0; i--) {
            result.add(tmpList.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        TreeNode leftTwo = new TreeNode(15);
        TreeNode rightTwo = new TreeNode(7);
        right.left = leftTwo;
        right.right = rightTwo;
        List<List<Integer>> result = new Question107().levelOrderBottom(root);
        System.out.println(result);
    }
}
