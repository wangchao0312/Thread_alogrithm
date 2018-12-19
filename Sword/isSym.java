package Sword;

import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;

public class isSym {
    public  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

      boolean  isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)
            return true;

        return judge(pRoot.left,pRoot.right);
    }
    //判断以左右俩结点为根节点的子节点是否对称！！！！
     public boolean judge(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null)
            return true;
        if(t1!=null&&t2!=null)
        {
            return t1.val==t2.val&&judge(t1.left,t2.right)&&judge(t1.right,t2.left);
        }
            return false;
    }

    public static void main(String[] args){
      /*  TreeNode node=new TreeNode(0);
        node.left=new TreeNode(1);
        node.right=new TreeNode(1);
        System.out.println(isSymmetrical(node));*/

    }
}
