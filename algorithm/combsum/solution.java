package combsum;

import java.util.*;

public class solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Set<List<Integer>> ret = new HashSet<List<Integer>>();
        Arrays.sort(candidates);
        ret = comb(candidates, candidates.length, target);
        List<List<Integer>> ret1 = new ArrayList<List<Integer>>();
        for (List<Integer> lt : ret){
        	ret1.add(lt);
        }
        
        return ret1;
    }
    
    //assume cand is sorted
    Set<List<Integer>> comb(int[] cand, int length, int target){
    	Set<List<Integer>> ret = new HashSet<List<Integer>>();
    	if (length == 0 || target < 0) return ret;
    	int count = 0, max = cand[length - 1];
    	do{

    		if(target == 0){
    			List<Integer> lt = new ArrayList<Integer>();
				for (int i = 0; i < count; i++){
					lt.add(max);
				}
				ret.add(lt);
				return ret;
    		}
    		Set<List<Integer>> sub = comb(cand, length - 1, target);
    		if (sub.size() != 0){
    			for (List<Integer> lt : sub){
    				for (int i = 0; i < count; i++){
    					lt.add(max);
    				}
    				ret.add(lt);
    			}
    		}
    		
    		target -= max;
    		count++;
    	}while(target >= 0 && count < 2);
    	
    	return ret;
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	int[] data = {10,1,2,7,6,1,5};
    	List<List<Integer>> lt = sln.combinationSum(data, 8);
    	for(List<Integer> list : lt){
    		for(int i : list){
    			System.out.print(i + " ");
    		}
    		System.out.println("");
    	}
    }
}
