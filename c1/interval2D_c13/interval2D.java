/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/03/28
 @encoding UTF-8
 **/
package DSAA.alg4.c1.interval2D_c13;
import DSAA.alg4.c1.point2D_c11.point2D;
import DSAA.alg4.c1.interval1D_c12.interval1D;
import standard.StdDraw;
import standard.StdOut;

import java.util.ArrayList;

public class interval2D {
    /**
     * @see DSAA.alg4.c1.interval1D_c12.interval1D#inputToIntervals(int)
     * **/
    public static double[][] inputToIntervals(int num){
        return interval1D.inputToIntervals(num);
    }

    /**
     * 获取所有区间的最左端值与最右端值
     * @param intervals double[][]: 所有区间
     *
     * @return double[]: 以数组的形式返回两个最值
     * **/
    public static double[] getLimits(double[][] intervals){
        double[] limits = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        for (double[] interval : intervals) {
            limits[0] = Math.min(limits[0], interval[0]);
            limits[1] = Math.max(limits[1], interval[1]);
        }
        return limits;
    }

    /**
     * 将所有区间于画布中绘制出来
     * @param intervals double[][]: 所有区间
     * **/
    public static void draw(double[][] intervals){
        double[] limits = getLimits(intervals);
        point2D.initDraw(limits[0], limits[1], limits[0], limits[1], 0.01);
        double distance = (limits[1] - limits[0]) / (intervals.length + 1);
        for (int i = 1; i < intervals.length + 1; i += 1){
//            StdDraw.line(intervals[i - 1][0], limits[0] + i * distance, intervals[i - 1][1], limits[0] + i * distance);
            StdDraw.line(limits[0] + i * distance, intervals[i - 1][0], limits[0] + i * distance, intervals[i - 1][1]);
        }
    }

    /**
     * @see DSAA.alg4.c1.interval1D_c12.interval1D#overlapIntervals(double[][])
     * **/
    public static ArrayList<double[]> overlapIntervals(double[][] intervals){
        return interval1D.overlapIntervals(intervals);
    }

    /**
     * 分别打印相交叉和包含的区间对
     * @param src double[][]: 已经筛选后的所有重合区间
     * **/
    public static void printOverlapCouple(double[][] src){
        ArrayList<double[]> tmp = overlapIntervals(src);
        ArrayList<int[]> overlap = new ArrayList<>();
        ArrayList<int[]> include = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i += 1){
            for (int j = i + 1; j < tmp.size(); j += 1){
                if (tmp.get(i)[0] < tmp.get(j)[0] && tmp.get(j)[0] < tmp.get(i)[1]){
                    overlap.add(new int[] {i, j});
                } else  if(tmp.get(j)[0] <= tmp.get(i)[0]){
                    include.add(new int[] {i, j});
                }
            }
        }
        StdOut.println("overlap:");
        for (int[] o: overlap){
            StdOut.printf("[%f, %f] [%f, %f]\n", tmp.get(o[0])[0], tmp.get(o[0])[1], tmp.get(o[1])[0], tmp.get(o[1])[1]);
        }
        StdOut.println("include:");
        for (int[] o: include){
            StdOut.printf("[%f, %f] [%f, %f]\n", tmp.get(o[0])[0], tmp.get(o[0])[1], tmp.get(o[1])[0], tmp.get(o[1])[1]);
        }
    }
}
