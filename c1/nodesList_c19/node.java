/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/05
 @encoding UTF-8
 **/
package DSAA.alg4.c1.nodesList_c19;

public class node<Item> {
    /** 结点数据域，存放数据对象 **/
    private final Item data;
    /** 结点指针域，存放下一个结点的引用 **/
    private node<Item> next;

    /**
     * 构造函数，当参数列表传入数据对象时调用
     * @param data Item: 传入的数据对象
     * **/
    public node(Item data){
        this.data = data;
        this.next = null;
    }

    /**
     * 构造函数，当参数列表传入结点时调用，复制该结点的数据域
     * @param node node<Item>: 传入的结点
     * **/
    public node(node<Item> node){
        this.data = node.getData();
        this.next = null;
    }

    /**
     * 获取结点数据域的数据对象
     * @return Item: 返回结点的数据域
     * **/
    public Item getData() {
        return this.data;
    }

    /**
     * 获取结点指针域的引用
     * @return node<Item>: 返回结点指针域的引用
     * **/
    public node<Item> getNext() {
        return this.next;
    }

    /**
     * 改变结点指针域的指向
     * @param next node<Item>: 传入待改变的引用
     * **/
    protected void setNext(node<Item> next) {
        this.next = next;
    }

    /**
     * 返回结点的字符串表现形式
     * @return String: 结点的字符串表现形式
     * **/
    @Override
    public String toString() {
        return this.data.toString();
    }
}
