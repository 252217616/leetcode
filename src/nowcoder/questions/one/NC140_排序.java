package nowcoder.questions.one;

/**
 * NC140_排序
 * <p>
 * 描述
 * 给定一个长度为 n 的数组，请你编写一个函数，返回该数组按升序排序后的结果。
 * 要求：时间复杂度 O(nlogn)O(nlogn)，空间复杂度 O(n)O(n)
 *
 * @author lujun
 * @date 2021/12/20
 */
public class NC140_排序 {

    public static void main(String[] args) {
        MySort(new int[]{1,4,6,2,4,7,9,3,1});
    }


    public static int[] MySort(int[] arr) {
        // write code here
        sort(arr,0,arr.length-1);
        return arr;
    }

    private static void sort(int[] arr, int left, int right){
        if(left<right){
            final int index = quickSort(arr, left, right);
            sort(arr,left,index-1);
            sort(arr,index+1,right);
        }

    }

    private static int quickSort(int[] arr, int left, int right) {
        int first = arr[left];
        while (left < right) {
            while (left<right && arr[right] >= first){
                right--;
            }
            swap(arr,left,right);
            while (left < right && arr[left]<=first){
                left++;
            }
            swap(arr,left,right);
        }
        return left;

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}