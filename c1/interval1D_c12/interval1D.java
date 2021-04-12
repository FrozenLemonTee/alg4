/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/03/28
 @encoding UTF-8
 **/
package DSAA.alg4.c1.interval1D_c12;

import standard.StdIn;
import standard.StdOut;

import java.util.ArrayList;
import java.util.Collections;

public class interval1D {
    /**
     * 处理输入，将输入变为区间
     * @param num int: 输入的区间数，按行计
     *
     * @return double[][]:以二维数组形式返回
     * **/
    public static double[][] inputToIntervals(int num){
        double[][] res = new double[num][2];
        for (int i = 0; i < num; i += 1){
            String s = StdIn.readLine();
            String[] tmp = s.split(" ");
            for (int j = 0; j < 2; j += 1){
                res[i][j] = Double.parseDouble(tmp[j]);
            }
        }
        return res;
    }

    /**
     * 找出所有相互重叠的区间并返回
     * @param intervals double[][]: 待处理的所有区间
     *
     * @return ArrayList/<double[]>/: 返回动态数组
     * **/
    public static ArrayList<double[]> overlapIntervals(double[][] intervals){
        ArrayList<double[]> arr = new ArrayList<>();
        Collections.addAll(arr, intervals);
        arr.sort((o1, o2) -> o1[1] != o2[1] ? (o1[1] > o2[1] ? 1: -1) : (o1[0] < o2[0] ? 1 : 0));
        ArrayList<double[]> res = new ArrayList<>();
        int flag = 0;
        for (int i = 1; i < arr.size(); i += 1){
            if (arr.get(i)[0] < arr.get(i - 1)[1]){
                if (flag == 0){
                    res.add(arr.get(i - 1));
                }
                res.add(arr.get(i));
                flag = 1;
            }else {
                flag = 0;
            }
        }
        return res;
    }

    /**
     * 打印重叠区间对
     * @param intervals ArrayList<double[]>: 待查找的区间集
     * **/
    public static void printOverlapCouple(double[][] intervals){
        ArrayList<double[]> tmp = overlapIntervals(intervals);
        for (int i = 0; i < tmp.size(); i += 1){
            for (int j = i + 1; j < tmp.size(); j += 1){
                if (tmp.get(i)[1] > tmp.get(j)[0]){
                    StdOut.printf("[%f, %f] [%f %f]\n", tmp.get(i)[0], tmp.get(i)[1], tmp.get(j)[0], tmp.get(j)[1]);
                }
            }
        }
    }

}
