package com.mytool.algorith;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author duankd
 * @ClassName Dijkstra
 * @date 2021-11-18 22:55
 */
public class Dijkstra {
    private static class Node {
        int nodeNum; //节点编号
        int length;//长度
        int prefix;//前置

        public Node(int x, int length, int prefix) {
            this.nodeNum = x;
            this.length = length;
            this.prefix = prefix;
        }
    }

    private static Comparator<Node> com = new Comparator<Node>() {

        @Override
        public int compare(Node n1, Node n2) {
            //避免每次取出后排序打乱插入顺序
            //return n1.length - n2.length;
            return n1.length == n2.length ? n1.nodeNum - n2.nodeNum : n1.length - n2.length;
        }
    };

    private static void getPrefix(Node[] nodes, int start, int index, StringBuilder stringBuilderTemp) {
        if (nodes[index].prefix != start) {
            getPrefix(nodes, start, nodes[index].prefix, stringBuilderTemp);
        }
        stringBuilderTemp.append("->" + index);
    }

    public static int[] stackDijkstra(int[][] weight, int start) {
        int nodeNums = weight.length;
        boolean visited[] = new boolean[nodeNums];//判断是否已经确定
        int len[] = new int[nodeNums];//长度
        for (int i = 0; i < nodeNums; i++) {
            len[i] = Integer.MAX_VALUE;
        }
        Queue<Node> queue = new PriorityQueue<Node>(com);
        len[start] = 0;//从0这个点开始
        queue.add(new Node(start, 0, start));
        int count = 0;//计算执行了几次dijkstra
        Node[] nodes = new Node[nodeNums];
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int length = temp.length;//节点当前点距离
            int index = temp.nodeNum;//节点编号
            if (visited[index]) {
                continue;
            }
            visited[index] = true;//抛出的点确定
            nodes[index] = temp;
            count++;//其实执行了6次就可以确定就不需要继续执行了  这句可有可无，有了减少计算次数
            for (int i = 0; i < nodeNums; i++) {
                if (weight[index][i] > 0 && !visited[i]) {
                    Node node = new Node(i, length + weight[index][i], i);
                    //需要更新节点的时候更新节点并加入队列
                    if (len[i] > node.length) {
                        len[i] = node.length;
                        node.prefix = index;
                        queue.add(node);
                    }
                }
            }
        }
        for (int i = 0; i < nodeNums; i++) {
            //System.out.println(len[i]);
            StringBuilder stringBuilderTemp = new StringBuilder();
            stringBuilderTemp.append(start + "->" + i + " 路径:" + start);
            getPrefix(nodes, start, i, stringBuilderTemp);
            stringBuilderTemp.append(",长度：" + len[i]);
            System.out.println(stringBuilderTemp.toString());
        }
        return len;
    }


    public static int[] dijkstra(int[][] weight, int start) {
        // 接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
        // 返回一个int[] 数组，表示从start到它的最短路径长度
        int nodeNums = weight.length; // 顶点个数
        int[] len = new int[nodeNums]; // 保存start到其他各点的最短路径
        for (int i = 0; i < nodeNums; i++) {
            len[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[nodeNums]; // 标记当前该顶点的最短路径是否已经求出,1表示已求出
        String[] path = new String[nodeNums]; // 保存start到其他各点最短路径的字符串表示
        /*for (int i = 0; i < nodeNums; i++) {
            path[i] = new String("" + start);
        }*/

        // 初始化，第一个顶点已经求出
        len[start] = 0;
        visited[start] = true;
        path[start] = start + "-->" + start;

        for (int count = 1; count < nodeNums; count++) { // 要加入n-1个顶点
            int k = -1; // 选出一个距离初始顶点start最近的未标记顶点
            int dmin = Integer.MAX_VALUE;
            for (int i = 0; i < nodeNums; i++) {
                if (!visited[i] && weight[start][i] > 0 && weight[start][i] < dmin) {
                    dmin = weight[start][i];
                    k = i;
                }
            }
            // 将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            len[k] = dmin;
            visited[k] = true;
            if (path[k] == null) {
                path[k] = start + "-->" + k;
            }

            // 以k为中间点，修正从start到未访问各点的距离
            for (int i = 0; i < nodeNums; i++) {
                //如果 '起始点到当前点距离' + '当前点到某点距离' < '起始点到某点距离', 则更新
                if (!visited[i] && weight[k][i] > 0 && dmin + weight[k][i] < len[i]) {
                    weight[start][i] = dmin + weight[k][i];
                    len[i] = dmin + weight[k][i];
                    path[i] = path[k] + "-->" + i;
                }
            }
        }
        for (int i = 0; i < nodeNums; i++) {

            System.out.println("从" + start + "出发到" + i + "的最短路径为：" + path[i] + ",长度为：" + len[i]);
        }
        System.out.println("=====================================");
        return len;
    }


}
