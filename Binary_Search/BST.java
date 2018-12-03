package Binary_Search;

import java.util.LinkedList;

public class BST <Key extends Comparable<Key>,Value>{
    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        public Node(Key key,Value value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
        }
        public Node(Node node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;        }
    }

    private Node root;
    private int count;  // 树种的节点个数

    // 构造函数, 默认构造一棵空二分搜索树
    public BST() {
        root = null;
        count = 0;
    }

    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }
    public void insert(Key key, Value value){
        root = insert(root, key, value);
    }


    //********************
    //* 二分搜索树的辅助函数
    //********************

    // 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
    // 返回插入新节点后的二分搜索树的根
    private Node insert(Node node, Key key, Value value){
        if(node==null)
        {
            count++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)==0)
            node.value=value;
        else if(key.compareTo(node.key)>0)
            node.right=insert(node.right,key,value);
        else
            node.left=insert(node.left,key,value);
        return node;
    }

    public boolean contain(Key key){
        return contain(root,key);
    }
    private boolean contain (Node node,Key key){

        if(node==null)
            return false;
        if(key.compareTo(node.key)==0)
            return true;
        else if(key.compareTo(node.key)>0)
            return contain(node.right,key);
        else
            return contain(node.left,key);
    }
    private Value search(Node node, Key key){

        if( node == null )
            return null;

        if( key.compareTo(node.key) == 0 )
            return node.value;
        else if( key.compareTo(node.key) < 0 )
            return search( node.left , key );
        else // key > node->key
            return search( node.right, key );
    }

    // 寻找二分搜索树的最小的键值
    public Key minimum(){
        assert count>0;
        Node minNode=minimum(root);
        return minNode.key;
    }
    // 返回以node为根的二分搜索树的最小键值所在的节点
    private Node minimum(Node node) {
        if(node.left==null)
            return node;

        return minimum(node.left);

    }

    // 寻找二分搜索树的最大的键值
    public Key maximum(){
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }



    // 返回以node为根的二分搜索树的最大键值所在的节点
    private Node maximum(Node node){
        if( node.right == null )
            return node;

        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点
    public void removeMin(){
        if( root != null )
            root = removeMin( root );
    }
    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left==null)
        {
            Node rightNode=node.right;
            node.right=null;
            count--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }
    // 从二分搜索树中删除键值为key的节点
    public void remove(Key key){
        root = remove(root, key);
    }


    // 删除掉以node为根的二分搜索树中键值为key的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    Node remove(Node node, Key key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }
        else if (key.compareTo(node.key) < 0)
        {
            node.left = remove(node.right, key);
            return node;
        }

        else {
            if (node.left == null) {
                Node rightNode = node.right;
                count--;
                node.right = null;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                count--;
                node.left = null;
                return leftNode;
            }
            //左右节点均不为空的情况
            Node successor = new Node(minimum(node.right));
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;
            return successor;
        }
    }


    // 对以node为根的二叉搜索树进行前序遍历, 递归算法
    private void preOrder(Node node) {
        if(node!=null)
        {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    // 对以node为根的二叉搜索树进行中序遍历, 递归算法

    private void inOrder(Node node) {
        if(node!=null)
        {
            preOrder(node.left);
            System.out.println(node.value);
            preOrder(node.right);
        }
    }
    // 对以node为根的二叉搜索树进行后序遍历, 递归算法
    private void postOrder(Node node){

        if( node != null ){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }
    // 二分搜索树的层序遍历
    public void levelOrder(){
        LinkedList<Node> q=new LinkedList<>();
        q.add(root);
        while(q.size()!=0)
        {
            Node node=q.remove();
            System.out.println(node.key);

            if(node.left!=null)
            q.add(node.left);
            if(node.right!=null)
            q.add(node.right);
        }

    }
        public static void main(String[] args) {
    }

}
