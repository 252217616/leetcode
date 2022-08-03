package nowcoder.questions.链表;

import nowcoder.entity.ListNode;
import nowcoder.utils.NCoderUtils;

/**
 * BM15_删除有序链表中重复的元素I
 *
 * @author lujun
 * @date 2022/5/12
 */
public class BM15_删除有序链表中重复的元素I {
    public static void main(String[] args) {
        final ListNode listNode = NCoderUtils.buildListNode(new int[]{1, 1, 1});
        deleteDuplicates(listNode);
    }
    /**
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}