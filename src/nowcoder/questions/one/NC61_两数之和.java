package nowcoder.questions.one;

import java.util.HashMap;
import java.util.Map;

/**
 * NC61_两数之和
 * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * （注：返回的数组下标从1开始算起）
 *
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(nlogn)O(nlogn)
 * 输入：
 * [3,2,4],6
 * 返回值：
 * [2,3]
 * 说明：
 * 因为 2+4=6 ，而 2的下标为2 ， 4的下标为3 ，又因为 下标2 < 下标3 ，所以返回[2,3]
 * @author lujun
 * @date 2021/12/23
 */
public class NC61_两数之和 {

    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        //key num value index
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if(map.containsKey(target-num)){
                return new int[]{map.get(target-num)+1,i+1};
            }
            map.put(num,i);
        }
        return new int[2];
    }
}