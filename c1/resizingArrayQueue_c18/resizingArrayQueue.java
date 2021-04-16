/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/04
 @encoding UTF-8
 **/
package DSAA.alg4.c1.resizingArrayQueue_c18;


import java.util.ArrayList;
import java.util.Iterator;

public class resizingArrayQueue<Item> implements Iterable<Item> {
    /** 记录定长数组的长度上限 **/
    private int max_size;
    /** 定长数组，用于存储入队的泛型对象 **/
    private Item[] items;
    /** 队列顶部指针，指向队列顶部第一个元素 **/
    private int top = 0;
    /** 队列尾部指针，指向队列尾部最后一个元素后一格的位置 **/
    private int tail;

    /**
     * 构造函数，当参数列表为空时调用（使泛型定长数组长度上限为默认值10）
     * **/
    public resizingArrayQueue(){
        this.tail = 0;
        this.max_size = 10;
        this.items = this.newItemArray(10);
    }

    /**
     * 构造函数，当参数列表传入一个整型时调用，用于指定构造的队列的数组长度上限（保证不小于10）
     * @param max_size int: 指定构造的队列的数组长度上限
     * **/
    public resizingArrayQueue(int max_size){
        this.tail = 0;
        this.max_size = Math.max(max_size, 10);
        this.items = this.newItemArray(this.max_size);
    }

    /**
     * 构造函数，当参数列表传入{@code ArrayList<Item>}类型容器时调用，将传入容器转换成本容器
     * @param arr ArrayList<Item>: 传入的容器
     * **/
    public resizingArrayQueue(ArrayList<Item> arr){
        this.tail = arr.size();
        this.max_size = Math.max(arr.size() * 2, 10);
        this.items = this.newItemArray(this.max_size);
        for (int i = 0; i < arr.size(); i += 1){
            this.items[i] = arr.get(i);
        }
    }

    /**
     * 构造一个新的泛型定长数组，利用多态强制转换类型（忽略编译器警告）
     * @param max_size int: 指定构造的数组的长度
     *
     * @return Item[]: 返回新的泛型定长数组
     * **/
    @SuppressWarnings("unchecked")
    private Item[] newItemArray(int max_size){
        return (Item[]) new Object[max_size];
    }

    /**
     * 当触发需要改变长度的方法时构造新的长度的泛型定长数组，触发条件见：
     * @see resizingArrayQueue#isSpecStat()
     * **/
    private void resize(){
        if (this.isSpecStat()){
            if (this.isEmpty() || this.isTooSmall()){
                this.max_size = this.max_size >= 20 ? this.max_size / 2 : 10;
            }else if(this.isFull()){
                this.max_size *= 2;
            }
            this.copyItems(this.newItemArray(this.max_size));
            int size = this.size();
            this.top = 0;
            this.tail = size;
        }
    }

    /**
     * 拷贝数组内的元素到新数组中
     * @param new_items Item[]: 新数组
     * **/
    private void copyItems(Item[] new_items){
        int cnt = -1;
        for (Item i: this){
            new_items[cnt += 1] = i;
        }
        this.items = new_items;
    }

    /**
     * 判断队列的长度是否小于等于数组最大长度的四分之一
     * @return boolean: 返回是/否
     * **/
    private boolean isTooSmall(){
        return this.size() <= this.max_size / 4;
    }

    /**
     * 判断队列是否已满
     * @return boolean: 返回是/否
     * **/
    private boolean isFull(){
        return this.tail == this.max_size && this.top == 0;
    }

    /**
     * 判断队列是否为空
     * @return boolean: 返回是/否
     * **/
    private boolean isEmpty(){
        return this.size() == 0;
    }

    /**
     * 判断队列尾部指针是否处于越界的临界点（或已越界）
     * @return boolean: 返回是/否
     * **/
    private boolean willOutOfRightBound(){
        return this.tail >= this.max_size;
    }

    /**
     * 数组状态是否处于特殊状态
     * @see resizingArrayQueue#isTooSmall()
     * @see resizingArrayQueue#isFull()
     * @see resizingArrayQueue#isEmpty()
     * @see resizingArrayQueue#willOutOfRightBound()
     *
     * @return boolean: 返回是/否
     * **/
    private boolean isSpecStat(){
        return this.isTooSmall() || this.isFull() || this.isEmpty() || this.willOutOfRightBound();
    }

    /**
     * 将一个元素入队（插入到队尾）
     * @param item Item: 待插入的元素
     * **/
    public void push(Item item){
        this.resize();
        this.items[this.tail] = item;
        this.tail += 1;
    }

    /**
     * 将一个元素出队（从队首弹出）
     * @return Item: 出队的元素
     * **/
    public Item pop(){
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException("Empty queue");
        }
        this.resize();
        Item p = this.items[this.top];
        this.items[this.top] = null;
        this.top += 1;
        return p;
    }

    /**
     * 返回一个迭代器，以支持For-each遍历操作
     * @return Iterator<Item>: 返回迭代器，实现细节见：
     * @see arrayIterator
     * **/
    @Override
    public Iterator<Item> iterator() {
        return new arrayIterator();
    }

    /**
     * 嵌套在本类里的迭代器类
     * @implSpec 实现了 {@code hasNext()} 和 {@code next()}方法
     * **/
    private class arrayIterator implements Iterator<Item> {
        /** 当前遍历的指针，指向要访问的元素 **/
        private int cur = top;

        /**
         * 重写了方法，当指针小于队尾指针时即可继续遍历
         * @return boolean: 返回是/否
         * **/
        @Override
        public boolean hasNext() {
            return this.cur < tail;
        }

        /**
         * 重写了方法，返回当前指向的元素，并将指针向队尾移动一格
         * @return Item: 返回的元素
         * **/
        @Override
        public Item next() {
            Item i = items[this.cur];
            this.cur += 1;
            return i;
        }

        /**
         * 此方法选择不实现，如果调用将抛出异常
         * @throws UnsupportedOperationException: 抛出异常，因为方法本身并不被支持使用
         * **/
        @Override
        public void remove() {
            // 不实现
            throw new UnsupportedOperationException("method remove() is unsupported");
        }
    }

    /**
     * 队列的字符串表现形式
     * @return String: 返回队列的字符串表现形式
     * **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Item i: this){
            sb.append(i.toString()).append(", ");
        }
        String ss = sb.toString();
        if (!this.isEmpty()){
            ss = ss.substring(0, ss.length() - 2);
        }
        return "[" + ss + "]";
    }

    /**
     * 返回当前队列的长度
     * @return int: 当前队列的长度
     * **/
    public int size() {
        return this.tail - this.top;
    }
}
