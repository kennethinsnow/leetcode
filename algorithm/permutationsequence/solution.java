package permutationsequence;

import java.util.*;

public class solution {
    public String getPermutation(int n, int k) {
        int module = 1;
        List<Integer> nums = new ArrayList<Integer>();
        StringBuffer sbuf = new StringBuffer();
        for(int i = 1; i < n - 1; i++){
        	module *= n - i;
        }
        
        if (k > module * n) return null;
        
        k--;
        
        for(int i = 0; i < n; i++){
        	nums.add(i + 1);
        }
        
        // n > 2
        for (int i = 1; i < n; i++){
        	sbuf.append( nums.remove(k / module) );
        	k = k % module;
        	module /= n - i;
        }
        sbuf.append( nums.get(0));
        
        return sbuf.toString();
        
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	System.out.println(sln.getPermutation(2, 1));
    }
}
