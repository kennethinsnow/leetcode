package longestpalindrom;

public class solution2 {
    public String longestPalindrome(String s) {
    	if(s == null || s == "") return "";
    	if(s.length() == 1) return s;
    	int start = 0, max_len = 1, len = s.length();
        for (int i = 0; i < s.length();){
        	if ((len - i) <= max_len/2) break;
        	int j = i, k = i;
        	while (k < len - 1 && s.charAt(k) == s.charAt(k + 1)) k++; // skip duplicate char
        	i = k + 1;
        	while (k < len - 1 && j > 0 && s.charAt(j - 1) == s.charAt(k + 1)){
        		k++;
        		j--;
        	}
        	
        	int new_len = k - j + 1;
        	if (new_len > max_len){
        		max_len = new_len; 
        		start = j;
        	}
        }
    	return s.substring(start, start + max_len);
    }
}
