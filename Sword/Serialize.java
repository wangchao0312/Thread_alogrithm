package Sword;
public class Serialize {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
     public int index=-1;
    String Serialize(TreeNode root) {
        StringBuffer str=new StringBuffer();

        if(root==null)
        {
            str.append("#,");
            return str.toString();
        }
        str.append(root.val+",");
        str.append(Serialize(root.left));
        str.append(Serialize(root.right));

        return str.toString();
    }
    TreeNode Deserialize(String str) {
        index++;
        String[] strr=str.split(",");
        int len=str.length();
        if(index==len)
            return null;

        TreeNode node=null;
        if(!strr[index].equals("#"))
        {
            node=new TreeNode(Integer.valueOf(strr[index]));
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }
        return node;
    }

}
