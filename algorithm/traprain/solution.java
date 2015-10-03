package traprain;

import java.util.Arrays;

public class solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        
        if(slen == 0 && plen == 0){
        	return true;
        }else if (slen == 0){
        	if(plen >=2 && p.charAt(1) == '*'){
        		return isMatch(s, p.substring(2, plen));
        	}
        	return false;
        }else if (plen == 0){
        	return false;
        }
        
        if(plen == 1){
        	if (p.equals("*")){
        		return false;
        	}else if (p.equals(".") && slen == 1){
        		return true;
        	}else if (p.equals(s)){
        		return true;
        	}else{
        		return false;
        	}
        }
        
        // plen >= 2

    	if (p.charAt(0) == '.' && p.charAt(1) == '*'){
    		if(plen == 2){
    			return true;
    		}
    		for(int j = 0; j <= slen; j++){
        		if (isMatch(s.substring(j, slen), p.substring(2, plen))){
        			return true;
        		}
    		}
    		return false;
    	}else if (p.charAt(1) == '*'){
    		if (plen == 2){
    			int i = 0;
    			while (i < slen && s.charAt(i) == p.charAt(0)){
    				i++;
    			}
    			if (i == slen){
    				return true;
    			}else{
    				return false;
    			}
    		}
    		// 0 occurrence 
    		if (isMatch(s.substring(0, slen), p.substring(2, plen))){
    			return true;
    		}

    		for(int j = 0; j < slen && s.charAt(j) == p.charAt(0); j++){
        		if (isMatch(s.substring(j + 1, slen), p.substring(2, plen))){
        			return true;
        		}
    		}
    		return false;
    	}else if (p.charAt(0) == '.'){
    		return isMatch(s.substring(1, slen), p.substring(1, plen));
    	}else{
    		if(p.charAt(0) == s.charAt(0)){
    			return isMatch(s.substring(1, slen), p.substring(1, plen));
    		}else{
    			return false;
    		}
    	}
    }
}
