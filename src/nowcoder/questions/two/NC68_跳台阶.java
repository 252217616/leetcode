package nowcoder.questions.two;

/**
 * NC68_跳台阶
 * <p>
 * 描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * <p>
 * 数据范围：0 \leq n \leq 400≤n≤40
 * 要求：时间复杂度：O(n)O(n) ，空间复杂度： O(1)O(1)
 *
 * @author lujun
 * @date 2021/12/17
 */
public class NC68_跳台阶 {

    public static void main(String[] args) {
        final int i = jumpFloor(7);
        System.out.println(i);
    }

    public static int jumpFloor(int target) {
        int result = 0;
        int pre = 1;
        int next = 2;
        for (int i = 3;i<=target;i++){
            result = pre+next;
            pre = next;
            next = result;
        }
        return target > 2?result:target;
    }
}