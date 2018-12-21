package Graph;

import java.util.LinkedList;

public class ShortestPath {

    private Graph G;   // 图的引用
    private int s;     // 起始点
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int[] from;         // 记录路径, from[i]表示查找的路径上i的上一个节点
    private int[] ord;          // 记录路径中节点的次序。ord[i]表示i节点在路径中的次序。

    public ShortestPath(Graph graph,int s){
        G=graph;
        this.s=s;
        visited=new boolean[G.V()];
        from=new int[G.V()];
        ord=new int[G.V()];
        for(int i=0;i<G.V();i++)
        {
            ord[i]=-1;
            from[i]=-1;
            visited[i]=false;
        }
        // 无向图最短路径算法, 从s开始广度优先遍历整张图
        LinkedList<Integer> q=new LinkedList<>();
        q.push(s);
        visited[s]=true;
        ord[s]=0;
        while(!q.isEmpty())
        {
            for(int i:G.adj(s))
            {
                if(!visited[i]){
                    q.push(i);
                    visited[i]=true;
                    from[i]=s;
                    ord[i]=ord[s]+1;
                }
            }
        }
    }
    // 查询从s点到w点是否有路径
    public boolean hasPath(int w){
        assert w >= 0 && w < G.V();
        return visited[w];
    }
    // 查看从s点到w点的最短路径长度
    // 若从s到w不可达，返回-1
    public int length(int w){
        assert w >= 0 && w < G.V();
        return ord[w];
    }
}
