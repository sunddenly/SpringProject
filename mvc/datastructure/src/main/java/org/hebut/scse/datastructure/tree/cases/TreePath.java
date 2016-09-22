package org.hebut.scse.datastructure.tree.cases;

import org.hebut.scse.datastructure.tree.TreeNode;

import java.util.ArrayList;

public class TreePath {
    ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null)
            return paths;
        path.add(root.val);
        target -= root.val;
        if(target==0&&root.right==null&&root.left==null)
            paths.add(new ArrayList<Integer>(path));
        FindPath(root.left,target);
        FindPath(root.right,target);
        path.remove(path.size()-1);
        return paths;
    }
}