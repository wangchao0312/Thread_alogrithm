package Sword;

public class TwoListNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode temp1=pHead1;
        ListNode temp2=pHead2;
        int sum1=0;
        int sum2=0;
        int chazhi;
        //将temp1与temp2长度统计
        while(temp1!=null)
        {
            temp1=temp1.next;
            sum1++;
        }
        while(temp2!=null)
        {
            temp2=temp2.next;
            sum2++;
        }
        temp1=pHead1;
        temp2=pHead2;
        //将其变成一样长
        if(sum1>sum2)
        {
            for(int i=1;i<=sum1-sum2;i++)
                temp1=temp1.next;
        }
        else
        {
            for(int i=1;i<=sum2-sum1;i++)
                temp2=temp2.next;
        }
        //统计二者第一个相同节点的位置
        while(temp1!=null)
        {
            if(temp1==temp2)
                return temp1;

            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }
}
