package DSAA.alg4.c1.quick_union;

import java.util.Arrays;

public class quick_union {
    int[] node;  // 每个节点和分量的具体情况
    int[] size;  // 每个节点所具有的子树的的总结点数（包括自己）
    int count;  // 连通分量的总数

    public quick_union(int num){  // 初始化
        this.node = new int[num];
        this.size = new int[this.node.length];
        this.count = num;
        for(int i=0;i<num;i++){
            this.node[i] = i;
            this.size[i] = 1;
        }
    }


    @Override  // 打印出所有节点和分量的具体情况
    public String toString() {
        return  "count = " + this.count +
                ", node = " + Arrays.toString(this.node) +
                ", size = " + Arrays.toString(this.size) ;
    }


    public int rootNode(int i){  // 找到一个节点所在的分量的根节点
        int node_pointer = i;
        while (this.node[node_pointer] != node_pointer){
            node_pointer = this.node[node_pointer];
        }
        return node_pointer;
    }


    public boolean is_equal(int i, int j){  // 判断两个节点是否在同一个分量中
        if(i >= 0 && j >= 0 && i<= this.node.length - 1 && j <= this.node.length - 1){
            return this.rootNode(i) == this.rootNode(j);
        }
        return false;
    }


    public void union(int i, int j){    //将两个连通分量合并，为了保证平衡，应当把size较小的连通分量并至size较大的上
        if(! this.is_equal(i, j)){
            int root_i = this.rootNode(i);
            int root_j = this.rootNode(j);
            if(this.size[i] < this.size[j]){
                this.node[root_i] = root_j;
                this.size[root_j] += this.size[root_i];
            }else {
                this.node[root_j] = root_i;
                this.size[root_i] += this.size[root_j];
            }
            this.count -= 1;
        }
    }
}
