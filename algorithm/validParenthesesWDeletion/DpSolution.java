package validParenthesesWDeletion;

import java.util.*;

public class DpSolution {
	public String getValidPair(String inp){
		int len = inp.length();
		if (len <= 0) return inp;
		char[] cInp = inp.toCharArray();
		int[] v = new int[len];		// longest valid parentheses ending at current ind
		int count = 0;				// number of unmatched left parenthese
		for (int i = 0; i < len; i++){
			if (cInp[i] == '(') count++;
			else if (cInp[i] == ')'){
				if (count > 0){
					v[i] = 2 + v[i - 1];
					if (i - v[i] > 0) v[i] += v[i - v[i]];
					count--;
				}
			} else {
				if (i > 0) v[i] = v[i - 1] + 1;
				else v[i] = 1;
			}
		}
		Set<Integer> delSet = new HashSet();
		int j = len - 1;
		while (j >= 0){
			if (v[j] == 0) {
				delSet.add(j--);
			} else {
				j = j - v[j];
			}
		}
		
		
		
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < len; i++){
			if (!delSet.contains(i)) str.append(cInp[i]);
		}
		return str.toString();
	}
	
	public static void main(String[] args){
		DpSolution sln = new DpSolution();
		System.out.println(sln.getValidPair(")()())"));
		System.out.println(sln.getValidPair("(a))())"));
		System.out.println(sln.getValidPair("()((9())"));
	}
}
