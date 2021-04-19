/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/18
 @encoding UTF-8
 **/
package DSAA.alg4.c2.transaction_c21;

import standard.StdOut;

import java.util.ArrayList;

public class trans {
    private static Transactions getTransactions(String s){
        if (s.contains("@")){
            return new Transaction(s);
        }else {
            return new Date(s);
        }
    }

    public static ArrayList<Transactions> makeList(String[] ss){
        ArrayList<Transactions> res = new ArrayList<>();
        for (String s: ss) {
            res.add(getTransactions(s));
        }
        return res;
    }

    public static <Item> void printAll(ArrayList<Item> arr){
        for (Item i: arr) {
            StdOut.println(i);
        }
    }
}
