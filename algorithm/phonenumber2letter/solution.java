package phonenumber2letter;

import java.util.*;

public class solution {
    public List<String> letterCombinations(String digits) {
        List<String> tmp = new ArrayList<String>();
        String[][] letters = {
        		{"a", "b", "c"},
        		{"d", "e", "f"},
        		{"g", "h", "i"},
        		{"j", "k", "l"},
        		{"m", "n", "o"},
        		{"p", "q", "r", "s"},
        		{"t", "u", "v"},
        		{"w", "x", "y", "z"}
        };
        
        if(digits.length() == 0){
        	return tmp;
        }
        
        String[] lt = letters[digits.charAt(0) - '2'];
        List<String> subtmp = letterCombinations(digits.substring(1, digits.length()));
        for (int i = 0; i < lt.length; i++){
        	if (subtmp == null || subtmp.size() == 0){
        		tmp.add(lt[i]);
        	}else{
	        	for (String sStr : subtmp){
	        		tmp.add(lt[i] + sStr);
	        	}
        	}
        }
        
        return tmp;
        
    }
}
