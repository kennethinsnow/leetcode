package wildcard;

public class solution3 {
    public boolean isMatch(String s, String p) {
    	int[] x = new int[p.length() + 1], y = new int[p.length() + 1];
    	if(s.length() == 0 && p.length() == 0) return true;
    	int count = 0;
    	for (int i = 0; i < p.length(); i++){
    		if(p.charAt(i) == '*') count++;
    	}
    	if(p.length() - count > s.length()) return false;
    	
    	x[0] = 1;
    	int k = 1;
    	while(k <= p.length() && p.charAt(k - 1) == '*') {
    		x[k] = 1;
    		y[k] = 1;
    		k++;
    	}
    	
    	for (int i = 1; i <= s.length(); i++){
    		for (int j = 1; j <= p.length(); j++){
    			if (p.charAt(j - 1) == '*'){
    				if(x[j] == 1 || y[j - 1] == 1){
    					y[j] = 1;
    				}
    			}else{
    				if (x[j - 1] == 1 && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1))){
    					y[j] = 1;
    				}else{
    					y[j] = 0;
    				}
    			}
    		}
    		// x = y
    		for (int j = 0; j <= p.length(); j++){
    			x[j] = y[j];
    		}
    	}
        return y[p.length()] == 1;
        
    }
    
    public static void main(String[] argv){
    	solution3 sln = new solution3();
    	long startTime = System.currentTimeMillis();
    	System.out.println(sln.isMatch("", ""));
    	long estTime = System.currentTimeMillis() - startTime;
    	System.out.println("running time: " + estTime);
    }
}
