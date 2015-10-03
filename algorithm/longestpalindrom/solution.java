package longestpalindrom;

public class solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int tmplen = len;
        while (tmplen > 0){
        	int start = 0;
        	int end = start + tmplen - 1;
        	while (end < len){
        		if (isPalindrom(s.substring(start, end+1))){
        			return s.substring(start, end+1);
        		}
        		start++;
        		end++;
        	}
        	tmplen--;
        }
    	return "";
    }
    
    boolean isPalindrom(String s){
    	char[] cArr = s.toCharArray();
    	int i = 0, j = cArr.length - 1;
    	while (i < j){
    		if (cArr[i] != cArr[j]){
    			return false;
    		}
    		i++;
    		j--;
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	String s = "charrahcde";
    	System.out.println(sln.isPalindrom(s));
    	System.out.println(sln.longestPalindrome(s));
    }
}
