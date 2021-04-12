/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/07
 @encoding UTF-8
 **/
package DSAA.alg4.c1.threeSumFaster_c112;

import java.util.Arrays;

public class threeSumFaster {
    /**
     * 利用双指针+线性筛算法在平方时间内计算出所有三数之和为0的组合数量
     * @param arr int[]: 待查找的数组
     *
     * @return int: 组合数量
     * **/
    public static int count(int[] arr){
        Arrays.sort(arr);
        int res = 0;
        // 外层是对一个数的线性查找
        for (int i = 0; i < arr.length; i++) {
            int right = arr.length - 1;
            // 内两层查找算法同 twoSumFaster.count()，时间复杂度为线性
            for (int j = i + 1; j < arr.length; j++) {
                while (j < right && arr[i] + arr[j] + arr[right] >= 0){
                    if (arr[i] + arr[j] + arr[right] == 0){
                        res += 1;
                    }
                    right -= 1;
                }
            }
        }
        return res;
    }
}
