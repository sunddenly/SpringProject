package org.hebut.scse.datastructure.tree.cases;

import org.hebut.scse.datastructure.tree.TreeNode;

public class SubTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val)
                result = hasTree(root1,root2);
            if(!result)
                result = HasSubtree(root1.left,root2);
            if(!result)
                result = HasSubtree(root1.right,root2);
        }
        return result;
    }
    public boolean hasTree(TreeNode root1, TreeNode root2) {
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return hasTree(root1.left,root2.left)&&hasTree(root1.right,root2.right);
    }
}