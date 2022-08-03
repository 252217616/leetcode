package nowcoder.questions.链表;

import nowcoder.entity.ListNode;

/**
 * BM9_删除链表的倒数第n个节点
 *
 * @author lujun
 * @date 2022/5/10
 */
public class BM9_删除链表的倒数第n个节点 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;
        final ListNode node1 = removeNthFromEnd(node, 2);
        System.out.println();
    }

    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public static ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}