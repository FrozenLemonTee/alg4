package DSAA.alg4.c1.quick_union;

public class test {
    public static void main(String[] args) {
        quick_union qu = new quick_union(10);
        System.out.println(qu);
        qu.union(0,9);
        System.out.println(qu);
        qu.union(3,5);
        System.out.println(qu);
        qu.union(6,8);
        System.out.println(qu);
        qu.union(6,7);
        System.out.println(qu);
        qu.union(2,2);
        System.out.println(qu);
        qu.union(8,9);
        System.out.println(qu);
        qu.union(5,6);
        System.out.println(qu);
    }
}
