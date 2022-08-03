package nowcoder.questions.链表;

import nowcoder.entity.ListNode;
import nowcoder.utils.NCoderUtils;

/**
 * BM16_删除有序链表中重复的元素II
 *
 * @author lujun
 * @date 2022/5/12
 */
public class BM16_删除有序链表中重复的元素II {
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
        //空链表
        if(head == null)
            return null;
        ListNode res = new ListNode(0);
        //在链表前加一个表头
        res.next = head;
        ListNode cur = res;
        while(cur.next != null && cur.next.next != null){
            //遇到相邻两个节点值相同
            if(cur.next.val == cur.next.next.val){
                int temp = cur.next.val;
                //将所有相同的都跳过
                while (cur.next != null && cur.next.val == temp)
                    cur.next = cur.next.next;
            }
            else
                cur = cur.next;
        }
        //返回时去掉表头
        return res.next;
    }
}