package WeightedGraph;



public class Edge<Weight extends Number&Comparable> implements Comparable <Edge<Weight>> {

    private int a, b;    // 边的两个端点
    private Weight weight;  // 边的权值
    public Edge(int a, int b, Weight weight)
    {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }
    public Edge(Edge<Weight> e)
    {
        this.a = e.a;
        this.b = e.b;
        this.weight = e.weight;
    }
    public int v(){ return a;} // 返回第一个顶点
    public int w(){ return b;} // 返回第二个顶点
    public Weight wt(){ return weight;}    // 返回权值

    public int other(int x){
        assert x==a||x==b;
        return x==a?b:a;
    }
    public String toString(){
        return "" + a + "-" + b + ": " + weight;
    }

    public int compareTo(Edge<Weight> that){
        if(weight.compareTo(that.wt())<0)
            return -1;
        else if(weight.compareTo(that.wt())>0)
            return 1;
        else
            return 0;
    }


}