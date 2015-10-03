package validParenthesesWDeletion;

import java.util.*;

public class Solution {
	public String getValidPair(String inp){
		int len = inp.length();
		if (len <= 0) return inp;
		char[] cInp = inp.toCharArray();
		Stack<Integer> del = new Stack();
		for (int i = 0; i < len; i++){
			if (cInp[i] == '(') del.push(i);
			else if (cInp[i] == ')'){
				if (!del.isEmpty() && cInp[del.peek()] == '(') del.pop();
				else del.push(i);
			}
		}
		Set<Integer> delSet = new HashSet(del);
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < len; i++){
			if (!delSet.contains(i)) str.append(cInp[i]);
		}
		return str.toString();
	}
	
	public static void main(String[] args){
		Solution sln = new Solution();
		System.out.println(sln.getValidPair(")()())"));
	}
}
