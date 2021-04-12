package DSAA.alg4.c1.parentheses_c16;

import standard.StdOut;

public class test {
    public static void main(String[] args){
        parentheses a = new parentheses("");
        StdOut.println(a.isMatch());
        parentheses b = new parentheses("{}[[{}](())]{}");
        StdOut.println(b.isMatch());
        parentheses c = new parentheses("({)}");
        StdOut.println(c.isMatch());
    }
}
