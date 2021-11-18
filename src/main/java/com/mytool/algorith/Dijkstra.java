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
    static class Node {
        int x; //节点编号
        int length;//长度

        public Node(int x, int length) {
            this.x = x;
            this.length = length;
        }
    }


    public static int[] stackDijkstra(int[][] map, int start) {
        boolean bool[] = new boolean[6];//判断是否已经确定
        int len[] = new int[map.length];//长度
        for (int i = 0; i < map.length; i++) {
            len[i] = Integer.MAX_VALUE;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Node> q1 = new PriorityQueue<Node>(com);
        len[0] = 0;//从0这个点开始
        q1.add(new Node(0, 0));
        stringBuilder.append("路径：");
        int count = 0;//计算执行了几次dijkstra
        while (!q1.isEmpty()) {
            Node t1 = q1.poll();
            int index = t1.x;//节点编号
            int length = t1.length;//节点当前点距离
            bool[index] = true;//抛出的点确定
            stringBuilder.append(t1.x).append("->");
            count++;//其实执行了6次就可以确定就不需要继续执行了  这句可有可无，有了减少计算次数
            for (int i = 0; i < map[index].length; i++) {
                if (map[index][i] > 0 && !bool[i]) {
                    Node node = new Node(i, length + map[index][i]);
                    if (len[i] > node.length)//需要更新节点的时候更新节点并加入队列
                    {
                        len[i] = node.length;
                        q1.add(node);
                    }
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println(len[i]);
        }
        System.out.println(stringBuilder.toString());
        return len;
    }

    public static int[] dijkstra(int[][] weight, int start) {
        // 接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
        // 返回一个int[] 数组，表示从start到它的最短路径长度
        int n = weight.length; // 顶点个数
        int[] shortPath = new int[n]; // 保存start到其他各点的最短路径
        String[] path = new String[n]; // 保存start到其他各点最短路径的字符串表示
        for (int i = 0; i < n; i++) {
            path[i] = new String(start + "-->" + i + ":" + start);
        }
        int[] visited = new int[n]; // 标记当前该顶点的最短路径是否已经求出,1表示已求出

        // 初始化，第一个顶点已经求出
        shortPath[start] = 0;
        visited[start] = 1;

        for (int count = 1; count < n; count++) { // 要加入n-1个顶点
            int k = -1; // 选出一个距离初始顶点start最近的未标记顶点
            int dmin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && weight[start][i] < dmin && weight[start][i] > 0) {
                    //if (visited[i] == 0 && weight[start][i] < dmin ) {
                    dmin = weight[start][i];
                    k = i;
                }
            }

            // 将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            /*if(dmin>0&&k!=-1){
                shortPath[k] = dmin;
            }*/
            if (dmin > 0 && k != -1) {
                shortPath[k] = dmin;
                visited[k] = 1;
                path[k] = path[k] + "-->" + k;
                // 以k为中间点，修正从start到未访问各点的距离
                for (int i = 0; i < n; i++) {
                    //如果 '起始点到当前点距离' + '当前点到某点距离' < '起始点到某点距离', 则更新
                    if (visited[i] == 0 && shortPath[k] + weight[k][i] < weight[start][i]) {
                        weight[start][i] = shortPath[k] + weight[k][i];
                        path[i] = path[k] + "-->" + i;
                    }
                }

            }


        }
        for (int i = 0; i < n; i++) {

            System.out.println("从" + start + "出发到" + i + "的最短路径为：" + path[i] + ",长度为：" + shortPath[i]);
        }
        System.out.println("=====================================");
        return shortPath;
    }

    static Comparator<Node> com = new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.length - o2.length;
        }
    };


}
