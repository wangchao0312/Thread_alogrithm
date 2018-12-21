package Graph;
import java.util.ArrayList;
public class DenseGraph implements Graph {
    //稠密图 邻接矩阵形式描述
    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;
    private boolean[][] g;
    public DenseGraph(int n,boolean directed){
        assert n>=0;
        this.n=n;
        m=0;
        this.directed=directed;
        g=new boolean[n][n];
    }
    public int V(){ return n;} // 返回节点个数
    public int E(){ return m;} // 返回边的个数

    public void addEdge(int v,int w){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        if(hasEdge(v,w))
            return ;
        g[v][w]=true;
        if(!directed)
            g[w][v]=true;
        m++;
    }
    public boolean hasEdge(int v,int w){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        return g[v][w];
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
    public Iterable<Integer> adj(int v){
        assert v >= 0 && v < n;
        ArrayList<Integer> adjV=new ArrayList<>();
        for(int i=0;i<g[v].length;i++)
        {
            if(g[v][i]==true)
                adjV.add(i);
        }
        return adjV;
    }

}
