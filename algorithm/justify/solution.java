package justify;

import java.util.*;

public class solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<String>();
        
        int len = words.length, curLen = 0, i = 0, start = 0, end = 0;
        if(len == 0 || maxWidth == 0 || words[0].length() == 0) return ret;
        boolean lastline = false;
        
        while(i < len){
        	start = end = i;
        	curLen = words[i++].length();
        	while(i < len && curLen + 1 + words[i].length() <= maxWidth){
        		curLen += 1 + words[i].length();
        		end = i++;
        	}
        	if (i == len) lastline = true;
        	ret.add(formALine(Arrays.copyOfRange(words, start, end + 1), maxWidth, lastline));
        }
        
        return ret;
    }
    
    String formALine(String[] words, int maxWidth, boolean last){
    	StringBuffer sbuf = new StringBuffer();
    	int len = 0;
    	int spaceSize = 0, extraSpace = 0;
    	if(last){
    		sbuf.append(words[0]);
	    	for(int i = 1; i < words.length; i++){
	    		sbuf.append(" ");
	    		sbuf.append(words[i]);
	    	}
    	}else{
	    	for(String word : words){
	    		len += word.length();
	    	}
	    	if(words.length > 1){
    	    	spaceSize = (maxWidth - len) / (words.length - 1);
    	    	extraSpace = (maxWidth - len) % (words.length - 1);
	    	}else{
	    	    spaceSize = 1;
	    	    extraSpace = 0;
	    	}
	    	char[] exS = new char[spaceSize + 1];
	    	char[] norS = new char[spaceSize];
	    	Arrays.fill(exS, ' ');
	    	Arrays.fill(norS, ' ');
	    	sbuf.append(words[0]);
	    	for(int i = 0; i < extraSpace; i++){
	    		sbuf.append(exS);
	    		sbuf.append(words[i + 1]);
	    	}
	    	
	    	for(int i = extraSpace; i < words.length - 1; i++){
	    		sbuf.append(norS);
	    		sbuf.append(words[i + 1]);
	    	}
    	}
    	return sbuf.toString();
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	List<String> ret = sln.fullJustify(new String[]{"a","b","c","d","e"}, 1);
    	for(String str : ret){
    		System.out.println(str);
    	}
    }
}
