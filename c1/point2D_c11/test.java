package DSAA.alg4.c1.point2D_c11;

public class test {
    public static void main(String[] args){
        double[][] p = point2D.initPoints(Integer.parseInt(args[0]));
        point2D.initDraw(0, 1, 0, 1, 0.01);
        point2D.drawPoints(p);
        point2D.minDistance(p);
    }
}
