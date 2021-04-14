/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/13
 @encoding UTF-8
 **/
package DSAA.alg4.c2.transaction_c21;

import java.util.ArrayList;

public class arraySort {
    /**
     * 选择排序
     * @param arr ArrayList<Item>: 待排序数组
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     * **/
    public static <Item extends Comparable<? super Item>> void selectSort(ArrayList<Item> arr, int key){
        key = key >= 0 ? 1: -1;
        /*        max
        *          ↓
        * |-3  -5  0  -4 | 1  2  3  4  4  5  6  7  9 |
        * |______________|___________________________|
        *      无序区                 有序区
        *               ↓
        * |-3  -5  -4 | 0  1  2  3  4  4  5  6  7  9 |
        * |___________|______________________________|
        *     无序区                有序区
        *  max
        *   ↓
        * |-3  -5  -4 | 0  1  2  3  4  4  5  6  7  9 |
        * |___________|______________________________|
        *     无序区                有序区
        *
        *            ↓
        * |-5  -4 | -3  0  1  2  3  4  4  5  6  7  9 |
        * |_______|__________________________________|
        *  无序区                有序区
        * */
        for (int i = arr.size(); i > 0; i--) { // 每次从当前无序区选择最大/最小的对象放至有序区最左侧
            int limit = 0;
            for (int j = 1; j < i; j++) {
                if (arr.get(limit).compareTo(arr.get(j)) != key){
                    limit = j;
                }
            }
            Item tmp = arr.get(i - 1);
            arr.set(i - 1, arr.get(limit));
            arr.set(limit, tmp);
        }
    }

    /**
     * 插入排序
     * @param arr ArrayList<Item>: 待排序数组
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     * **/
    public static <Item extends Comparable<? super Item>> void insertSort(ArrayList<Item> arr, int key){
        key = key >= 0 ? 1: -1;
        for (int i = 1; i < arr.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (arr.get(j).compareTo(arr.get(j - 1)) != key){
                    Item tmp = arr.get(j);
                    arr.set(j, arr.get(j - 1));
                    arr.set(j - 1, tmp);
                }else {
                    break;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * @param arr ArrayList<Item>: 待排序数组
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     * **/
    public static <Item extends Comparable<? super Item>> void bubbleSort(ArrayList<Item> arr, int key){
        key = key >= 0 ? 1: -1;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (arr.get(j).compareTo(arr.get(j + 1)) == key){
                    Item tmp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, tmp);
                }
            }
        }
    }

    /**
     * 二分插入排序
     * @param arr ArrayList<Item>: 待排序数组
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     * **/
    public static <Item extends Comparable<? super Item>> void binarySort(ArrayList<Item> arr, int key){
        for (int i = 1; i < arr.size(); i++) {
            int index = binaryIndex(arr, i, key);
            Item tmp = arr.remove(i);
            arr.add(index, tmp);
        }
    }

    /**
     * 利用二分查找找到有序区内可插入的位置
     * @param arr ArrayList<Item>: 待排序数组
     * @param right int: 有序区右边界
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     *
     * @return int: 插入位置的索引
     * **/
    private static <Item extends Comparable<? super Item>> int binaryIndex(ArrayList<Item> arr, int right, int key){
        int left = 0;
        int r_bound = right;
        right -= 1;
        int mid = (left + right) / 2;
        while (left <= right){
            int compare_sides = compareSides(arr, r_bound, mid, key);
            if (compare_sides == -1){
                right = mid - 1;
            }else if (compare_sides == 1){
                left = mid + 1;
            }else {
                return mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }

    /**
     * 判断当前位置是否可插入
     * 若返回-1，索引需要往左移；若返回1，索引需要往右移；返回0，OK
     * @param arr ArrayList<Item>: 待排序数组
     * @param r_bound int: 有序区右边界
     * @param mid int: 待判断位置
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     *
     * @return int: 返回情况
     * **/
    private static <Item extends Comparable<? super Item>> int compareSides(ArrayList<Item> arr, int r_bound, int mid, int key){
        Item item = arr.get(r_bound);
        // 以增序为例：
        // 若待判断位置左侧无元素或者左侧元素比待插入元素小，左侧OK
        boolean left = mid == 0 || arr.get(mid - 1).compareTo(item) != key;
        // 若待判断位置右侧无元素或者右侧元素比待插入元素大，右侧OK
        boolean right = mid == r_bound - 1 || item.compareTo(arr.get(mid)) != key;
        // 左侧不OK而右侧OK，判断位置往左移
        if (!left && right){
            return -1;
        // 右侧不OK而左侧OK，判断位置往右移
        }else if (left && !right){
            return 1;
        }
        return 0;
    }
}
