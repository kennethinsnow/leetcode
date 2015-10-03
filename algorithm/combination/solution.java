package combination;

import java.util.*;

public class solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Set<Set<Integer>> combset;
		if(k > n || k == 0) return ret;
		Set<Integer> lst = new HashSet<Integer>();
		for(int i = 1; i <= n; i++){
			lst.add(i);
		}
		combset = findComb(lst, k);
		
		for(Set<Integer> cSet : combset){
			List<Integer> cLst = new ArrayList<Integer>();
			cLst.addAll(cSet);
			ret.add(cLst);
		}
		return ret;
	}
	
	Set<Set<Integer>> findComb(Set<Integer> lst, int k){
		
		Set<Set<Integer>> comb = new HashSet<Set<Integer>>();
		if (k == lst.size()) {
			comb.add(lst);
			return comb;
		}
		
		if(k == 0){
			comb.add(new HashSet<Integer>());
			return comb;
		}
		
		Set<Integer> it = new HashSet<Integer>();
		it.addAll(lst);
		
		for(int i : it){
			
			lst.remove(new Integer(i));
			Set<Set<Integer>> combTmp = findComb(lst, k - 1);
			for(Set<Integer> lt : combTmp){
				lt.add(i);
				comb.add(lt);
			}
			lst.add(i);
			
		}
		
		return comb;
	}
	
	public static void main(String[] args){
		solution sln = new solution();
		System.out.println(sln.combine(4, 2));
	}
}
