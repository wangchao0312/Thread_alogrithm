package WeightedGraph;


import Graph.Graph;


import java.util.ArrayList;
public class DenseWeightedGraph <Weight extends Number& Comparable>implements WeightedGraph {
    //稠密图 邻接矩阵形式描述
    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;
    private Edge<Weight>[][] g;
    public DenseWeightedGraph(int n,boolean directed){
        assert n>=0;
        this.n=n;
        m=0;
        this.directed=directed;
        g=new Edge[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                g[i][j]=null;
            }
        }


    }
    public int V(){ return n;} // 返回节点个数
    public int E(){ return m;} // 返回边的个数

    public void addEdge(Edge edge){
        assert edge.v()>0&&edge.v()<n;
        assert edge.w()>0&&edge.w()<n;
        if(hasEdge(edge.v(),edge.w()))
            return ;
        g[edge.v()][edge.w()]=new Edge<Weight>(edge);
        if(!directed)
            g[edge.w()][edge.v()]=new Edge<Weight>(edge.w(),edge.v(), (Weight) edge.wt());
        m++;
    }
    public boolean hasEdge(int v,int w){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        return g[v][w]!=null;
    }
    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }
    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Edge<Weight>> adj(int v){
        assert v >= 0 && v < n;
        ArrayList<Edge<Weight>> adjV=new ArrayList<>();
        for(int i=0;i<g[v].length;i++)
        {
            if(g[v][i]!=null)
                adjV.add(g[v][i]);
        }
        return adjV;
    }

}
