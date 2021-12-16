package nowcoder.utils;

import nowcoder.entity.ListNode;

/**
 * NCoderUtils
 *
 * @author lujun
 * @date 2021/12/16
 */
public class NCoderUtils {

    public static ListNode buildListNode(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode result = head;
        for (int i = 1; i < nums.length; i++) {
            head.next = new ListNode(nums[i]);
            head = head.next;
        }
        return result;
    }
}