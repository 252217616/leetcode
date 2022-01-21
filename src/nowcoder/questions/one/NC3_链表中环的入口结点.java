package nowcoder.questions.one;

import nowcoder.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * NC3_链表中环的入口结点
 *
 * @author lujun
 * @date 2022/1/21
 */
public class NC3_链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<String> set = new HashSet<>();
        while (pHead != null && pHead.next != null){
            if(set.contains(pHead.toString())){
                return pHead;
            }
            set.add(pHead.toString());
            pHead = pHead.next;
        }
        return null;
    }
}