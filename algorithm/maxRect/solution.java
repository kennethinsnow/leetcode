package maxRect;

import java.util.Stack;

public class solution {
    public int maximalRectangle(char[][] matrix) {
        int h = matrix.length;
        if(h == 0) return 0;
        int w = matrix[0].length;
        if (w == 0) return 0;
        Stack<Integer> st = new Stack();
        int maxArea = 0;
        int tmpH = 0;
        int[] rowHgt = new int[w + 1];
        for (int i = 0; i < h; i++){
            for (int j = 0; j <= w; j++){
                if(j == w) rowHgt[j] = 0;
                else if (matrix[i][j] == '1') rowHgt[j] += 1;
                else rowHgt[j] = 0;
                while(!st.isEmpty() && rowHgt[st.peek()] > rowHgt[j]){
                    int area = 0;
                    tmpH = rowHgt[st.pop()];
                    if(st.isEmpty()) area = tmpH * j;
                    else area = tmpH * (j - st.peek() -1);
                    if (area > maxArea) maxArea = area;
                }
                st.add(j);
            }
            st.removeAllElements();
        }
        return maxArea;
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	String[] ipt = {"0010","1111","1111","1110","1100","1111","1110"};
    	char[][] input = new char[ipt.length][ipt[0].length()];
    	for(int i = 0; i < ipt.length; i++){
    		input[i] = ipt[i].toCharArray();
    	}
    	System.out.println(sln.maximalRectangle(input));
    }
}
