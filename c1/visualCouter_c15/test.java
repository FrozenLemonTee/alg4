package DSAA.alg4.c1.visualCouter_c15;

import standard.StdIn;
import standard.StdOut;


public class test {
    public static void main(String[] args){
        visualCounter v1 = new visualCounter(30, 10);
        while (!v1.isMAX_N()){
            String s = StdIn.readLine();
            v1.switches(s);
            v1.show();
            StdOut.println(v1);
        }
        System.exit(0);
    }
}
