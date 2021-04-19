package DSAA.alg4.c2.optimizedMerge_c23;

import DSAA.alg4.c2.transaction_c21.Transactions;
import DSAA.alg4.c2.transaction_c21.trans;
import standard.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 7, 3, 2, 1, 5, 9, 0));
        optimizedMerge.mergeSort(arr, -1);
        for (Integer i: arr) {
            StdOut.println(i);
        }
        StdOut.println();
        ArrayList<Transactions> arr2 = trans.makeList(new String[] {"2015-3-4", "2018-7-9", "2019-9-2", "2022-1-1", "1824-7-13"});
        optimizedMerge.mergeSort(arr2);
        for (Transactions tr: arr2) {
            StdOut.println(tr);
        }
    }
}
