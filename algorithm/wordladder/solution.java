package wordladder;

import java.util.*;

public class solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        LinkedList<String> queue = new LinkedList<String>();
        Map<String, List<String>> parent = new HashMap<String, List<String>>();
        List<List<String>> ret = new LinkedList<List<String>>();
        dict.remove(start);
        queue.add(start);
        dict.add(end);
        boolean found = false;
        while (!queue.isEmpty()) {
            LinkedList<String> level = new LinkedList<String>();
            while (!queue.isEmpty()) {
                String q = queue.pollFirst();
                if (q.equals(end)){
                    ret.addAll(findPath(q, parent));
                    found = true;
                    queue.clear();
                    break;
                }
                if(!found){
                    for (int i = 0; i < start.length(); i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            String s = q.substring(0, i) + c + q.substring(i + 1, start.length());
                            if(s.equals(q)) continue;
                            if (dict.contains(s)) {
                            	List<String> par = new LinkedList<String>();
                            	if(parent.containsKey(s)){
                            		par = parent.get(s);
                            	}
                            	par.add(q);
                                parent.put(s, par);
                                level.add(s);
                            }
                        }
                    }
                }
            }
            dict.removeAll(level);
            if(!found) queue = level;
        }
        return ret;
    }
    
    Set<List<String>> findPath(String q, Map<String, List<String>> parent){
    	Set<List<String>> ret = new HashSet<List<String>>();
    	if(!parent.containsKey(q)){
    		List<String> lst = new LinkedList<String>();
    		lst.add(q);
    		ret.add(lst);
    		return ret;
    	}
    	for(String str : parent.get(q)){
    		Set<List<String>> res = findPath(str, parent);
    		for(List<String> lst : res){
    			lst.add(q);
    			ret.add(lst);
    		}
    	}
    	return ret;
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	Set<String> dict = new HashSet<String>();
    	String[] input = {"a", "b", "c"};
    	for(String str : input){
    		dict.add(str);
    	}
    	List<List<String>> res = sln.findLadders("a", "c", dict);
    	for(List<String> lst : res){
    		System.out.print("[");
    		for(String str : lst){
    			System.out.print(str + " ");
    		}
    		System.out.println("]");
    	}
    }
}
