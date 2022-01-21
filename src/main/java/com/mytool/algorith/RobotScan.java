package com.mytool.algorith;

public class RobotScan {
    static char Empty = '.';
    static char NotEmpty = '*';

    /**
     * 有个扫地机器人在方形房间里行走，假定房间为n*m的矩阵，左上角是(0,0), 右下角是(n,m)。初试位置是(x,y)，初始方向向上。
     * 每个坐标要么是空的（用'.'表示），要么是障碍物（用'*'表示），当遇到障碍物或房间边界时，扫地机器人会左转。给定初始位置，求扫地机器人能扫到的面积（能扫到的坐标点的数量）
     */
    int GetRobotScanCount(int st_x, int st_y, char[][] room, int n, int m) {
        int current_x = st_x;
        int current_y = st_y;
        int dire = 1;
        if (room[current_x][current_y] == NotEmpty) {
            return 0;
        }
        int x_len = 0;
        int y_len = 0;
        while (dire != 0) {
            switch (dire) {
                case 1:
                    //上
                    for (int i = 1; i < current_x + 1; i++) {
                        if (room[current_x - 1][current_y] == Empty) {

                        }
                    }
                    break;
                case 2:
                    //左
                    break;
                case 3:
                    //下
                    break;
                case 4:
                    //右
                    break;
            }
        }

        return 1;
    }
    /**
     * 有一个机场，每天需要k分钟进行维护，然后每分钟可以安排一架飞机起飞。现在有编号[1,n]共n架飞机等待起飞，则它们的起飞时间可安排在[k+1,k+n]之间。假设编号为x的飞机在[1,x]时间段内起飞不需要额外费用，之后每延迟1分钟起飞需要缴纳C(x)的费用。给定这n架飞机各自的延迟费率，求一个起飞顺序，使总延迟费用最小。
     * 例子：
     * n=5 k=2
     * C[n] = {4, 2, 1, 10, 2}
     * 原本顺序费用，第一架飞机在第三分钟起飞，第二架飞机在第四分钟起飞，第n架飞机在第(k+n)分钟起飞，那么总费用为 (3-1)·4+(4-2)·2+(5-3)·1+(6-4)·10+(7-5)·2=38
     * 最优顺序费用 (3-1)·4+(6-2)·2+(7-3)·1+(4-4)·10+(5-5)·2=20
     * 函数定义如下
     * int GetMinCost(int n, int k, ArrayList<Integer> cost);
     */
}
