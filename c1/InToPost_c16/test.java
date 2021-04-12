package DSAA.alg4.c1.InToPost_c16;

import standard.StdOut;

public class test {
    public static void main(String[] args){
        StdOut.println(parseInfix.inToPost("2 * 3 / ( 2 - 1 ) + 3 * ( 4 - 1 ) "));
        StdOut.println(parsePostFix.evalPostFix("2 3 * 2 1 - / 3 4 1 - * + "));
    }
}
