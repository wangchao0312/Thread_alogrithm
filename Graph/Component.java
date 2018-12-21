package Graph;

public class Component {
    Graph G;                    // 图的引用
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int ccount;         // 记录联通分量个数
    private int[] id;           // 每个节点所对应的联通分量标记

    public Component(Graph graph){
        G=graph;
        visited=new boolean[G.V()];
        id=new int[G.V()];
        ccount=0;
        for(int i=0;i<G.V();i++)
        {
            visited[i]=false;
            id[i]=-1;
        }

        for(int i=0;i<G.V();i++)
        {
            if(!visited[i])
            {
                dfs(i);
            }
            ccount++;
        }
    }
    // 查询点v和点w是否联通
    boolean isConnected( int v , int w ){
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }
    // 返回图的联通分量个数
    int count(){
        return ccount;
    }

    public void dfs(int v){
        for(int i:G.adj(v))
        {
            if(!visited[i])
            {
                visited[i]=true;
                id[i]=ccount;
            }
        }
    }
}
