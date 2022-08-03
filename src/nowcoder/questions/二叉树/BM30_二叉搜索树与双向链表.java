package nowcoder.questions.二叉树;

import nowcoder.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BM30_二叉搜索树与双向链表
 *
 * @author lujun
 * @date 2022/5/20
 */
public class BM30_二叉搜索树与双向链表 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return pRootOfTree;
        }
        List<TreeNode> nodes = new ArrayList<>();
        transof(pRootOfTree,nodes);
        int len = nodes.size();
        for (int i = 0; i < len - 1; i++) {
            final TreeNode cur = nodes.get(i);
            final TreeNode next = nodes.get(i+1);
            cur.right = next;
            next.left = cur;
        }
        return nodes.get(0);
    }

    public void transof(TreeNode node, List<TreeNode> list){
        if(node == null){
            return;
        }
        transof(node.right,list);
        list.add(node);
        transof(node.left, list);
    }
}