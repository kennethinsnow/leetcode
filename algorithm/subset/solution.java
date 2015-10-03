package subset;

import java.util.*;

public class solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        return help(nums.length - 1, nums);
    }
    List<List<Integer>> help(int k, int[] nums){
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        List<Integer> emptyLst = new LinkedList<Integer>();
        if(k < 0){
            ret.add(emptyLst);
            return ret;
        }
        
        List<List<Integer>> pre = help(k - 1, nums);
        for(List<Integer> tmpLst : pre){
            List<Integer> curLst = new LinkedList<Integer>();
            for(Integer i : tmpLst){
            	curLst.add(i);
            }
            curLst.add(nums[k]);
            ret.add(curLst);
        }
        ret.addAll(pre);
        return ret;
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	List<List<Integer>> ret = sln.subsets(new int[]{1,2});
    	for(List<Integer> tLst : ret){
    		System.out.print("[");
    		for(Integer i : tLst){
    			System.out.print(i + " ");
    		}
    		System.out.println("]");
    	}
    }
}
