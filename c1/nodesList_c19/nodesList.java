/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/05
 @encoding UTF-8
 **/
package DSAA.alg4.c1.nodesList_c19;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class nodesList<Item> implements Iterable<node<Item>> {
    /** 链表头部指针 **/
    private node<Item> head;
    /** 链表尾部指针 **/
    private node<Item> tail;
    /** 链表的长度 **/
    private int size;

    /**
     * 构造函数，当参数列表为空时调用，头尾指针引用为空，链表长度初始化为0
     * **/
    public nodesList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * 辅助方法，当链表为空时初始化调用，头尾指针皆指向以此结点新复制的结点
     * @param first node<Item>: 待复制的结点
     * **/
    private void initFirstNode(node<Item> first){
        this.head = new node<>(first);
        this.tail = this.head;
        this.size = 1;
    }

    /**
     * 构造函数，当参数列表传入一个结点时调用
     * @param node node<Item>: 待复制的结点
     * **/
    public nodesList(node<Item> node){
        this.initFirstNode(node);
    }

    /**
     * 构造函数，当参数列表传入一个链表时调用，直接复制原链表
     * @param nList nodesList<Item>: 待复制的链表
     * **/
    public nodesList(nodesList<Item> nList){
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.addAll(nList);
    }

    /**
     * 获取链表头结点
     * @return node<Item>: 返回链表头结点的引用
     * **/
    public node<Item> getHead() {
        return this.head;
    }

    /**
     * 获取链表尾结点
     * @return node<Item>: 返回链表尾结点的引用
     * **/
    public node<Item> getTail() {
        return this.tail;
    }

    /**
     * 将结点添加到链表尾部
     * @param node node<Item>: 待添加的结点
     * **/
    public void addTail(node<Item> node){
        if (this.isEmpty()){
            this.initFirstNode(node);
        }else {
            node<Item> tmp = new node<>(node);
            this.tail.setNext(tmp);
            this.tail = tmp;
            this.size += 1;
        }
    }

    /**
     * 将结点添加到链表头部
     * @param node node<Item>: 待添加的结点
     * **/
    public void addHead(node<Item> node){
        if (this.isEmpty()){
            this.initFirstNode(node);
        }else {
            node<Item> tmp = new node<>(node);
            tmp.setNext(this.head);
            this.head = tmp;
            this.size += 1;
        }
    }

    /**
     * 将待添加的链表的所有结点按顺序添加到此链表的尾部
     * @param nList nodesList<Item>: 待复制的链表
     * **/
    public void addAll(nodesList<Item> nList){
        for (node<Item> n: nList){
            this.addTail(n);
        }
    }

    /**
     * 移除链表头部的结点并返回
     * @return node<Item>: 移除的结点
     * **/
    public node<Item> removeHead(){
        if (this.isEmpty()){
            throw new NoSuchElementException("Empty nodesList");
        }
        node<Item> tmp = this.head;
        this.head = this.head.getNext();
        if (this.size() == 1){
            this.tail = null;
        }
        tmp.setNext(null);
        this.size -= 1;
        return tmp;
    }

    /**
     * 移除链表尾部的结点并返回
     * @return node<Item>: 移除的结点
     * **/
    public node<Item> removeTail(){
        if (this.isEmpty()){
            throw new NoSuchElementException("Empty nodesList");
        }
        node<Item> tmp = this.tail;
        node<Item> cur = this.head;
        if (this.size() == 1){
            this.tail = null;
            this.head = null;
            this.size -= 1;
            return tmp;
        }
        while (cur.getNext() != tmp){
            cur = cur.getNext();
        }
        this.tail = cur;
        this.tail.setNext(null);
        this.size -= 1;
        return tmp;
    }

    /**
     * 判断链表是否为空
     * @return boolean: 返回是/否
     * **/
    public boolean isEmpty(){
        return this.size() == 0;
    }

    /**
     * 返回一个迭代器
     * @return Iterator<node<Item>>: 新的迭代器
     * **/
    @Override
    public Iterator<node<Item>> iterator() {
        return new nodeIterator();
    }

    /**
     * 内部的迭代器类
     * @implSpec 实现了 {@code next()} 和 {@code hasNext()} 方法
     * **/
    private class nodeIterator implements Iterator<node<Item>>{
        /** 当前指向的迭代指针 **/
        node<Item> cur = head;

        /**
         * 判断当前指针是否指到了链表尾部
         * @return boolean: 返回是/否
         * **/
        @Override
        public boolean hasNext() {
            return this.cur != null;
        }

        /**
         * 返回当前迭代所指向的结点
         * @return node<Item>: 当前迭代所指向的结点
         * **/
        @Override
        public node<Item> next() {
            node<Item> node = this.cur;
            this.cur = this.cur.getNext();
            return node;
        }
    }

    /**
     * 返回当前链表的长度
     * @return int: 当前链表的长度
     * **/
    public int size(){
        return this.size;
    }
}
