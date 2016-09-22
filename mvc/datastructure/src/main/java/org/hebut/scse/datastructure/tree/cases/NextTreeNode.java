package org.hebut.scse.datastructure.tree.cases;

import org.hebut.scse.datastructure.tree.TreeLinkNode;
import org.hebut.scse.datastructure.tree.TreeNode;

/**
 * 二叉树的下一个结点
 */
public class NextTreeNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null)
            return null;

        TreeLinkNode pNext = null;
        if(pNode.right!=null){
            TreeLinkNode pRight = pNode.right;
            while (pRight.left!=null)
                pRight = pRight.left;
            pNext = pRight;
        }else {
            TreeLinkNode p = pNode.next;
            TreeLinkNode c = pNode;
            while(p!=null&&p.right==c){
                c=p;
                p=p.next;
            }
            pNext=p;
        }
        return pNext;
    }
}