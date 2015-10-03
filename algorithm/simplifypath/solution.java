package simplifypath;

import java.util.*;

public class solution {
    public String simplifyPath(String path) {
    	int i = 0;
    	int start, end;
    	StringBuffer sbuf = new StringBuffer();
    	if(path.length() == 0) return "/";
    	Deque<String> sPath = new ArrayDeque<String>();
    	while(i < path.length()){
    		if(path.charAt(i) != '/') break;
    		i++;
    		while(i < path.length() && path.charAt(i) == '/') i++;
    		start = end = i;
			if(i < path.length()){
        		while(i < path.length() && path.charAt(i) != '/'){
        			end = i++;
        		}
        		String tmp = path.substring(start, end + 1);
        		if(tmp.equals("..")  && !sPath.isEmpty()) sPath.pop();
        		else if(tmp.equals(".") || tmp.equals("..")) continue;
        		else sPath.push(tmp);
    		}
    		
    		
    	}
    	
    	while(!sPath.isEmpty()){
    		sbuf.append("/" + sPath.pollLast());
    	}
    	
    	return sbuf.length() == 0 ? "/" : sbuf.toString();
    }
    public static void main(String[] args){
    	solution sln = new solution();
    	
    	System.out.println(sln.simplifyPath("/..."));
    }
}
