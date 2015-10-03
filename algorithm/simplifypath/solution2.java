package simplifypath;

import java.util.*;

public class solution2 {
    public String simplifyPath(String path) {
        Set<String> isSkip = new HashSet<String>(Arrays.asList("", ".", ".."));
        Deque<String> stack = new ArrayDeque<String>();
        for (String token : path.split("/")) {
            if (token.equals("..") && !stack.isEmpty()) stack.pop();
            if (isSkip.contains(token)) continue;
            stack.push(token);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/" + stack.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
    public static void main(String[] args){
    	solution2 sln = new solution2();
    	
    	System.out.println(sln.simplifyPath("/..."));
    }
}
