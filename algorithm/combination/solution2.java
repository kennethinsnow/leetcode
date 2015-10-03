package combination;

import java.util.*;

public class solution2 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(k > n) return ret;
		if(k == n || k == 0) {
			List<Integer> tmpLst = new ArrayList<Integer>();
			for(int i = 1; i <= k; i++){
				tmpLst.add(i);
			}
			ret.add(tmpLst);
			return ret;
		}
		for (List<Integer> lst : combine(n - 1, k - 1)){
			lst.add(n);
			ret.add(lst);
		}
		ret.addAll(combine(n - 1, k));

		return ret;
	}

	
	public static void main(String[] args){
		solution2 sln = new solution2();
		System.out.println(sln.combine(4, 2));
	}
}
