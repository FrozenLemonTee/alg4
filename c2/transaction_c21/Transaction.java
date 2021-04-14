/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/13
 @encoding UTF-8
 **/
package DSAA.alg4.c2.transaction_c21;

import java.util.Objects;

public class Transaction implements Comparable<Transaction>{
    /** 交易人 **/
    private final String who;
    /** 交易日期 **/
    private final Date when;
    /** 交易金额 **/
    private final double amount;

    /**
     * 当交易人、交易日期、交易金额分别传入时调用此构造函数
     * @param who String: 交易人
     * @param when Date: 交易日期
     * @param amount double: 交易金额
     * **/
    public Transaction(String who, Date when, double amount){
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    /**
     * 当传入交易信息的格式化字符串时调用此构造函数，格式"when:amount@who"
     * @param transaction String: 交易信息的格式化字符串
     * **/
    public Transaction(String transaction){
        String[] t = transaction.split("[:@]");
        this.who = t[2];
        this.when = new Date(t[0]);
        this.amount = Double.parseDouble(t[1]);
    }

    /**
     * 交易信息的字符串表示
     * @return String: 交易信息的字符串表示
     * **/
    @Override
    public String toString() {
        return "who: " + this.getWho() + ", when: " + this.getWhen() + ", amount: " + this.getAmount();
    }

    /**
     * 判断一个对象是否等于自己
     * @param o Object: 一个对象
     *
     * @return boolean: 是/否
     * **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, this.amount) == 0
                && Objects.equals(this.who, that.who)
                && Objects.equals(this.when, that.when);
    }

    /**
     * 返回当前对象的哈希码
     * @return int: 哈希码
     * **/
    @Override
    public int hashCode() {
        return Objects.hash(this.who, this.when, this.amount);
    }

    /**
     * 返回交易人
     * @return String: 交易人
     * **/
    public String getWho() {
        return this.who;
    }

    /**
     * 返回交易日期
     * @return Date: 交易日期
     * **/
    public Date getWhen() {
        return this.when;
    }

    /**
     * 返回交易金额
     * @return Date: 交易金额
     * **/
    public double getAmount() {
        return this.amount;
    }

    /**
     * 比较函数，比较两个交易的排序意义的先后
     * 先按交易日期增序排序，若相同则按交易金额降序排序，仍相同则按交易人字符串的字典序增序排序
     * @param o Transaction: 另一个交易
     *
     * @implSpec 实现了接口，见：
     * @see Comparable
     *
     * @return int: 返回-1：当前交易在被比较交易前；返回1：当前交易在被比较交易后；返回0：当前交易与被比较交易相同
     * **/
    @Override
    public int compareTo(Transaction o) {
        if (this.equals(o)){
            return 0;
        }
        if (this.getWhen().compareTo(o.getWhen()) != 0){
            return this.getWhen().compareTo(o.getWhen());
        }
        if (this.getAmount() > o.getAmount()){
            return -1;
        }else if (this.getAmount() < o.getAmount()){
            return 1;
        }
        return this.getWho().compareTo(o.getWho());
    }
}
