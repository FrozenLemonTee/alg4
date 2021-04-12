/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/07
 @encoding UTF-8
 **/
package DSAA.alg4.c1.nearestCp_c114;

import java.util.Arrays;

public class nearestCp {
    /**
     * 找到一个数组中相差最小的两个数并将它们返回
     * @param arr double[]: 待查找数组
     *
     * @return double[]: 相差最小的两个数
     * **/
    public static double[] find(double[] arr){
        if (arr.length == 0 || arr.length == 1){
            return new double[] {};
        }
        Arrays.sort(arr);
        double[] near = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY};
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < near[1] - near[0]){
                near[0] = arr[i - 1];
                near[1] = arr[i];
            }
        }
        return near;
    }
}
