package org.hebut.scse.datastructure.tree.cases;

import org.hebut.scse.datastructure.tree.TreeNode;

public class SerializeTree {
  int index = -1;
  String Serialize(TreeNode root) {
      StringBuffer sb = new StringBuffer();
      if(root==null){
          sb.append("#,");
          return sb.toString();
      }
      sb.append(root.val+",");
      sb.append(Serialize(root.left));
      sb.append(Serialize(root.right));
      return sb.toString();
  }
    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if(index>=len)
            return null;
        String[] eles = str.split(",");
        TreeNode node = null;
        while(!eles[index].equals("#")){
            node = new TreeNode(Integer.valueOf(eles[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
  }
}