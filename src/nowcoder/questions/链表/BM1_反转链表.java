package nowcoder.questions.链表;

import nowcoder.entity.ListNode;
import nowcoder.utils.NCoderUtils;

/**
 * BM1_反转链表
 *
 * @author lujun
 * @date 2022/5/10
 */
public class BM1_反转链表 {
    public static void main(String[] args) {
        final ListNode listNode = NCoderUtils.buildListNode(new int[]{1, 2, 3});
        final ListNode result = ReverseList(listNode);
        System.out.println(1);
    }
    public static ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = null;
        ListNode next = null;
        while (head!=null){
            next = head.next;
            cur = head;
            cur.next = pre;
            pre = head;
            head = next;
        }
        return cur;
    }
}