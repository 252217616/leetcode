package nowcoder.questions.one;

import nowcoder.entity.ListNode;
import nowcoder.utils.NCoderUtils;

/**
 * Nc78_反转链表
 * 描述
 * 给定一个单链表的头结点pHead，长度为n，反转该链表后，返回新链表的表头。
 * <p>
 * 数据范围： n\leq1000n≤1000
 * 要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
 * 示例1
 * 输入：{1,2,3}
 * 返回值：{3,2,1}
 *
 * @author lujun
 * @date 2021/12/16
 */
public class NC78_反转链表 {

    public static void main(String[] args) {
        final ListNode listNode = NCoderUtils.buildListNode(new int[]{1, 2, 3});
        final ListNode result = ReverseList(listNode);
        System.out.println(1);
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        // pre -> head -> next
        //1 -> 2 -> 3
        while (head!= null) {
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;

        }
        return pre;

    }
}