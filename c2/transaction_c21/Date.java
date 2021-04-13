/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/13
 @encoding UTF-8
 **/
package DSAA.alg4.c2.transaction_c21;

import java.util.Objects;

public class Date implements Comparable<Date>{
    private final int day;
    private final int month;
    private final int year;

    public Date(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(String date){
        String[] d = date.split("-");
        this.day = Integer.parseInt(d[2]);
        this.month = Integer.parseInt(d[1]);
        this.year = Integer.parseInt(d[0]);
    }

    @Override
    public String toString() {
        return "" + this.year + "-" + this.month + "-" + this.day;
    }

    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }

    @Override
    public int compareTo(Date another) {
        if (this.equals(another)){
            return 0;
        }
        if (this.getYear() > another.getYear()){
            return 1;
        }else if (this.getYear() < another.getYear()){
            return -1;
        }
        if (this.getMonth() > another.getMonth()){
            return 1;
        }else if (this.getMonth() < another.getMonth()){
            return -1;
        }
        if (this.getDay() > another.getDay()){
            return 1;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.getDay()
                && month == date.getMonth()
                && year == date.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.day, this.month, this.year);
    }
}
