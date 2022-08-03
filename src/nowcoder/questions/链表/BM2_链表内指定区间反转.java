package nowcoder.questions.链表;

import nowcoder.entity.ListNode;
import nowcoder.utils.NCoderUtils;

/**
 * BM2_链表内指定区间反转
 *
 * @author lujun
 * @date 2022/5/11
 */
public class BM2_链表内指定区间反转 {
    public static void main(String[] args) {

        final ListNode listNode = NCoderUtils.buildListNode(new int[]{1, 2, 3,4,5});
        final ListNode listNode1 = reverseBetween(listNode, 1, 3);
        System.out.println();
    }
    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        //走到要反转的前一个结点
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        //走到要反转的节点的末节点
        for(int i=0;i<n-m+1;i++){
            rightNode = rightNode.next;
        }
        //取出子链表
        ListNode subHead = pre.next;
        ListNode tail = rightNode.next;
        //切断链表
        pre.next = null;
        rightNode.next = null;
        //反转链表
        reverse(subHead);
        //接回原链表
        pre.next = rightNode;
        subHead.next = tail;
        return dummyNode.next;

    }

    /**
     * 反转链表
     * @param head
     */
    public static void reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null) {
            //Cur_next 指向cur节点的下一个节点
            ListNode Cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = Cur_next;
        }
    }
}