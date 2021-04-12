/**
 *
 @author @FrozenLemonTee https://github.com/FrozenLemonTee
 @date 2021/04/11
 @encoding UTF-8
 **/
package DSAA.alg4.c1.quickUnion_c116;

public class quickUnion {
    private int[][][] node;
    private int[][] size;
    private int count;

    public quickUnion(int n){
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

    public int[] getParent(int[] cur){
        return this.node[cur[0]][cur[1]];
    }

    public int getSize(int[] cur){
        return this.size[cur[0]][cur[1]];
    }

    public void setParent(int[] cur, int[] parent){
        this.node[cur[0]][cur[1]] = parent;
    }

    public void addSize(int[] cur, int add){
        this.size[cur[0]][cur[1]] += add;
    }

    public boolean isChild(int[] cur){
        return this.node[cur[0]][cur[1]][0] != cur[0] || this.node[cur[0]][cur[1]][1] != cur[1];
    }

    public int[] findRoot(int[] node){
        int[] cur = node;
        while (this.isChild(cur)){
            int[] pre = this.getParent(cur);
            // todo 解决路径压缩过程中每个节点的子树的size变化
            if (this.isChild(pre)){
                this.setParent(cur, pre);
            }
            cur = pre;
        }
        return cur;
    }

    public boolean haveSameRoot(int[] node1, int[] node2){
        int[] root1 = this.findRoot(node1);
        int[] root2 = this.findRoot(node2);
        return root1[0] == root2[0] && root1[1] == root2[1];
    }

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
}
