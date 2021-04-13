/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/13
 @encoding UTF-8
 **/
package DSAA.alg4.c2.transaction_c21;

import java.util.Objects;

public class Transaction implements Comparable<Transaction>{
    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount){
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String transaction){
        String[] t = transaction.split("[:@]");
        this.who = t[2];
        this.when = new Date(t[0]);
        this.amount = Double.parseDouble(t[1]);
    }

    @Override
    public String toString() {
        return "who: " + this.getWho() + ", when: " + this.getWhen() + ", amount: " + this.getAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, this.amount) == 0
                && Objects.equals(this.who, that.who)
                && Objects.equals(this.when, that.when);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.who, this.when, this.amount);
    }

    public String getWho() {
        return this.who;
    }

    public Date getWhen() {
        return this.when;
    }

    public double getAmount() {
        return this.amount;
    }

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
