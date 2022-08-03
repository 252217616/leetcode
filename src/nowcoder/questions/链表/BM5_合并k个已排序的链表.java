package nowcoder.questions.链表;

import nowcoder.entity.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * BM5_合并k个已排序的链表
 *
 * @author lujun
 * @date 2022/5/11
 */
public class BM5_合并k个已排序的链表 {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), (o1, o2) -> {
            if (o1.val < o2.val)
                return -1;
            else if (o1.val == o2.val)
                return 0;
            else
                return 1;
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}