package DSAA.alg4.c1.quickUnion_c116;

public class test {
    public static void main(String[] args) throws InterruptedException {
        quickUnion q1 = new quickUnion(5);
        q1.show();
        for (int i = 0; i < 30; i++) {
            quickUnion.randUnion(q1);
            q1.show();
        }
    }
}
