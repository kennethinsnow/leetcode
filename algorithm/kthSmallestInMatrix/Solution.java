package kthSmallestInMatrix;

import java.util.*;

public class Solution {
	/**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        if (m <= 0) return -1;
        int n = matrix[0].length;
        if (k < 1) return -1;
        if (m * n <= k) return matrix[m][n];
        PriorityQueue<MyNumber> mem = new PriorityQueue();
        Set<Integer> visited = new HashSet();
        mem.offer(new MyNumber(matrix[0][0], 0, 0));
        visited.add(0);
        int rank = 0;
        MyNumber cur = null;
        while (rank < k){
            cur = mem.poll();
            rank++;
            int ind = cur.x * n + cur.y;
            if (cur.x < (m - 1) && !visited.contains(ind + n)){
                mem.offer(new MyNumber(matrix[cur.x + 1][cur.y], cur.x + 1, cur.y));
                visited.add(ind + n);
            }
            if (cur.y < (n - 1) && !visited.contains(ind + 1)){
                mem.offer(new MyNumber(matrix[cur.x][cur.y + 1], cur.x, cur.y + 1));
                visited.add(ind + 1);
            }
        }
        return cur.val;
    }

    class MyNumber implements Comparable<MyNumber>{
        int val;
        int x;
        int y;
        MyNumber(int v, int x, int y){
            this.val = v;
            this.x = x;
            this.y = y;
        }
        public int compareTo(MyNumber oth){
            return this.val - oth.val;
        }
    }
    
    public static void main(String[] args){
    	Solution sln = new Solution();
    	int[][] mat = {{1,2,3,4,5}, {2,3,4,5,6}, {3,4,5,6,7}, {4,5,6,7,8}};
    	System.out.println(sln.kthSmallest(mat, 19));
    }
}
