package DSAA.alg4.c1.farthestCp_c113;

import standard.StdOut;

public class test {
    public static void main(String[] args){
        double[] arr = farthestCp.find(new double[] {3, -3, 0, 1, 5, -5, 8, 2, 9, 6, 3, 2, -2, 0});
        for (double num: arr) {
            StdOut.println(num);
        }
    }
}
