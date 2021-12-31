package nowcoder.questions.one;

import java.util.HashMap;
import java.util.Map;

/**
 * NC41_最长无重复子数组
 *
 * 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 *
 * @author lujun
 * @date 2021/12/31
 */
public class NC41_最长无重复子数组 {

    public static void main(String[] args) {
        maxLength(new int[]{2,3,4,5,5,4,3,2,1});
    }

    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxLength (int[] arr) {
        // write code here
        //num index
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            final int cur = arr[i];
            if(map.containsKey(cur)){
                start = Math.max(map.get(cur),start);
            }
            result = Math.max(result,i-start+1);
            map.put(cur,i+1);
        }
        return result;
    }
}