package nowcoder.questions.二叉树;

import nowcoder.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BM23_二叉树的前序遍历
 *
 * @author lujun
 * @date 2022/5/16
 */
public class BM23_二叉树的前序遍历 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] preorderTraversal (TreeNode root) {
        // write code here
        List<Integer> result = new ArrayList<>();
        transfor(root,result);
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

    public void transfor(TreeNode treeNode, List<Integer> result){
        if(treeNode == null){
            return;
        }
        result.add(treeNode.val);
        transfor(treeNode.left,result);
        transfor(treeNode.right,result);
    }
}