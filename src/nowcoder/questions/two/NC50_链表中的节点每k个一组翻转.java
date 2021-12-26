package nowcoder.questions.two;

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
        final ListNode listNode = reverseKGroup(NCoderUtils.buildListNode(new int[]{1, 2, 3, 4, 5}), 2);
        System.out.println();
    }

    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup (ListNode head, int k) {
        // write code here
         ListNode cur = head;
         int count = 0;
         while (count != k && cur!=null){
             count++;
             cur = cur.next;
         }
         //开始反转
        if(count == k){
            cur = reverseKGroup(cur,k);
            //反转链表
            while (cur!=null && count!=0){
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


}