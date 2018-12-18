package Sword;

public class deleteReaptedNum {
    //链表定义
    public class ListNode{
        int val;
        ListNode next=null;
        public ListNode(int val){
            this.val=val;
        }
    }
    //删除链表中重复节点！！返回头指针！！
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null||pHead.next==null)
            return pHead;

        if(pHead.val==pHead.next.val)
        {
            ListNode temp=pHead.next;
            while(temp!=null&&temp.val==pHead.val)
                temp=temp.next;
            return deleteDuplication(temp);
        }
        else
        {
            pHead.next=deleteDuplication(pHead.next);
            return pHead;
        }

    }
}
