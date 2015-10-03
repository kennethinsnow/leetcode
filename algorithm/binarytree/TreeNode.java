package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
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
