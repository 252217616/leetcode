package nowcoder.questions.one;


import nowcoder.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * NC45_实现二叉树先序_中序和后序遍历
 *
 * 描述
 * 给定一棵二叉树，分别按照二叉树先序，中序和后序打印所有的节点。
 *
 * 数据范围：0 \le n \le 10000≤n≤1000，树上每个节点的val值满足 0 \le val \le 1000≤val≤100
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 *
 * @author lujun
 * @date 2021/12/21
 */
public class NC45_实现二叉树先序_中序和后序遍历 {
    private List<Integer> preResult = new ArrayList<>();
    private List<Integer> midResult = new ArrayList<>();
    private List<Integer> postResult = new ArrayList<>();

    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        travers(root);
        final int[][] res = new int[3][preResult.size()];
        for (int i = 0; i < preResult.size(); i++) {
            res[0][i] = preResult.get(i);
            res[1][i] = midResult.get(i);
            res[2][i] = postResult.get(i);
        }
        return res;
    }

    public void travers (TreeNode node){
        if(node == null){
            return;
        }
        //pre
        preResult.add(node.val);
        travers(node.left);
        //mid
        midResult.add(node.val);
        travers(node.right);
        //post
        postResult.add(node.val);

    }

}