package wildcard;

public class solution2 {
    public boolean isMatch(String s, String p) {
    	int[][] L = new int[s.length() + 1][p.length() + 1];
    	L[0][0] = 1;
    	int k = 1;
    	while(k <= p.length() && p.charAt(k - 1) == '*') {
    		L[0][k] = 1;
    		k++;
    	}
    	
    	for (int i = 1; i <= s.length(); i++){
    		for (int j = 1; j <= p.length(); j++){
    			if (p.charAt(j - 1) == '*'){
    				if(L[i - 1][j] == 1 || L[i][j - 1] == 1){
    					L[i][j] = 1;
    				}
    			}else{
    				if (L[i - 1][j - 1] == 1 && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i -1 ))){
    					L[i][j] = 1;
    				}
    			}
    		}
    	}
        return L[s.length()][p.length()] == 1;
        
    }
    
    public static void main(String[] argv){
    	solution2 sln = new solution2();
    	long startTime = System.currentTimeMillis();
    	System.out.println(sln.isMatch("abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab", "*aabb***aa**a******aa*"));
    	long estTime = System.currentTimeMillis() - startTime;
    	System.out.println("running time: " + estTime);
    }
}
