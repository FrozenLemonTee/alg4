package DSAA.alg4.c1.interval2D_c13;

public class test {
    public static void main(String[] args){
        double[][] intervals = interval2D.inputToIntervals(Integer.parseInt(args[0]));
        interval2D.draw(intervals);
        interval2D.printOverlapCouple(intervals);
    }
}
