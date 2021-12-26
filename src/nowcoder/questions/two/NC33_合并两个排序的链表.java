package nowcoder.questions.two;

import nowcoder.entity.ListNode;
import nowcoder.utils.NCoderUtils;

/**
 * NC33_合并两个排序的链表
 *输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * @author lujun
 * @date 2021/12/23
 */
public class NC33_合并两个排序的链表 {
    public static void main(String[] args) {
        Merge(NCoderUtils.buildListNode(new int[]{1,3,5}),NCoderUtils.buildListNode(new int[]{2,4,6}));
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        //递归
        if(list1 ==null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next =  Merge(list1.next,list2);
            return list1;
        }else {
            list2.next =  Merge(list1,list2.next);
            return list2;
        }

    }
}