package nowcoder.questions.二分查找;

/**
 * BM17_二分查找I
 *
 * @author lujun
 * @date 2022/5/13
 */
public class BM17_二分查找I {

    public static void main(String[] args) {

    }

    public static int search (int[] nums, int target) {
        // write code here
        return twoSearch(0,nums.length-1,nums,target);
    }

    public static int twoSearch(int start ,int end, int[] nums,int target){
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return twoSearch(start,mid-1,nums,target);
        }else if(nums[mid]>target){
            return twoSearch(mid+1,end,nums,target);
        }
        return -1;

    }

}