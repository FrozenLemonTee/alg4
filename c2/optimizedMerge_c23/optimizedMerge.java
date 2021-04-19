/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/16
 @encoding UTF-8
 **/
package DSAA.alg4.c2.optimizedMerge_c23;

import DSAA.alg4.c2.arraySort_c22.arraySort;

import java.util.ArrayList;

public class optimizedMerge {
    private static <Item extends Comparable<? super Item>> void mergeInPlace(ArrayList<Item> arr, int left, int right, int key){
        if (right - left > 1){
            int mid = (left + right) / 2;
            mergeInPlace(arr, left, mid, key);
            mergeInPlace(arr, mid, right, key);
            ArrayList<Item> aux = new ArrayList<>();
            int pl, pr;
            pl = left;
            pr = mid;
            while (pl < mid && pr < right){
                if (arraySort.isMatchRule(arr.get(pl), arr.get(pr), key)){
                    aux.add(arr.get(pl));
                    pl += 1;
                }else {
                    aux.add(arr.get(pr));
                    pr += 1;
                }
            }
            while (pl < mid){
                aux.add(arr.get(pl));
                pl += 1;
            }
            while (pr < right){
                aux.add(arr.get(pr));
                pr += 1;
            }
            for (int i = 0; i < aux.size(); i++) {
                arr.set(left + i, aux.get(i));
            }
        }
    }

    public static <Item extends Comparable<? super Item>> void mergeSort(ArrayList<Item> arr, int key){
        mergeInPlace(arr, 0, arr.size(), key);
    }

    public static <Item extends Comparable<? super Item>> void mergeSort(ArrayList<Item> arr){
        mergeInPlace(arr, 0, arr.size(), 1);
    }
}
