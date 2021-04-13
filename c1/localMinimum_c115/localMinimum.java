/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/11
 @encoding UTF-8
 **/
package DSAA.alg4.c1.localMinimum_c115;

public class localMinimum {
    /**
     * 在二维数组中找到局部最小值
     * @param arr int[][]: 待查找的数组
     *
     * @return int: 局部最小值的索引
     * **/
    public static int[] find(int[][] arr){
        int line_top = 0;
        int line_bottom = arr.length - 1;
        int line_mid = (line_top + line_bottom) / 2;
        while (line_top <= line_bottom){
            int row = findByLine(arr, line_mid);
            if (smallNear(arr, line_mid, row)){
                return new int[] {line_mid, row};
            }
            if (arr[line_mid][row] > arr[line_mid - 1][row]){
                line_bottom = line_mid - 1;
            }else {
                line_top = line_mid + 1;
            }
            line_mid = (line_top + line_bottom) / 2;
        }
        return new int[] {-1, -1};
    }

    /**
     * 二维数组中判断当前元素附近的元素是否比它大
     * @param arr int[][]: 待查找的数组
     * @param line int: 当前行数
     *
     * @return boolean: 是/否
     * **/
    private static boolean smallNear(int[][] arr, int line, int row){
        return (line == 0 || arr[line - 1][row] > arr[line][row])
                && (line == arr.length || arr[line + 1][row] > arr[line][row]);
    }

    /**
     * 在二维数组中先找出行中的局部最小值
     * @param arr int[][]: 待查找的数组
     * @param line int: 当前行数
     *
     * @return int: 行中的局部最小值的索引
     * **/
    private static int findByLine(int[][] arr, int line){
        return find(arr[line]);
    }

    /**
     * 在一维数组中找到局部最小值
     * @param arr int[]: 待查找的数组
     *
     * @return int: 局部最小值的索引
     * **/
    public static int find(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while (left <= right){
            if (smallNear(arr, mid)){
                return mid;
            }
            if (arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    /**
     * 一维数组中判断当前元素左右侧的元素是否比它大
     * @param arr int[]: 待查找的数组
     * @param index int: 当前元素的索引
     *
     * @return boolean: 是/否
     * **/
    private static boolean smallNear(int[] arr, int index){
        return (index == 0 || arr[index - 1] > arr[index])
                && (index == arr.length - 1 || arr[index] < arr[index + 1]);
    }

}
