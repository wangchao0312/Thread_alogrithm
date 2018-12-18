package Sword;

public class EntryNodeOfloop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null)
            return null;
        if(pHead.next==null)
            return null;
        int num=judgeLoop(pHead);
        if(num==-1)
            return null;
        ListNode p1=pHead;
        ListNode p2=pHead;
        for(int i=1;i<=num;i++){
            p1=p1.next;
        }
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
    //判断链表中是否有环 并返回环中结点个数。。。如果没有环返回-1。。。
    public int judgeLoop(ListNode listnode){
        int flag=-1;
        ListNode p1=listnode;
        ListNode p2=listnode;
        while(p2!=null&&p1!=null&&p1.next!=null&&p1.next.next!=null)
        {
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2)
            {
                flag=0;
                while(true)
                {
                    p1=p1.next;
                    flag++;
                    if(p1==p2)
                        return flag;
                }
            }
        }
        return -1;
    }
}
