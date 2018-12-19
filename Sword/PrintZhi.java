package Sword;

import java.util.ArrayList;
import java.util.Stack;

public class PrintZhi {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot==null)
            return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> integer=new ArrayList<>();
        Stack<TreeNode> ji=new Stack<>();
        Stack<TreeNode> ou=new Stack<>();
        ji.push(pRoot);
        while(!ji.empty()||!ou.empty())
        {
            if(ou.isEmpty()) {
                while (!ji.isEmpty()) {
                    TreeNode temp = ji.pop();
                    integer.add(temp.val);
                    if(temp.left!=null)
                        ou.push(temp.left);
                    if(temp.right!=null)
                    ou.push(temp.right);
                }
                if(!integer.isEmpty())
                {
                    result.add(new ArrayList<>(integer));
                    integer.clear();
                }
            }
            if(ji.isEmpty()){
                while(!ou.isEmpty()) {
                    TreeNode temp = ou.pop();
                    integer.add(temp.val);
                    if(temp.right!=null)
                    ji.push(temp.right);
                    if(temp.left!=null)
                    ji.push(temp.left);
                }
                if(!integer.isEmpty()) {
                    result.add(new ArrayList<>(integer));
                    integer.clear();
                }
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
