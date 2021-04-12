package DSAA.alg4.c1.localMinimum_c115;

import standard.StdOut;

public class test {
    public static void main(String[] args){
        StdOut.println(localMinimum.find(new int[] {5, 7, 4, 6, 8, 10}));
        StdOut.println(localMinimum.find(new int[] {5, 7, 4, 6, 3, 10, 11}));
        StdOut.println(localMinimum.find(new int[] {}));
        StdOut.println(localMinimum.find(new int[] {233}));
        int[][] arr1 = {
                new int[] {2, 6, 8, 9, 11, 12, 15},
                new int[] {19, 2, 12, 11, 10, 6, 21},
                new int[] {11, 4, 3, 1, 9, 7, 20}
        };
        StdOut.println();
        int[] res = localMinimum.find(arr1);
        for (int re : res) {
            StdOut.println(re);
        }
    }
}
