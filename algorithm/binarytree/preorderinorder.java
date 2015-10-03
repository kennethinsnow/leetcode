package binarytree;

import java.util.*;

public class preorderinorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if(len == 0) return null;
        return buildSubTree(preorder, inorder, 0, 0, len);
    }
    
    TreeNode buildSubTree(int[] preorder, int[] inorder, int start1, int start2, int length){
        if(length <= 0) return null;
        if(start1 + length > preorder.length || start2 + length > preorder.length) return null;
        if(length == 1) return new TreeNode(preorder[start1]);
        TreeNode rt = new TreeNode(preorder[start1]);
        int i = 0, j = 0;
        int leftLen = 0, rightLen = 0;
        for(i = 0; i < length; i++){
        	if(inorder[i + start2] == preorder[start1]){
        		break;
        	}
        }

    	leftLen = i;
    	rightLen = length - leftLen - 1;
        rt.left = buildSubTree(preorder, inorder, start1 + 1, start2, leftLen);
        rt.right = buildSubTree(preorder, inorder, start1 + leftLen + 1, start2 + i + 1, rightLen);
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
		preorderinorder sln = new preorderinorder();
		int[] preorder = {3, 2, 1, 4};
		int[] inorder = {1, 2, 3, 4};
		TreeNode rt = sln.buildTree(preorder, inorder);
		System.out.println(rt);

	}
}
