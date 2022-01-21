package nowcoder.questions.one;

import nowcoder.entity.ListNode;

/**
 * 描述
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * <p>
 * <p>
 * 数据范围：链表长度 0 \le n \le 100000≤n≤10000，链表中任意节点的值满足 |val| <= 100000∣val∣<=100000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * <p>
 * 输入分为2部分，第一部分为链表，第二部分代表是否有环，然后将组成的head头结点传入到函数里面。-1代表无环，其它的数字代表有环，这些参数解释仅仅是为了方便读者自测调试。实际在编程时读入的是链表的头节点。
 */
public class NC4_判断链表中是否有环 {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        //快指针 每次走2步
        ListNode fast = head;
        //慢指针 每次走一步
        ListNode slow = head;
        //快指针 和 下一步 不为NULL 就可以走
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //快慢指针重合说明有环
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
