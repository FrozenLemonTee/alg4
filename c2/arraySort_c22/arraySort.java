/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/13
 @encoding UTF-8
 **/
package DSAA.alg4.c2.arraySort_c22;

import java.util.ArrayList;

public class arraySort {
    /**
     * 判断元素1与元素2相比，其排序相对值是否符合当前排序选项要求
     * @param i1 Item: 待判断元素1
     * @param i2 Item: 待判断元素2
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     *
     * @return boolean: 是/否
     * **/
    public static <Item extends Comparable<? super Item>> boolean isMatchRule(Item i1, Item i2, int key){
        // 重整排序选项值，若为非负数（增序要求）则重整为1，否则（降序要求）重整为-1
        key = key >= 0 ? 1: -1;
        // 重整排序相对值，若为非负数（降序或相同）则重整为1，否则（增序）重整为-1
        int compare = i1.compareTo(i2) > 0 ? 1: -1;
        return compare != key;
    }

    public static <Item extends Comparable<? super Item>> boolean isMatchRule(Item i1, Item i2, boolean include, int key){
        // 重整排序选项值，若为非负数（增序要求）则重整为1，否则（降序要求）重整为-1
        key = key >= 0 ? 1: -1;
        // 重整排序相对值，若为非负数（降序或相同）则重整为1，否则（增序）重整为-1
        int compare = i1.compareTo(i2) > 0 ? 1: -1;
        if (include){
            return compare != key || i1.equals(i2);
        }
        return compare != key;
    }

