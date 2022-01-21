package com.mytool.base.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author duankd
 * @ClassName BinaryTree
 * @date 2021-11-19 22:13
 */
public class BinaryTree {
    public int data;// value
    public BinaryTree left = null;// 左子树
    public BinaryTree right = null;// 右子数

    // 数组转二叉树
    public static BinaryTree arraysToTree(int[] arrays) {
        if (arrays.length == 0) {
            return null;
        }
        int length = arrays.length;
        ArrayList<BinaryTree> temps;// 构造二叉树临时数据
        // 生成二叉树节点
        temps = new ArrayList<BinaryTree>(length);
        for (int i = 0; i < length; i++) {
            BinaryTree node = new BinaryTree();
            node.data = arrays[i];
            temps.add(node);

        }
        // 构建二叉树 根节点n[i] 左子树n[i*2+1] 右子树 n[i*2+2]
        for (int i = 0; i < length / 2 - 1; i++) {
            BinaryTree node = temps.get(i);
            node.left = temps.get(2 * i + 1);
            node.right = temps.get(2 * i + 2);

        }
        // 处理最后一个节点
        int lastNode = length / 2 - 1;
        BinaryTree node = temps.get(lastNode);
        // 添加左子树
        node.left = temps.get(lastNode * 2 + 1);

        if (length % 2 != 0) {
            // 当为偶数时，添加右子树
            node.right = temps.get(lastNode * 2 + 2);
        }

        BinaryTree root = temps.get(0);
        temps.clear();
        temps = null;
        return root;
    }

    // 前序遍历打印二叉树
    public static void prOrderTree(BinaryTree node) {
        if (node == null) {
            return;
        }
        System.out.print("\t" + node.data);
        // 左子树
        BinaryTree left = node.left;
        // 打印节点信息
        if (left != null) {
            prOrderTree(left);
        }
        // 右子树
        BinaryTree right = node.right;
        if (right != null) {
            prOrderTree(right);
        }

    }

    // 中序遍历
    public static void inOrderTree(BinaryTree node) {
        if (node == null) {
            return;
        }
        // 左子树
        BinaryTree left = node.left;
        if (left != null) {
            inOrderTree(left);
        }
        // 打印节点信息
        System.out.print("\t" + node.data);
        // 右子树
        BinaryTree right = node.right;
        if (right != null) {
            inOrderTree(right);
        }

    }

    // 后序遍历
    public static void postOrderTree(BinaryTree node) {
        if (node == null) {
            return;
        }
        // 左子树
        BinaryTree left = node.left;
        if (left != null) {
            postOrderTree(left);
        }
        // 右子树
        BinaryTree right = node.right;
        if (right != null) {
            postOrderTree(right);
        }
        // 打印节点信息
        System.out.print("\t" + node.data);

    }

    // 层序遍历
    public static void levelOrderTree(BinaryTree node) {

        if (node == null) {
            return;
        }
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();// 队列
        queue.offer(node);
        while (!queue.isEmpty()) {

            BinaryTree root = queue.poll();
            // 输出内容
            System.out.print("\t" + root.data);

            // 左子树
            BinaryTree left = root.left;
            if (left != null) {
                queue.offer(left);
            }
            // 右子树
            BinaryTree right = root.right;
            if (right != null) {
                queue.offer(right);
            }

        }
    }

    public static void printTree(BinaryTree node, int len) {
        //取层级
        int dep = (int) Math.ceil(Math.log(len + 1) / Math.log(2));
        //取位数
        int digits = getDigits(len);
        String word = getStr(digits, "*");
        StringBuilder sb = new StringBuilder();
        String[][] treeStr = new String[2 * dep - 1][2 * dep - 1];
        //取最多字符数
        int maxFloorWords = digits * ((int) Math.pow(2, dep) + 1);
        int maxFloorNodes = ((int) Math.pow(2, dep) + 1);
        List<BinaryTree> floorNodes = new ArrayList<>();
        floorNodes.add(node);
        for (int floor = 1; floor <= dep; floor++) {
            List<BinaryTree> tempNodes = new ArrayList<>();
            int tempIndex = (int) Math.pow(2, floor - 1) - 1;
            //取当前层最大节点数
            int maxCurFloorNodes = (int) Math.pow(2, floor - 1);
            int prefix = (int) Math.pow(2, dep - floor);
            int suffix = prefix;
            sb.append(getStr(prefix, word));

            int insertValue = maxCurFloorNodes > 1 ? (maxFloorNodes - prefix - suffix - maxCurFloorNodes) / (maxCurFloorNodes - 1) : 0;
            for (int i = 0; i < floorNodes.size(); i++) {
                if (i > 0) {
                    sb.append(getStr(insertValue, word));
                }
                BinaryTree tempNode = floorNodes.get(i);
                sb.append(getNumStr(tempNode.data, digits));
                if (null != tempNode.left) {
                    tempNodes.add(tempNode.left);
                }
                if (null != tempNode.right) {
                    tempNodes.add(tempNode.right);
                }
            }


            sb.append(getStr(suffix, word));
            sb.append("\n");
            floorNodes = tempNodes;
        }
        System.out.println(sb.toString());
    }

    private static String getStr(int num, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    private static String getNumStr(int num, int digits) {
        StringBuilder sb = new StringBuilder();
        int prefix = digits - getDigits(num);
        sb.append(getStr(prefix, "0"));
        sb.append(num);
        return sb.toString();
    }

    private static int getDigits(int num) {
        return (int) Math.floor(Math.log10(num)) + 1;
    }
}
