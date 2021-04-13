/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/13
 @encoding UTF-8
 **/
package DSAA.alg4.c2.transaction_c21;

import java.util.ArrayList;

public class arraySort {
    public static <Item extends Comparable<? super Item>> void selectSort(ArrayList<Item> arr, int key){
        key = key >= 0 ? 1: -1;
        for (int i = arr.size(); i > 0; i--) {
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

    public static <Item extends Comparable<? super Item>> void binarySort(ArrayList<Item> arr, int key){
        for (int i = 1; i < arr.size(); i++) {
            int index = binaryIndex(arr, i, key);
            Item tmp = arr.remove(i);
            arr.add(index, tmp);
        }
    }

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

    private static <Item extends Comparable<? super Item>> int compareSides(ArrayList<Item> arr, int r_bound, int mid, int key){
        Item item = arr.get(r_bound);
        boolean left = mid == 0 || arr.get(mid - 1).compareTo(item) != key;
        boolean right = mid == r_bound - 1 || item.compareTo(arr.get(mid)) != key;
        if (!left && right){
            return -1;
        }else if (left && !right){
            return 1;
        }
        return 0;
    }
}
