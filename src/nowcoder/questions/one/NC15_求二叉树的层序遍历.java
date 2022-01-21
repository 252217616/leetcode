package nowcoder.questions.one;

import nowcoder.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * NC15_求二叉树的层序遍历
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 *
 * 输入：
 * {1,2,3,4,#,#,5}
 * 返回值：
 * [[1],[2,3],[4,5]]
 * @author lujun
 * @date 2021/12/22
 */
public class NC15_求二叉树的层序遍历 {
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        //记录层序的结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        //用队列保存这一层的数据
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            //开始循环前 队列里的数据就是前一层的节点
            int len = queue.size();
            ArrayList<Integer> levelNums = new ArrayList<>();
            //把前一层的节点取出来，放入的是第二层的节点
            for (int i = 0; i < len; i++) {
                final TreeNode cur = queue.poll();
                levelNums.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            result.add(levelNums);

        }
        return result;
    }
}