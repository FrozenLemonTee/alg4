/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/06
 @encoding UTF-8
 **/
package DSAA.alg4.c1.fourSum_c110;

import java.util.Arrays;

public class fourSum {
    /**
     * 计算一个数组中有多少4个数的组合，其和为0
     * @param arr int[]: 待判断的数组
     *
     * @return int: 组合的数量
     * **/
    public static int count(int[] arr){
        int res = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int index = binarySearch(arr, -(arr[i] + arr[j] + arr[k]), k + 1, arr.length - 1);
                    if (index > -1){
                        res += 1;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 在数组的一部分连续区间内进行二分查找，以查找目标数（默认数组已升序排列）
     * @throws IndexOutOfBoundsException: 检查左右边界是否越界，如果越界则抛出
     *
     * @param arr int[]: 待检索的数组
     * @param target int: 待查找的数
     * @param left int: 左边界
     * @param right int: 右边界
     *
     * @return int: 返回查找到的元素的索引值，若为-1则表明找不到
     * **/
    private static int binarySearch(int[] arr, int target, int left, int right){
        // 检查左右边界是否越界
        if (left < 0 || right >= arr.length){
            StringBuilder sb = new StringBuilder();
            if (left < 0){
                sb.append("left: ").append(left);
            }
            if (right >= arr.length){
                sb.append(" right: ").append(right);
            }
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int cur_l = left;
        int cur_r = right;
        int mid = (cur_l + cur_r) / 2;
        while (cur_l <= cur_r){
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] < target){
                cur_l = mid + 1;
            }else {
                cur_r = mid - 1;
            }
            mid = (cur_l + cur_r) / 2;
        }
        return -1;
    }


}
