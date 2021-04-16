package DSAA.alg4.c2.transaction_c21;

import DSAA.alg4.c2.arraySort_c22.arraySort;
import standard.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args){
        String[] dates = {"2021-5-18", "2014-7-9", "2019-11-21", "2021-5-14", "2021-6-1", "2020-3-10"};
        ArrayList<Date> arr = new ArrayList<>();
        for (String s: dates) {
            arr.add(new Date(s));
        }
        arr.add(new Date(2019, 10, 10));
        arraySort.selectSort(arr, -1);
        for (Date d: arr) {
            StdOut.println(d);
        }
        StdOut.println();
        arraySort.selectSort(arr, 1);
        for (Date d: arr) {
            StdOut.println(d);
        }
        StdOut.println();
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(10, 5, 8, 4, 2, 0, 11));
        arraySort.insertSort(arr2, -1);
        for (Integer i: arr2) {
            StdOut.println(i);
        }
        StdOut.println();
        String[] t = {"2021-5-18:175.4@Sam", "2014-7-9:200@Tim",
                "2021-5-18:235.7@Klaudia", "2021-5-18:313.69@Ryza",
                "2021-5-18:313.69@Klaudia", "2019-11-21:777@Jim",
                "2021-5-14:37.4@LiHua"};
        StdOut.println(new Transaction("Senpai", new Date("2000-12-25"), 114514.1919810));
        ArrayList<Transaction> transactions = new ArrayList<>();
        for (String tr: t) {
            transactions.add(new Transaction(tr));
        }
        arraySort.bubbleSort(transactions, 1);
        for (Transaction tr: transactions) {
            StdOut.println(tr);
        }
        String[] dates2 = {"2021-6-28", "2019-3-4", "2019-1-21", "2020-5-14", "2020-6-1", "2021-3-10", "2000-12-25"};
        ArrayList<Date> arr3 = new ArrayList<>();
        for (String s: dates2) {
            arr3.add(new Date(s));
        }
        ArrayList<Date> a1 = new ArrayList<>();
        arraySort.binarySort(a1, 1);
        arraySort.binarySort(arr3, -1);
        StdOut.println();
        for (Date d: arr3) {
            StdOut.println(d);
        }
        StdOut.println();
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(2, 6, 9, 3, 7, 4, 1, 0, 8));
        arr4 = arraySort.mergeSort(arr4, 1);
        for (Integer c: arr4) {
            StdOut.println(c);
        }
        StdOut.println();
        String[] dates3 = {"2021-6-28", "2019-3-4"};
        ArrayList<Date> arr5 = new ArrayList<>();
        for (String s: dates3) {
            arr5.add(new Date(s));
        }
        arraySort.shellSort(arr5, -1);
        for (Date d: arr5) {
            StdOut.println(d);
        }
        StdOut.println();
        ArrayList<String> arr6 = new ArrayList<>(Arrays.asList("Sam", "Lily", "Judy", "Jim", "Kate"));
        arraySort.shellSort(arr6, -1);
        for (String s: arr6) {
            StdOut.println(s);
        }
    }
}
