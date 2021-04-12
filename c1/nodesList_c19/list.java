/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/05
 @encoding UTF-8
 **/
package DSAA.alg4.c1.nodesList_c19;

import java.util.List;

public class list {
    /**
     * 按当前所给定的元素顺序直接构造一个链表（当参数列表传入的容器为 {@code List<Item>}时调用）
     * @param arr List<Item>: 传入的容器
     *
     * @return nodesList<Item>: 构造出的新链表
     * **/
    public static <Item> nodesList<Item> makeList(List<Item> arr){
        nodesList<Item> aList = new nodesList<>();
        for (Item i: arr){
            aList.addTail(new node<>(i));
        }
        return aList;
    }

    /**
     * 按当前所给定的元素顺序直接构造一个链表（当参数列表传入若干待装箱元素时调用）
     * @param items Item ...: 若干待装箱的元素
     *
     * @return nodesList<Item>: 构造出的新链表
     * **/
    @SafeVarargs
    public static <Item> nodesList<Item> makeList(Item ... items){
        nodesList<Item> aList = new nodesList<>();
        for (Item item : items) {
            aList.addTail(new node<>(item));
        }
        return aList;
    }
}
