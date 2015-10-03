package longestsubstring;

import java.util.*;

public class LenOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if (s == null){
            return 0;
        }
        char[] cArr = s.toCharArray();
        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
        int len = 0, maxLen = 0;
        for (int i = 0; i < cArr.length; i++){
            if (!myMap.containsKey(cArr[i])){
                myMap.put(cArr[i], len + 1);
                len++;
                if (len > maxLen){
                	maxLen = len;
                }
            }else{
            	int j = myMap.get(cArr[i]);
            	HashMap<Character, Integer> tmpMap = new HashMap<Character, Integer>();
            	for (char c : myMap.keySet()){
            		if(myMap.get(c) > j){
            			tmpMap.put(c, myMap.get(c) - j);
            		}
            	}
            	myMap = tmpMap;
            	len = len - j + 1;
            	myMap.put(cArr[i], len);
            }
        }
        return maxLen;
    }
    
    public static void main(String[] args){
    	String s = "pwwkew";
    	System.out.println(new LenOfLongestSubString().lengthOfLongestSubstring(s));
    	int m = 5 / 2;
    	System.out.println(m + " 2^31: " + Math.pow(2, 31));
    }
}
