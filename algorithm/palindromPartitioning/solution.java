package palindromPartitioning;

import java.util.*;

public class solution {
    public int minCut(String s) {
        if (s == null || s.length() < 2 || isPar(s)) return 0;
        int len = s.length();
        int[] step = new int[len + 1];
        boolean[][] isParli = new boolean[len][len]; // is substring start at i end at j a palindrom
        ArrayList<ArrayList<Integer>> edge = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < len; i++){
            for (int j = i; j < len; j++){
                isParli[j][i] = true;
            }
        }
        for(int i = 1; i < len; i++){ // substring length - 1
            for(int j = 0; j < len - i; j++){
                int k = j + i;
                if(s.charAt(k) == s.charAt(j) && isParli[j + 1][k - 1]){
                    isParli[j][k] = true;
                }
            }
        }
        
        // initialize the edge matrix;
        for(int i = 0; i < len; i++){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            for(int j = i; j < len; j++){
                if(isParli[i][j]){
                    cur.add(j + 1);
                }
            }
            edge.add(cur);
            step[i] = i - 1;
        }
        
        step[len] = len - 1;
        
        //bfs for the shortest path from 0 to n
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.offer(0);
        while(!qu.isEmpty()){
            int l = qu.poll();
            if(l == len) return step[len];
            ArrayList<Integer> cur = edge.get(l);
            for(int j : cur){
                step[j] = Math.min(step[j], step[l] + 1);
                qu.offer(j);
            }
        }
        
        return step[len];
    }
    
    boolean isPar(String s){
        char[] cV = s.toCharArray();
        int len = cV.length;
        for(int i = 0; i < len / 2; i++){
            if(cV[i] != cV[len - i - 1]) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	String inp = "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
    	System.out.println(sln.minCut("sabcba"));
    }
}
