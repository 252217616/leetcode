package nowcoder.questions.one;

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
        System.out.println(1);
    }

    public static int jumpFloor(int target) {
        int result = 1, n_1 = 1, n_2 = 1;
        //dp[n] = dp[n-1]+dp[n-2]
        for (int i = 2; i <= target; i++) {
            result = n_1+n_2;
            n_2 = n_1;
            n_1 = result;
        }
        return result;
    }
}