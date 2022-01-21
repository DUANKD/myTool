package com.mytool.algorith;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void dijkstra() {
        int[][] weight=initMap();
        int[][] weight1=initMap();
        int[] result= Dijkstra.dijkstra(weight,0);
        int[] result1= Dijkstra.stackDijkstra(weight1,0);
        System.out.println("result:"+result);
        System.out.println("result1:"+result1);
    }

    private static int[][] initMap() {
        int[][] map=new int[6][6];
        map[0][1] = 2;
        map[0][2] = 3;
        map[0][3] = 6;
        map[1][0] = 2;
        map[1][4] = 4;
        map[1][5] = 6;
        map[2][0] = 3;
        map[2][3] = 2;
        map[3][0] = 6;
        map[3][2] = 2;
        map[3][4] = 1;
        map[3][5] = 3;
        map[4][1] = 4;
        map[4][3] = 1;
        map[5][1] = 6;
        map[5][3] = 3;
        return map;
    }
}