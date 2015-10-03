package flatten;

import java.util.LinkedList;
import java.util.Queue;
import binarytree.TreeNode;

public class solution {
    public void flatten(TreeNode root) {
        TreeNode pre = null;
        travesal(root, pre);
    }
    
    TreeNode travesal(TreeNode root, TreeNode pre){
        if (root == null) return pre;
        if(root.left == null & root.right == null){
            root.right = pre;
            return root;
        }
        
        pre = travesal(root.right, pre);
        pre = travesal(root.left, pre);
        root.right = pre;
        root.left = null;
        return root;
	}
	
	public static void main(String[] args){
		solution sln = new solution();
		TreeNode rt = new TreeNode(1);
		rt.left = new TreeNode(2);
		sln.flatten(rt);
		System.out.println(rt);

	}
}
