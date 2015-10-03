package binarytree;

import java.util.*;

public class postorderinorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        if(len == 0) return null;
        return buildSubTree(postorder, inorder, 0, 0, len);
    }
    
    TreeNode buildSubTree(int[] postorder, int[] inorder, int start1, int start2, int length){
        if(length <= 0) return null;
        if(start1 + length > postorder.length || start2 + length > postorder.length) return null;
        if(length == 1) return new TreeNode(postorder[start1 + length - 1]);
        TreeNode rt = new TreeNode(postorder[start1 + length - 1]);
        int i = 0;
        for(i = 0; i < length; i++){
        	if(inorder[i + start2] == postorder[start1 + length - 1]){
        		break;
        	}
        }
        rt.left = buildSubTree(postorder, inorder, start1, start2, i);
        rt.right = buildSubTree(postorder, inorder, start1 + i, start2 + i + 1, length - i - 1);
        return rt;
    }
    
	public class TreeNode {
    	int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		public String toString(){
			StringBuffer sbuf = new StringBuffer();
			sbuf.append("[");
			Queue<TreeNode> q1 = new LinkedList<TreeNode>();
			Queue<TreeNode> q2 = new LinkedList<TreeNode>();
			q1.offer(this);
			while(!q1.isEmpty() || !q2.isEmpty()){
				if(q1.isEmpty()){
					q1.addAll(q2);
					q2.clear();
				}else{
					TreeNode cur = q1.poll();
					if(cur == null){
						sbuf.append("null ");
					}else{
						sbuf.append(cur.val + " ");
						q2.offer(cur.left);
						q2.offer(cur.right);
					}
				}
				
			}
			sbuf.deleteCharAt(sbuf.length() - 1);
			sbuf.append("]");
			return sbuf.toString();
		}
	}
	
	public static void main(String[] args){
		postorderinorder sln = new postorderinorder();
		int[] postorder = {3, 2, 1, 4};
		int[] inorder = {1, 2, 3, 4};
		TreeNode rt = sln.buildTree(postorder, inorder);
		System.out.println(rt);

	}
}
