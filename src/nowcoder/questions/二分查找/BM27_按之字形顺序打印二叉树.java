package nowcoder.questions.二分查找;

import nowcoder.entity.TreeNode;

import java.util.*;

/**
 * BM27_按之字形顺序打印二叉树
 *
 * @author lujun
 * @date 2022/5/16
 */
public class BM27_按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(pRoot);

        while (!queue.isEmpty()) {
            int size = queue.size();

            ArrayList<Integer> curVal = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode cur = queue.poll();
                curVal.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            result.add(curVal);
        }
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }


}