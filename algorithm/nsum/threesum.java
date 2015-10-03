package nsum;

import java.util.*;

public class threesum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        int len = nums.length;
        
        if (len < 3){
        	return ret;
        }
        Arrays.sort(nums);
        
        for(int i = len - 1; i >= 2; i--){
        	int j = 0, k = i - 1;
        	while (j < k){
        		int tmp = nums[i] + nums[j] + nums[k];
        		if(tmp > 0){
        			k--;
        		}else if(tmp < 0){
        			j++;
        		}else{
        			ArrayList<Integer> al = new ArrayList<Integer>();
        			al.add(nums[j]);
        			al.add(nums[k]);
        			al.add(nums[i]);
        			set.add(al);
        			j++;
        			k--;
        		}
        	}
        }
        
        for(List<Integer> x : set){
        	ret.add(x);
        }
        return ret;
    }
    
    public static void main(String[] args){
    	threesum sln = new threesum();
    	int[] sums = {1, 2, 3, 4, -1, 0};
    	List<List<Integer>> lst = sln.threeSum(sums);
    	for (int i = 0; i < lst.size(); i++){
    		List<Integer> tlst = lst.get(i);
    		for (int j = 0; j < tlst.size(); j++){
    			System.out.print(tlst.get(j) + " ");
    		}
    		System.out.println("");
    	}
    }
}
