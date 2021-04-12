package DSAA.alg4.c1.leftBracketAdd_c17;

import standard.StdOut;

public class test {
    public static void main(String[] args){
        leftBracketAdd l = new leftBracketAdd("1+2)*3-4)*5-6)))");
        StdOut.println(l.addLeftBracket());
        leftBracketAdd k = new leftBracketAdd("1*1+1+1*1+1)))))");
        StdOut.println(k.addLeftBracket());
        leftBracketAdd j = new leftBracketAdd("1+1)*1)+1)*1)");
        StdOut.println(j.addLeftBracket());
    }
}
