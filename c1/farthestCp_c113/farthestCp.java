/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/07
 @encoding UTF-8
 **/
package DSAA.alg4.c1.farthestCp_c113;

public class farthestCp {
    /**
     * 找到一个数组中相差最大的两个数并将它们返回
     * @param arr double[]: 待查找数组
     *
     * @return double[]: 相差最大的两个数
     * **/
    public static double[] find(double[] arr){
        if (arr.length == 0 || arr.length == 1){
            return new double[] {};
        }
        double[] limits = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        for (double num: arr) {
            limits[0] = Double.min(limits[0], num);
            limits[1] = Double.max(limits[1], num);
        }
        return limits;
    }
}
