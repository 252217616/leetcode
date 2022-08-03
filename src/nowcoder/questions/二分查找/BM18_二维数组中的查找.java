package nowcoder.questions.二分查找;

/**
 * BM18_二维数组中的查找
 *
 * @author lujun
 * @date 2022/5/13
 */
public class BM18_二维数组中的查找 {

    public static void main(String[] args) {
        Find(5, new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        });
    }

    public static boolean Find(int target, int[][] array) {
        int r = array.length ;//行
        int l = array[0].length; //列
        int left = 0;
        int down = r-1;
        while (left<l && down>=0) {
            int cur = array[down][left];
            if (cur == target) {
                return true;
            }else if (cur < target) {
                left++;
            }else {
                down--;
            }
        }
        return false;
    }
}