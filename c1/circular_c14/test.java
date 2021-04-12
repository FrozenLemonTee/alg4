package DSAA.alg4.c1.circular_c14;

import standard.StdOut;

public class test {
    public static void main(String[] args){
        StdOut.println(circular.isCircularString("ACTGACG", "TGACGAC"));
        StdOut.println(circular.isCircularString("", "TGACGAC"));
        StdOut.println(circular.isCircularString("", ""));
    }
}
