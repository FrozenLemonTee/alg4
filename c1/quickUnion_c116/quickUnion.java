/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/11
 @encoding UTF-8
 **/
package DSAA.alg4.c1.quickUnion_c116;

import standard.StdOut;
import standard.StdRandom;

public class quickUnion {
    /** 二维结点矩阵，每格代表一个结点，每个结点存储一个长度为2的int[]数组，为父亲结点的坐标 **/
    private final int[][][] node;
    /** 二维子树尺寸矩阵，每格代表该结点本身连同它的子树的所有结点的数量之和 **/
    private final int[][] size;
    /** 储存当前还有多少个独立的连通分量 **/
    private int count;
    public final int global_size;

    /**
     * 构造函数，初始化并查集，矩阵大小设为 n * n
     * **/
    public quickUnion(int n){
        this.global_size = n;
        this.node = new int[n][n][2];
        this.size = new int[n][n];
        this.count = n * n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.node[i][j][0] = i;
                this.node[i][j][1] = j;
                this.size[i][j] = 1;
            }
        }
    }

    /**
     * 获得当前坐标的结点的父亲结点坐标
     * @param cur int[]: 当前结点的坐标
     *
     * @return int[]: 父亲结点的坐标
     * **/
    public int[] getParent(int[] cur){
        return this.node[cur[0]][cur[1]];
    }

    /**
     * 获得当前坐标的结点的子树尺寸
     * @param cur int[]: 当前结点的坐标
     *
     * @return int: 当前结点的子树尺寸
     * **/
    public int getSize(int[] cur){
        return this.size[cur[0]][cur[1]];
    }

    /**
     * 设置当前坐标的结点的父亲结点
     * @param cur int[]: 当前结点的坐标
     * @param parent int[]: 父亲结点的坐标
     * **/
    public void setParent(int[] cur, int[] parent){
        this.node[cur[0]][cur[1]] = parent;
    }

    /**
     * 增加当前坐标的结点的子树尺寸
     * @param cur int[]: 当前结点的坐标
     * @param add int: 尺寸增量
     * **/
    public void addSize(int[] cur, int add){
        this.size[cur[0]][cur[1]] += add;
    }

    /**
     * 判断当前坐标的结点是否是一个孩子结点
     * @param cur int[]: 当前结点的坐标
     *
     * @return boolean: 是/否
     * **/
    public boolean isChild(int[] cur){
        return this.node[cur[0]][cur[1]][0] != cur[0] || this.node[cur[0]][cur[1]][1] != cur[1];
    }

    /**
     * 找到并返回当前坐标的结点的根结点的坐标
     * @param node int[]: 当前结点的坐标
     *
     * @return int[]: 根结点的坐标
     * **/
    public int[] findRoot(int[] node){
        int[] cur = node;
        while (this.isChild(cur)){
            int[] pre = this.getParent(cur);
            // 此步骤进行路径压缩
            // todo 似乎有问题
            if (this.isChild(pre)){
                this.setParent(cur, pre);
                this.addSize(pre, - this.getSize(cur));
            }
            cur = pre;
        }
        return cur;
    }

    /**
     * 判断当前两个坐标的结点是否在同一个连通分量中
     * @param node1 itn[]: 当前结点1的坐标
     * @param node2 int[]: 当前结点2的坐标
     *
     * @return boolean: 是/否
     * **/
    public boolean haveSameRoot(int[] node1, int[] node2){
        int[] root1 = this.findRoot(node1);
        int[] root2 = this.findRoot(node2);
        return root1[0] == root2[0] && root1[1] == root2[1];
    }

    /**
     * 将两个连通分量合并
     * @param node1 itn[]: 当前结点1的坐标
     * @param node2 int[]: 当前结点2的坐标
     * **/
    public void union(int[] node1, int[] node2){
        int[] root1 = this.findRoot(node1);
        int[] root2 = this.findRoot(node2);
        if (!this.haveSameRoot(root1, root2)){
            this.count -= 1;
            if (this.getSize(root1) < this.getSize(root2)){
                this.setParent(root1, root2);
                this.addSize(root2, this.getSize(root1));
            }else {
                this.setParent(root2, root1);
                this.addSize(root1, this.getSize(root2));
            }
        }
    }

    public void show(){
        for (int i = 0; i < this.node.length; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < this.node[i].length; j++) {
                int[] cur = new int[] {i, j};
                int[] parent = this.getParent(cur);
                line.append("(").append(parent[0]).append(",").append(parent[1]).append(" -> ");
                line.append(this.getSize(cur)).append(") ");
            }
            StdOut.println(line.toString());
        }
        StdOut.println("count = " + this.count);
    }

    public static void randUnion(quickUnion q){
        int[] cur1 = {StdRandom.uniform(q.global_size), StdRandom.uniform(q.global_size)};
        int[] cur2 = {StdRandom.uniform(q.global_size), StdRandom.uniform(q.global_size)};
        StdOut.println("union: (" + cur1[0] + "," + cur1[1] + ") (" + cur2[0] + "," + cur2[1] + ")");
        q.union(cur1, cur2);
    }
}
