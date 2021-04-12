package DSAA.alg4.c1.nodesList_c19;

import standard.StdOut;

import java.util.Arrays;

public class test {
    public static void main(String[] args){
        nodesList<Integer> l1 = new nodesList<>(new node<>(5));
        nodesList<Integer> l2 = new nodesList<>(l1);
        StdOut.println(l2.getHead() + " " + l2.getTail() + " " + l2.size());

        nodesList<Integer> l3 = list.makeList(Arrays.asList(1, 4, 3, 6, 8, 7, 17, 13));
        for (node<Integer> n: l3){
            StdOut.println(n);
        }
        StdOut.println();
        StdOut.println(l3.size());
        nodesList<Character> l4 = list.makeList('A', 'K', 'm', 'G');
        for (node<Character> c: l4){
            StdOut.println(c);
        }
        l4.addHead(new node<>('o'));
        StdOut.println(l4.getHead());
        StdOut.println();
        for (node<Character> c: l4){
            StdOut.println(c);
        }
        StdOut.println(l4.size());
        StdOut.println(l4.removeTail());
        StdOut.println(l4.removeHead());
        StdOut.println();
        for (node<Character> c: l4){
            StdOut.println(c);
        }
    }
}
