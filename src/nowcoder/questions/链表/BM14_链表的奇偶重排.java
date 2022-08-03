package nowcoder.questions.链表;

import nowcoder.entity.ListNode;

/**
 * BM14_链表的奇偶重排
 *
 * @author lujun
 * @date 2022/5/12
 */
public class BM14_链表的奇偶重排 {

    public ListNode oddEvenList (ListNode head) {
        // write code here
        if( head== null){
            return head;
        }
        //奇数指针
        ListNode odd = head;
        //偶数指针
        ListNode even = head.next;
        //偶数指针头
        ListNode evenHead = even;

        while (even!=null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


}