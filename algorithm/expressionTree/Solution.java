package expressionTree;

import java.util.*;


public class Solution {
	
	public class ExpressionTreeNode {
		public String symbol;
		public ExpressionTreeNode left, right;
		public ExpressionTreeNode(String symbol) {
		    this.symbol = symbol;
		    this.left = this.right = null;
		}
	}
	
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        int len = expression.length;
        if (len <= 0) return null;
        Stack<String> opor = new Stack();
        Stack<ExpressionTreeNode> opd = new Stack();
        for (int i = 0; i < len; i++){
            String cur = expression[i];
            if (cur.equals("+") || cur.equals("-")){
                while (!opor.isEmpty()){
                    String pre = opor.peek();
                    if (!pre.equals("(")){
                        ExpressionTreeNode newOp = new ExpressionTreeNode(opor.pop());
                        newOp.right = opd.pop();
                        newOp.left = opd.pop();
                        opd.push(newOp);
                    } else break;
                }
                opor.push(cur);
            } else if (cur.equals("*") || cur.equals("/")){
                while (!opor.isEmpty()){
                    String pre = opor.peek();
                    if (pre.equals("*") || pre.equals("/")){
                        ExpressionTreeNode newOp = new ExpressionTreeNode(opor.pop());
                        newOp.right = opd.pop();
                        newOp.left = opd.pop();
                        opd.push(newOp);
                    } else break;
                }
                opor.push(cur);
            } else if (cur.equals(")")){
                while (!opor.isEmpty()){
                    String pre = opor.peek();
                    if (!pre.equals("(")){
                        ExpressionTreeNode newOp = new ExpressionTreeNode(opor.pop());
                        newOp.right = opd.pop();
                        newOp.left = opd.pop();
                        opd.push(newOp);
                    } else {
                        opor.pop();
                        break;
                    }
                }
            } else if (cur.equals("(")){
                opor.push(cur);
            } else {
                opd.push(new ExpressionTreeNode(cur));
            }
        }
        while (!opor.isEmpty()){
        	ExpressionTreeNode newOp = new ExpressionTreeNode(opor.pop());
            newOp.right = opd.pop();
            newOp.left = opd.pop();
            opd.push(newOp);
        }
        return opd.isEmpty() ? new ExpressionTreeNode("") : opd.pop();
    }
    public static void main(String[] args){
    	Solution sln = new Solution();
    	String[] input = {"(","(","(","(","(",")",")",")",")",")"};
    	// String[] input = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
    	ExpressionTreeNode ret = sln.build(input);
    	Queue<ExpressionTreeNode> traQue = new LinkedList();
    	traQue.offer(ret);
    	System.out.print("[ ");
    	while(!traQue.isEmpty()){
    		int len = traQue.size();
    		for(int i = 0; i < len; i++){
    			ExpressionTreeNode cur = traQue.poll();
    			System.out.print(cur.symbol + " ");
    			if(cur.left != null) traQue.offer(cur.left);
    			if(cur.right != null) traQue.offer(cur.right);
    		}
    	}
    	System.out.print("]");
    }
}
