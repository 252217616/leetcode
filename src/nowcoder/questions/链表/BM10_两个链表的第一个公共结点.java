package nowcoder.questions.链表;

import nowcoder.entity.ListNode;

/**
 * BM10_两个链表的第一个公共结点
 *
 * @author lujun
 * @date 2022/5/10
 */
public class BM10_两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode first = pHead1;
        ListNode second = pHead2;
        //计算第一个链表长度
        while (pHead1!=null){
            len1++;
            pHead1 = pHead1.next;
        }
        //计算第二个链表长度
        while (pHead2!=null){
            len2++;
            pHead2 = pHead2.next;
        }
        int distance = Math.abs(len1-len2);
        //长的链表走几步
        if(len1>len2){
            for (int i = 0; i < distance; i++) {
                first = first.next;
            }
        }
        if(len1<len2){
            for (int i = 0; i < distance; i++) {
                second = second.next;
            }
        }
        while (first!=null){
            if(first == second){
                return first;
            }
            first = first.next;
            second = second.next;
        }
        return null;

    }
}