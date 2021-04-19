/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/13
 @encoding UTF-8
 **/
package DSAA.alg4.c2.transaction_c21;

import java.util.Objects;

public class Date implements Transactions{
    /** 储存天 **/
    private int day;
    /** 储存月 **/
    private int month;
    /** 储存年 **/
    private int year;

    /**
     * 当年月日分别以整型形式传入时调用此构造函数
     * @param year int: 年
     * @param month int: 月
     * @param day int: 日
     * **/
    public Date(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * 当传入日期的格式化字符串时调用此构造函数，格式"y-m-d"
     * @param date String: 日期的格式化字符串，以"-"分隔
     * **/
    public Date(String date){
        this.formatString(date);
    }

    /**
     * 日期对象的字符串表示，格式化表示，格式"y-m-d"
     * @return String: 日期的格式化字符串，以"-"分隔
     * **/
    @Override
    public String toString() {
        return "" + this.year + "-" + this.month + "-" + this.day;
    }

    /**
     * 返回日
     * @return int: 日
     * **/
    public int getDay(){
        return this.day;
    }

    /**
     * 返回月
     * @return int: 月
     * **/
    public int getMonth(){
        return this.month;
    }

    /**
     * 返回年
     * @return int: 年
     * **/
    public int getYear(){
        return this.year;
    }

    /**
     * 比较函数，比较两日期的先后
     * @param transactions Transactions: 被比较的另一个日期
     *
     * @implSpec 实现了接口，见：
     * @see Comparable
     *
     * @return int: 返回-1：当前日期早于被比较日期；返回1：当前日期晚于被比较日期；返回0：当前日期与被比较日期相同
     * **/
    @Override
    public int compareTo(Transactions transactions) {
        Date another = (Date) transactions;
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

    /**
     * 判断另一个对象是否与自己相同（只有另一个对象是{@code Date}类，且两者日期相同才为相等）
     * @param o Object: 一个对象（可以是任何类的对象或空指针）
     *
     * @return boolean: 是/否
     * **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.getDay()
                && month == date.getMonth()
                && year == date.getYear();
    }

    /**
     * 返回当前对象的哈希码
     * @return int: 哈希码
     * **/
    @Override
    public int hashCode() {
        return Objects.hash(this.day, this.month, this.year);
    }

    @Override
    public void formatString(String date) {
        String[] d = date.split("-");
        this.day = Integer.parseInt(d[2]);
        this.month = Integer.parseInt(d[1]);
        this.year = Integer.parseInt(d[0]);
    }
}
