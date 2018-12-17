package UnionFInd;

public class UnionFind1 {
    //rank为层数
    //parent为父亲节点
    //count为总个数
    private int[] rank;
    private int[] parent;
    private int count;
    //构造器
    public UnionFind1(int count){
        this.count=count;
        for(int i=0;i<count;i++)
        {
            rank[i]=1;
            parent[i]=i;
        }
    }
    //查找元素p的根节点！！
    public int find(int p){
        assert p>0&&p<count;
        while(parent[p]!=p)
        {
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }

    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }

    public void UnionElements(int p,int q){
        int proot=find(p);
        int qroot=find(q);

        if(proot==qroot)
            return ;
        if(rank[proot]>rank[qroot])
            parent[qroot]=proot;
        else if(rank[qroot]>rank[proot])
            parent[proot]=qroot;
        else
        {
            parent[proot]=qroot;
            rank[qroot]+=1;
        }
    }
}
