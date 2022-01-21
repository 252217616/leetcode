package nowcoder.questions.one;

/**
 * NC22_合并两个有序的数组
 * <p>
 * 给出一个有序的整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组
 *
 * @author lujun
 * @date 2022/1/4
 */
public class NC22_合并两个有序的数组 {


    public static void main(String[] args) {
        merge(new int[]{4,5,6},3,new int[]{1,2,3},3);
    }

    private static int aIndex = 0;
    private static int bIndex = 0;

    public static void merge(int A[], int m, int B[], int n) {
        int[] result = new int[n + m];
        for (int i = 0; i < result.length; i++) {
            result[i] = pop(A,m, B,n);
        }
        for (int i = 0; i < result.length; i++) {
            A[i] = result[i];
        }
    }

    private static int pop(int[] a,int m, int[] b,int n) {
        if (m > aIndex && n > bIndex) {
            return a[aIndex] > b[bIndex] ? b[bIndex++] : a[aIndex++];
        }
        if (m > aIndex) {
            return a[aIndex++];
        }
        if (n > bIndex) {
            return b[bIndex++];
        }
        return -1;
    }


}