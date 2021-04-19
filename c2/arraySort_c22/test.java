package DSAA.alg4.c2.arraySort_c22;

import DSAA.alg4.c2.transaction_c21.Transactions;
import DSAA.alg4.c2.transaction_c21.trans;
import standard.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args){
        ArrayList<Character> arr = new ArrayList<>(Arrays.asList('m', 'e', 'r', 'g', 'e', 's', 'o', 'r', 't'));
        arraySort.binarySort(arr, -1);
        arraySort.selectSort(arr);
        trans.printAll(arr);
        ArrayList<Transactions> arr2 = trans.makeList(new String[] {"1999-10-4:15000@FrozenLemonTee", "1824-7-20:3500@Kali", "2021-4-16:154.38@FrozenLemonTee"});
        arraySort.insertSort(arr2);
        trans.printAll(arr2);
        StdOut.println();
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(5, 1, 3, 4, 2, 0, 9, 6, 8, 11, 10, 15, 13, 13, 17, 19, 18));
        arraySort.binarySort(arr3);
        trans.printAll(arr3);
        StdOut.println();
        ArrayList<Transactions> arr4 = trans.makeList(new String[] {"2021-5-18", "2014-7-9", "2019-11-21", "2021-5-14", "2021-6-1", "2020-3-10"});
        arraySort.quickSort(arr4, -1);
        trans.printAll(arr4);
        StdOut.println();
        ArrayList<Transactions> arr5 = trans.makeList(new String[] {
                "2021-5-18:175.4@Sam", "2014-7-9:200@Tim",
                "2021-5-18:235.7@Klaudia", "2021-5-18:313.69@Ryza",
                "2021-5-18:313.69@Klaudia", "2019-11-21:777@Jim",
                "2021-5-14:37.4@LiHua"
        });
        arraySort.quickSort(arr5);
        trans.printAll(arr5);
    }
}
