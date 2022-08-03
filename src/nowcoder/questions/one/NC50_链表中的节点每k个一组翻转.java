package nowcoder.questions.one;

import nowcoder.entity.ListNode;
import nowcoder.utils.NCoderUtils;

/**
 * NC50_链表中的节点每k个一组翻转
 *
 * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 *
 * 给定的链表是 1\to2\to3\to4\to51→2→3→4→5
 * 对于 k = 2k=2 , 你应该返回 2→1→4→3→5
 * 对于 k = 3k=3 , 你应该返回 3→2→1→4→5
 * @author lujun
 * @date 2021/12/24
 */
public class NC50_链表中的节点每k个一组翻转 {
    public static void main(String[] args) {
        final ListNode listNode = reverseKGroup(NCoderUtils.buildListNode(new int[]{1, 2, 3, 4, 5}), 3);
        System.out.println();
    }

    public static ListNode reverseKGroup (ListNode head, int k) {
      ListNode cur = head;
      //找到要反转得区间
        int count = 0;
        while (cur != null && count != k){
            cur = cur.next;
            count++;
        }
        if(count == k){
            //反转好的链表
            cur = reverseKGroup(cur,k);
            //开始反转
            while (count!=0){
                count--;
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
            }
            head = cur;
        }
        return head;
    }

    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
//    public static ListNode reverseKGroup (ListNode head, int k) {
//        // write code here
//        ListNode cur = head;
//        int count = 0;
//        // 找到待反转的第k个结点
//        while (cur != null && count != k) {
//            cur = cur.next;
//            count++;
//        }
//        if (count == k) {
//            // 递归
//            cur = reverseKGroup(cur, k);
//            // 反转列表
//            while (count != 0) {
//                count--;
//                ListNode next = head.next;
//                head.next = cur;
//                cur = head;
//                head = next;
//            }
//            // 拼接后续的链表
//            head = cur;
//        }
//        return head;
//    }


}