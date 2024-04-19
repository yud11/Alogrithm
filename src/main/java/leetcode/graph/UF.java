package leetcode.graph;

/**
 * @autor yud1
 * @date 2023/6/7 10:35
 */
public class UF {

    //记录联通分量
    private int count;

    private int[] parent;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            //开始每个节点作为一个连通分量，指向自己。
            parent[i] = i;
        }
        int[][] connections;

    }


    /**
     * union
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
        if (rootq == rootp) return;
        parent[rootp] = rootq;
        count--;
    }

    public boolean connected(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
        return rootq == rootp;
    }

    public int find(int p){
        if(parent[p] != p){
            parent[p] =  find(parent[p]);
        }
        return parent[p];
    }

    public int count(){
        return count;
    }


}
