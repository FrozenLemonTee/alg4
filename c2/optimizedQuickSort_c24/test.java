package DSAA.alg4.c2.optimizedQuickSort_c24;

import DSAA.alg4.c2.transaction_c21.Transactions;
import DSAA.alg4.c2.transaction_c21.trans;
import standard.StdOut;

import java.util.ArrayList;

public class test {
    public static void main(String[] args){
        ArrayList<Transactions> arr = trans.makeList(new String[] {
                "2021-5-18:175.4@Sam", "2014-7-9:200@Tim",
                "2021-5-18:235.7@Klaudia", "2021-5-18:313.69@Ryza",
                "2021-5-18:313.69@Klaudia", "2019-11-21:777@Jim",
                "2021-5-14:37.4@LiHua"
        });
        optimizedQuickSort.quickSort(arr);
        trans.printAll(arr);
        StdOut.println();
        ArrayList<Transactions> arr2 = trans.makeList(new String[] {"2021-5-18", "2014-7-9", "2019-11-21", "2021-5-14", "2021-6-1", "2020-3-10"});
        optimizedQuickSort.quickSort(arr2, -1);
        trans.printAll(arr2);
    }
}
