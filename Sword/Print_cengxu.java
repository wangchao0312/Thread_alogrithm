package Sword;
import java.util.ArrayList;
import java.util.LinkedList;

public class Print_cengxu {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot==null)
            return new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> array=new LinkedList<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> integer=new ArrayList<>();
        array.add(pRoot);
        int start=0;int end=1;
        while(!array.isEmpty()){

            TreeNode temp=array.remove();
            integer.add(temp.val);
            start++;
            if(temp.left!=null)
                array.add(temp.left);
            if(temp.right!=null)
                array.add(temp.right);
            if(start==end)
            {
                start=0;
                end=array.size();
                result.add(integer);
                integer=new ArrayList<Integer>();
            }
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode node=new TreeNode(8);
        node.left=new TreeNode(10);
        node.right=new TreeNode(6);
        node.left.left=new TreeNode(5);
        node.left.right=new TreeNode(7);
        node.right.left=new TreeNode(9);
        node.right.right=new TreeNode(11);
        Print(node);
    }

}
