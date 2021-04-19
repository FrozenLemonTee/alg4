package DSAA.alg4.c2.transaction_c21;

import DSAA.alg4.c2.arraySort_c22.arraySort;
import standard.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args){
        ArrayList<Transactions> arr = trans.makeList(new String[] {"2021-5-18", "2014-7-9", "2019-11-21", "2021-5-14", "2021-6-1", "2020-3-10"});
        arr.add(new Date(2019, 10, 10));
        arraySort.selectSort(arr, -1);
        trans.printAll(arr);
        StdOut.println();
        arraySort.selectSort(arr, 1);
        trans.printAll(arr);
        StdOut.println();
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(10, 5, 8, 4, 2, 0, 11));
        arraySort.insertSort(arr2, -1);
        trans.printAll(arr2);
        StdOut.println();
        ArrayList<Transactions> transactions = trans.makeList(new String[]
                {"2021-5-18:175.4@Sam", "2014-7-9:200@Tim",
                "2021-5-18:235.7@Klaudia", "2021-5-18:313.69@Ryza",
                "2021-5-18:313.69@Klaudia", "2019-11-21:777@Jim",
                "2021-5-14:37.4@LiHua"});
        transactions.add(new Transaction("Senpai", new Date("2000-12-25"), 114514.1919810));
        arraySort.bubbleSort(transactions, 1);
        trans.printAll(transactions);
        ArrayList<Transactions> arr3 = trans.makeList(new String[] {"2021-6-28", "2019-3-4", "2019-1-21", "2020-5-14", "2020-6-1", "2021-3-10", "2000-12-25"});
        arraySort.binarySort(arr3, -1);
        StdOut.println();
        trans.printAll(arr3);
        StdOut.println();
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(2, 6, 9, 3, 7, 4, 1, 0, 8));
        arr4 = arraySort.mergeSort(arr4, 1);
        trans.printAll(arr4);
        StdOut.println();
        ArrayList<Transactions> arr5 = trans.makeList(new String[] {"2021-6-28", "2019-3-4"});
        arraySort.shellSort(arr5, -1);
        trans.printAll(arr5);
        StdOut.println();
        ArrayList<String> arr6 = new ArrayList<>(Arrays.asList("Sam", "Lily", "Judy", "Jim", "Kate"));
        arraySort.shellSort(arr6, -1);
        trans.printAll(arr6);
    }
}
