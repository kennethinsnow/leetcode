package wildcard;

public class solution {
	int[][] L;
    public boolean isMatch(String s, String p) {
    	L = new int[s.length() + 1][p.length() + 1];
        return match(s.length(), p.length(), s, p);
        
    }
    
    boolean match(int i, int j, String s, String p){
    	if (L[i][j] != 0) return L[i][j] == 1;
    	if(i == 0 && j == 0) {
    		L[i][j] = 1;
    		return true;
    	}
    	else if (j == 0){
    		L[i][j] = -1;
    		return false;
    	}
    	else if (i == 0){
    		int k = j;
    		while (k > 0 && p.charAt(k - 1) == '*') k--;
    		if (k == 0) {
    			L[i][j] = 1;
    			return true;
    		}
    		else {
    			L[i][j] = -1;
    			return false;
    		}
    	}
    	if (p.charAt(j - 1) == '*'){
    		if ( match(i - 1, j, s, p) || match(i, j - 1, s, p)){
    			L[i][j] = 1;
    			return true;
    		}else{
    			L[i][j] = -1;
    			return false;
    		}
    	}else{
    		if( match(i - 1, j - 1, s, p) && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1))){
    			L[i][j] = 1;
    			return true;
    		}else{
    			L[i][j] = -1;
    			return false;
    		}
    	}
    }
    
    public static void main(String[] argv){
    	solution sln = new solution();
    	long startTime = System.currentTimeMillis();
    	System.out.println(sln.isMatch("abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab", "*aabb***aa**a******aa*"));
    	long estTime = System.currentTimeMillis() - startTime;
    	System.out.println("running time: " + estTime);
    }
}
