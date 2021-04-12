package DSAA.alg4.c1.interval1D_c12;

import standard.StdOut;

import java.util.ArrayList;

public class test {
    public static void main(String[] args){
        double[][] b = interval1D.inputToIntervals(Integer.parseInt(args[0]));
        ArrayList<double[]> a = interval1D.overlapIntervals(b);
        for (double[] d: a){
            StdOut.println(d[0] + " " + d[1]);
        }
        interval1D.printOverlapCouple(b);
    }
}
