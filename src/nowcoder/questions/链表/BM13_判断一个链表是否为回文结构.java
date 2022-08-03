package nowcoder.questions.链表;

import nowcoder.entity.ListNode;
import nowcoder.utils.NCoderUtils;

/**
 * BM13_判断一个链表是否为回文结构
 *
 * @author lujun
 * @date 2022/5/12
 */
public class BM13_判断一个链表是否为回文结构 {
    public static void main(String[] args) {
        final ListNode listNode = NCoderUtils.buildListNode(new int[]{1, 2, 3,1});
         isPail(listNode);
        System.out.println(1);
    }
    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public static boolean isPail(ListNode head) {
        // write code here
        ListNode first = head;
        ListNode slow = head;
        while (first != null && first.next != null) {
            first = first.next.next;
            slow = slow.next;
        }
        //反转 slow
        ListNode subList = slow;
        subList = ReverseList(subList);
        //比较
        while (subList != null && head != null) {
            if (subList.val != head.val) {
                return false;
            }
            subList = subList.next;
            head = head.next;
        }
        return true;

    }

    //反转链表
    public static ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            cur = head;
            cur.next = pre;
            pre = head;
            head = next;
        }
        return cur;
    }
}