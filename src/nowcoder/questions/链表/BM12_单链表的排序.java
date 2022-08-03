package nowcoder.questions.链表;

import nowcoder.entity.ListNode;
import nowcoder.utils.NCoderUtils;

/**
 * BM12_单链表的排序
 *
 * @author lujun
 * @date 2022/5/11
 */
public class BM12_单链表的排序 {

    public static void main(String[] args) {
        final ListNode listNode = NCoderUtils.buildListNode(new int[]{1, 3, 2, 4, 5});
        sortInList(listNode);
    }

    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public static ListNode sortInList (ListNode head) {
        // write code here
        if(head==null||head.next==null) return head;//结点为空或只有一个结点
        return quickSort(head);
    }
    public static ListNode  quickSort(ListNode head) {//链表快排，没有交换，排序稳定
        if(head==null||head.next==null) return head;//结点为空，或者只有一个结点
        //将链表分成三段，第一段都比枢轴小，第二段等于枢轴，第三段都大于枢轴
        ListNode lhead=new ListNode(-1);//第一段的虚头结点
        ListNode mhead=new ListNode(-1);//第二段的虚头结点
        ListNode rhead=new ListNode(-1);//第三段的虚头结点
        ListNode left=lhead;//第一段的遍历指针
        ListNode mid=mhead;//第二段的遍历指针
        ListNode right=rhead;//第三段的遍历指针
        ListNode p=head;//原链表的遍历指针
        int pivot=head.val;//将第一个元素作为枢轴
        //不断划分
        while(p!=null) {
            if(p.val<pivot) {//比枢轴小，挂到第一段链表末尾
                left.next=p;
                left=left.next;
            }
            else if(p.val==pivot) {
                mid.next=p;
                mid=mid.next;
            }
            else {//比枢轴大，挂到第三段链表末尾
                right.next=p;
                right=right.next;
            }
            p=p.next;
        }
        left.next=null;//断开后面的链
        mid.next=null;//断开后面的链
        right.next=null;//断开后面的链

        //递归对第一段和第三段进行排序；因为第二段各元素相等，不用再排序
        lhead.next=quickSort(lhead.next);
        rhead.next=quickSort(rhead.next);
        left=getTail(lhead);//获取链表最后一个元素
        if(left!=null) left.next=mhead.next;//合并第一段和第二段
        mid=getTail(mhead);//获取链表最后一个元素
        if(mid!=null) mid.next=rhead.next;//合并第二段和第三段
        return lhead.next;
    }
    public static ListNode getTail(ListNode head) {//获取给定链表的最后一个结点
        if(head==null) return null;
        while(head.next!=null) {//不是最后一个结点就循环
            head=head.next;
        }
        return head;
    }
}