/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/03/28
 @encoding UTF-8
**/
package DSAA.alg4.c1.point2D_c11;
import standard.StdDraw;
import standard.StdOut;

import java.util.HashSet;


public class point2D {
    /**
     * 初始化点坐标
     * @param num int: 生成点的个数
     *
     * @return double[][]: 返回的二维数组，每行代表一个点的横纵坐标
     * */
    public static double[][] initPoints(int num){
        HashSet<Double> s = new HashSet<>();
        double[][] p = new double[num][2];
        for (int i = 0; i < num; i += 1){
            for (int j = 0; j < 2; j += 1){
                double r = Math.random();
                if (!s.contains(r)){
                    s.add(r);
                    p[i][j] = r;
                }
            }
        }
        return p;
    }

    /**
     * 初始化画布
     * @param sizeX1 double: 横坐标左区间
     * @param sizeX2 double: 横坐标右区间
     * @param sizeY1 double: 纵坐标左区间
     * @param sizeY2 double: 纵坐标右区间
     * @param penRadius double: 画笔粗细大小
     * */
    public static void initDraw(double sizeX1, double sizeX2, double sizeY1, double sizeY2, double penRadius){
        StdDraw.setXscale(sizeX1, sizeX2);
        StdDraw.setYscale(sizeY1, sizeY2);
        StdDraw.setPenRadius(penRadius);
    }

    /**
     * 绘制点
     * @param points double[][]: 所有待画的点
     * */
    public static void drawPoints(double[][] points){
        for (double[] point : points) {
            StdDraw.point(point[0], point[1]);
        }
    }

    /**
    * 找到所有点中的最小距离
    * @param points double[][]: 所有画布上的点
    * */
    public static void minDistance(double[][] points){
        double distance = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.length; i += 1){
            double cur1 = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            for (int j = i + 1; j < points.length; j += 1){
                double cur2 = Math.pow(points[j][0], 2) + Math.pow(points[j][1], 2);
                double cur = Math.sqrt(cur1 + cur2);
                distance = Math.min(distance, cur);
            }
        }
        StdOut.println("the smallest distance: " + distance);
    }
}
