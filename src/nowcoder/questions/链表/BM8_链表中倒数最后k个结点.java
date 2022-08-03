package nowcoder.questions.链表;

import nowcoder.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BM8_链表中倒数最后k个结点
 *
 * @author lujun
 * @date 2022/5/10
 */
public class BM8_链表中倒数最后k个结点 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        List<ListNode> nodeList = new ArrayList<>();
        while (pHead!=null){
            nodeList.add(pHead);
            pHead = pHead.next;
        }
        final int size = nodeList.size();
        if(size<k){
            return new ListNode(0);
        }
        return nodeList.get(size-k);
    }

    /**
     * 快慢指针
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail2 (ListNode pHead, int k) {
        // write code here
        ListNode first  = pHead;
        ListNode slow  = pHead;
        for (int i = 0; i < k; i++) {
            if(first == null){
                return null;
            }
            first = first.next;
        }
        while (first.next!=null){
            slow = slow.next;
            first = first.next;
        }
        return slow;
    }
}