package nowcoder.questions.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * NC119_最小的K个数
 *
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
 * 要求：空间复杂度 O(n) ，时间复杂度 O(nlogn)
 * @author lujun
 * @date 2021/12/22
 */
public class NC119_最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k == 0){
            return new ArrayList<Integer>();
        }
        Queue<Integer> queue = new PriorityQueue<>(k,(o1,o2)-> o2-o1);
        for (int i : input) {
            if (queue.size() < k) {
                queue.offer(i);
            } else {
                if (queue.peek() > i) {
                    queue.poll();
                    queue.offer(i);
                }
            }
        }
        return new ArrayList<>(queue);
    }
}