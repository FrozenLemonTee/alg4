/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/19
 @encoding UTF-8
 **/
package DSAA.alg4.c2.optimizedQuickSort_c24;

import DSAA.alg4.c2.arraySort_c22.arraySort;

import java.util.ArrayList;

public class optimizedQuickSort {
    public static <Item extends Comparable<? super Item>> void quickSort(ArrayList<Item> arr){
        dualPivotQuickSort(arr, 0, arr.size() - 1, 1);
    }

    public static <Item extends Comparable<? super Item>> void quickSort(ArrayList<Item> arr, int key){
        dualPivotQuickSort(arr, 0, arr.size() - 1, key);
    }

    private static <Item extends Comparable<? super Item>> void dualPivotQuickSort(ArrayList<Item> arr, int l_bound, int r_bound, int key){
        if (l_bound < r_bound){
            if (!arraySort.isMatchRule(arr.get(l_bound), arr.get(r_bound), key)){
                arraySort.exchange(arr, l_bound, r_bound);
            }
            Item pivot_l = arr.get(l_bound);
            Item pivot_r = arr.get(r_bound);
            int left = l_bound;
            int right = r_bound;
            int mid = left + 1;
            while (mid < right){
                if (arraySort.isMatchRule(arr.get(mid), pivot_l, true, key)){
                    left += 1;
                    arraySort.exchange(arr, left, mid);
                    mid += 1;
                }else if (arraySort.isMatchRule(arr.get(mid), pivot_r, true, key)){
                    mid += 1;
                }else {
                    right -= 1;
                    while (right > mid && arraySort.isMatchRule(pivot_r, arr.get(right), true, key)){
                        right -= 1;
                    }
                    if (mid < right){
                        arraySort.exchange(arr, mid, right);
                    }
                }
            }
            arraySort.exchange(arr, l_bound, left);
            arraySort.exchange(arr, r_bound, right);
            dualPivotQuickSort(arr, l_bound, left - 1, key);
            dualPivotQuickSort(arr, left + 1, right - 1, key);
            dualPivotQuickSort(arr, right + 1, r_bound, key);
        }
    }
}
