package leetcode.graph;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @autor yud1
 * @date 2023/6/12 07:40
 */
public class Prim {

    private List<int[]>[] graph;

    private PriorityQueue<int[]> pq;

    private boolean[] visited;

    private int weight;

    public Prim(List<int[]>[] graph){
        this.graph = graph;
        pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int n = graph.length;
        visited = new boolean[n];
        visited[0] = true;
        cut(0);
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int to = edge[1];
            if (visited[to]){
                continue;
            }
            weight += edge[2];
            visited[to] =true;
            cut(to);
        }
    }

    private void cut(int v){
        List<int[]> edges = graph[v];
        for (int[] edge: edges) {
            int to = edge[1];
            if (visited[to]){
                continue;
            }
            pq.offer(edge);
        }
    }

    public int weightSum(){
        return weight;
    }

    // 判断最小生成树是否包含图中的所有节点
    public boolean allConnected() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

}
