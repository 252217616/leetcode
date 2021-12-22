package nowcoder.questions.one;

/**
 * NC88_寻找第K大
 * <p>
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第 k 大的数。
 * <p>
 * 给定一个整数数组 a ,同时给定它的大小n和要找的 k ，请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。
 * 要求：时间复杂度 O(nlogn)O(nlogn)，空间复杂度 O(1)O(1)
 *
 * @author lujun
 * @date 2021/12/22
 */
public class NC88_寻找第K大 {

    public static void main(String[] args) {
        final int kth = findKth(new int[]{1, 3, 5, 2, 2}, 5, 3);
        System.out.println(1);
    }

    public static int findKth(int[] a, int n, int K) {
        // write code here
        return topK(a, 0, a.length - 1, K);
    }

    public static int topK(int[] arr, int left, int right, int k) {
        if (left > right) {
            return -1;
        }
        final int point = partition(arr, left, right);
        //后半部分还剩几个
        int surplus = right - point  + 1;
        if(surplus == k){
            return arr[point];
        }else if(surplus < k ){
            //在前半部分 因为大数在后面，所以要找 第 k-surplus 个最大
            return topK(arr,left,point-1,k -surplus);
        }else {
            return topK(arr,point+1,right,k);
        }

    }

    public static int partition(int[] arr, int left, int right) {
        int first = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= first) {
                right--;
            }
            swap(arr, left, right);
            while (left < right && arr[left] <= first) {
                left++;
            }
            swap(arr, left, right);
        }
        return left;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}