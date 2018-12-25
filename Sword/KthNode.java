package Sword;


import java.util.ArrayList;
import java.util.List;

public class KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {

        middle(pRoot);
        if(list.size()<k||k==0)
            return null;
        else
            return list.get(k-1);


    }
    List<TreeNode> list=new ArrayList<>();
    List<TreeNode> middle(TreeNode pRoot){
        if(pRoot==null)
            return new ArrayList<TreeNode>();

            middle(pRoot.left);
            list.add(pRoot);
            middle(pRoot.right);

            return list;
    }
}