    /**
     * 交换数组内两个元素的位置
     * @param arr ArrayList<Item>: 待交换的数组
     * @param index1 int: 待交换的元素1的索引
     * @param index2 int: 待交换的元素2的索引
     * **/
    public static <Item> void exchange(ArrayList<Item> arr, int index1, int index2){
        Item tmp = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, tmp);
    }

    /**
     * 选择排序方法入口1
     * **/
    public static <Item extends Comparable<? super Item>> void selectSort(ArrayList<Item> arr, int key){
        select(arr, key);
    }

    /**
     * 选择排序方法入口2
     * **/
    public static <Item extends Comparable<? super Item>> void selectSort(ArrayList<Item> arr){
        select(arr, 1);
    }

    /**
     * 选择排序主方法
     * @param arr ArrayList<Item>: 待排序数组
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     * **/
    private static <Item extends Comparable<? super Item>> void select(ArrayList<Item> arr, int key){
        /*        max
        *          ↓
        * |-3  -5  0  -4 | 1  2  3  4  4  5  6  7  9 |
        * |______________|___________________________|
        *      无序区                有序区
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
                if (isMatchRule(arr.get(limit), arr.get(j), key)){
                    limit = j;
                }
            }
            exchange(arr, limit, i - 1);
        }
    }

    /**
     * 插入排序方法入口1
     * **/
    public static <Item extends Comparable<? super Item>> void insertSort(ArrayList<Item> arr, int key){
        insert(arr, key);
    }

    /**
     * 插入排序方法入口2
     * **/
    public static <Item extends Comparable<? super Item>> void insertSort(ArrayList<Item> arr){
        insert(arr, 1);
    }

    /**
     * 插入排序主方法
     * @param arr ArrayList<Item>: 待排序数组
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     * **/
    private static <Item extends Comparable<? super Item>> void insert(ArrayList<Item> arr, int key){
        for (int i = 1; i < arr.size(); i++) {
            gapInsert(arr, 1, i, key);
        }
    }

    /**
     * 冒泡排序方法入口1
     * **/
    public static <Item extends Comparable<? super Item>> void bubbleSort(ArrayList<Item> arr, int key){
        bubble(arr, key);
    }

    /**
     * 冒泡排序方法入口2
     * **/
    public static <Item extends Comparable<? super Item>> void bubbleSort(ArrayList<Item> arr){
        bubble(arr, 1);
    }

    /**
     * 冒泡排序主方法
     * @param arr ArrayList<Item>: 待排序数组
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     * **/
    private static <Item extends Comparable<? super Item>> void bubble(ArrayList<Item> arr, int key){
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (!isMatchRule(arr.get(j), arr.get(j + 1), key)){
                    exchange(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 二分插入排序方法入口1
     * **/
    public static <Item extends Comparable<? super Item>> void binarySort(ArrayList<Item> arr, int key){
        _binarySort(arr, key);
    }

    /**
     * 二分插入排序方法入口2
     * **/
    public static <Item extends Comparable<? super Item>> void binarySort(ArrayList<Item> arr){
        _binarySort(arr, 1);
    }

    /**
     * 二分插入排序主方法
     * @param arr ArrayList<Item>: 待排序数组
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     * **/
    private static <Item extends Comparable<? super Item>> void _binarySort(ArrayList<Item> arr, int key){
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
        // 若待判断位置右侧无元素或者右侧元素比待插入元素大，右侧OK
        boolean left;
        boolean right;
        left = mid == 0 || isMatchRule(arr.get(mid - 1), item, key);
        right = mid == r_bound || isMatchRule(item, arr.get(mid), key);
        // 左侧不OK而右侧OK，判断位置往左移
        if (!left && right){
            return -1;
        // 右侧不OK而左侧OK，判断位置往右移
        }else if (left && !right){
            return 1;
        }
        return 0;
    }

    /**
     * 归并排序方法入口1
     * @param arr ArrayList<Item>: 待排序数组
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     *
     * @return ArrayList<Item>: 排好序后的数组片段
     * **/
    public static <Item extends Comparable<? super Item>> ArrayList<Item> mergeSort(ArrayList<Item> arr, int key){
        return recursionMerge(arr, key);
    }

    /**
     * 归并排序方法入口2
     * @param arr ArrayList<Item>: 待排序数组
     *
     * @return ArrayList<Item>: 排好序后的数组片段
     * **/
    public static <Item extends Comparable<? super Item>> ArrayList<Item> mergeSort(ArrayList<Item> arr){
        return recursionMerge(arr, 1);
    }

    /**
     * 归并排序主递归方法，需要额外空间
     * @param cut ArrayList<Item>: 当前需要被平分的数组片段
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     *
     * @return ArrayList<Item>: 排好序后的数组片段
     * **/
    private static <Item extends Comparable<? super Item>> ArrayList<Item> recursionMerge(ArrayList<Item> cut, int key){
        // 递归结束判断
        if (cut.size() <= 1){
            return cut;
        }
        int mid = cut.size() / 2;
        // 递归片段左半边
        ArrayList<Item> cut1 = recursionMerge(new ArrayList<>(cut.subList(0, mid)), key);
        // 递归片段右半边
        ArrayList<Item> cut2 = recursionMerge(new ArrayList<>(cut.subList(mid, cut.size())), key);
        ArrayList<Item> cut3 = new ArrayList<>();
        // 对两个有序的片段进行选择排序
        while (cut1.size() != 0 && cut2.size() != 0){
            if (isMatchRule(cut2.get(0), cut1.get(0), key)){
                cut3.add(cut2.remove(0));
            }else {
                cut3.add(cut1.remove(0));
            }
        }
        // 至少有一个片段已为空，将剩下的有序部分直接放置在后面即可
        cut3.addAll(cut1);
        cut3.addAll(cut2);
        return cut3;
    }

    /**
     * 按照特定的间隔数插入排序指定的序列
     * @param arr ArrayList<Item>: 待排序数组
     * @param gap int: 指定的间隔
     * @param begin int: 开始的元素索引位置
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     * **/
    private static <Item extends Comparable<? super Item>> void gapInsert(ArrayList<Item> arr, int gap, int begin, int key){
        for (int j = begin; j > 0; j -= gap) {
            if (!isMatchRule(arr.get(j - gap), arr.get(j), key)){
                exchange(arr, j, j - gap);
            }else {
                break;
            }
        }
    }

    /**
     * 希尔排序入口1
     * **/
    public static <Item extends Comparable<? super Item>> void shellSort(ArrayList<Item> arr, int key){
        shell(arr, key);
    }

    /**
     * 希尔排序入口2
     * **/
    public static <Item extends Comparable<? super Item>> void shellSort(ArrayList<Item> arr){
        shell(arr, 1);
    }

    /**
     * 希尔排序主方法
     * @param arr ArrayList<Item>: 待排序数组
     * @param key int: 排序选项，当传入非负数时按增序排序，当传入负数时按降序排序
     * **/
    private static <Item extends Comparable<? super Item>> void shell(ArrayList<Item> arr, int key){
        for (int j = arr.size(); j >= 1; j /= 2){
            for (int i = j; i < arr.size(); i += j) {
                gapInsert(arr, j, i, key);
            }
        }
    }

    public static <Item extends Comparable<? super Item>> void quickSort(ArrayList<Item> arr){
        _quickSort(arr, 0, arr.size() - 1, 1);
    }

    public static <Item extends Comparable<? super Item>> void quickSort(ArrayList<Item> arr, int key){
        _quickSort(arr, 0, arr.size() - 1, key);
    }

    private static <Item extends Comparable<? super Item>> void _quickSort(ArrayList<Item> arr, int l_bound, int r_bound, int key){
        if (l_bound < r_bound){
            int left = l_bound;
            int right = r_bound;
            Item tmp = arr.get(l_bound);
            int flag = -1;
            while (left < right){
                if (flag == -1){
                    if (isMatchRule(tmp, arr.get(right), true, key)){
                        right -= 1;
                    }else {
                        exchange(arr, left, right);
                        flag = 1;
                    }
                }else {
                    if (isMatchRule(arr.get(left), tmp, true, key)){
                        left += 1;
                    }else {
                        exchange(arr, left, right);
                        flag = -1;
                    }
                }
            }
            _quickSort(arr, l_bound, left - 1, key);
            _quickSort(arr, right + 1, r_bound, key);
        }
    }
}
