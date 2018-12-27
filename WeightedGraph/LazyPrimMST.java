package WeightedGraph;




import java.util.ArrayList;

public class LazyPrimMST <Weight extends Number&Comparable>{

    private WeightedGraph<Weight> G;
    private MinHeap<Edge<Weight>> pq;
    private boolean[] marked;
    private ArrayList<Edge<Weight>> mst;
    private Number mstweight;

    public LazyPrimMST(WeightedGraph<Weight> graph){
        G=graph;
        pq=new MinHeap<Edge<Weight>>(G.E());
        marked=new boolean[G.V()];
        mst=new ArrayList<>();

    }
}
