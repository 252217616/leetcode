package nowcoder.questions.one;

/**
 * NC19_连续子数组的最大和
 *
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 输入：[1,-2,3,10,-4,7,2,-5]
 * 返回值：18
 * 说明：经分析可知，输入数组的子数组[3,10,-4,7,2]可以求得最大和为18
 *
 * @author lujun
 * @date 2021/12/28
 */
public class NC19_连续子数组的最大和 {

    public static void main(String[] args) {
        FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5});
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length ;
        int[] dp = new int[len];
        dp[0] = array[0];
        int result = array[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(array[i],dp[i-1]+array[i]);
            result = Math.max(dp[i],result);
        }
        return result;

    }
}