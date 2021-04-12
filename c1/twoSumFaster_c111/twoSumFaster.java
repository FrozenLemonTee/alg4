/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/07
 @encoding UTF-8
 **/
package DSAA.alg4.c1.twoSumFaster_c111;

import java.util.Arrays;

public class twoSumFaster {
    /**
     * 利用双指针算法在线性对数时间内计算出所有俩数之和为0的组合数量
     * @param arr int[]: 待查找的数组
     *
     * @return int: 组合数量
     * **/
    public static int count(int[] arr){
        Arrays.sort(arr); // 排序的时间复杂度是线性对数时间
        int res = 0;
        int right = arr.length - 1;
        // 查找的时间复杂度是线性时间
        for (int left = 0; left < arr.length; left += 1){
            while (left < right && arr[right] + arr[left] >= 0){
                if (arr[left] + arr[right] == 0){
                    res += 1;
                }
                right -= 1;
            }
        }
        return res;
    }
}
