package DSAA.alg4.c1.resizingArrayQueue_c18;

import standard.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args){
        resizingArrayQueue<Integer> qu1 = new resizingArrayQueue<>(5);
        for (Integer i: qu1) {
            StdOut.println(i);
        }
        StdOut.println(qu1);
        StdOut.println("size: " + qu1.size());
        qu1.push(1);
        qu1.push(1);
        qu1.push(4);
        qu1.push(5);
        qu1.push(1);
        qu1.push(4);
        for (Integer i: qu1) {
            StdOut.println(i);
        }
        StdOut.println(qu1);
        resizingArrayQueue<Integer> qu2 = new resizingArrayQueue<>(new ArrayList<>(Arrays.asList(1, 9, 1, 9, 8, 1, 0)));
        StdOut.println("size: " + qu2.size());
        StdOut.println(qu2);
        for (int i = qu2.size(); i > 0; i -= 1){
            qu2.pop();
            StdOut.println(qu2);
        }
        resizingArrayQueue<Integer> qu3 = new resizingArrayQueue<>();
        StdOut.println();
        StdOut.println(qu3);
        for (int i = 0; i < 50; i += 1){
            qu3.push(i);
            StdOut.println(qu3);
        }
        for (int i = 50; i > 0; i -= 1){
            qu3.pop();
            StdOut.println(qu3);
        }
    }
}
