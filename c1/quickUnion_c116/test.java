package DSAA.alg4.c1.quickUnion_c116;

public class test {
    public static void main(String[] args) throws InterruptedException {
        quickUnion q1 = new quickUnion(3);
        for (int i = 0; i < 10; i++) {
            quickUnion.randUnion(q1);
            q1.show();
        }
    }
}
