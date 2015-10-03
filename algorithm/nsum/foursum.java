package nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class foursum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        int len = nums.length;
        
        if (len < 4){
        	return ret;
        }
        Arrays.sort(nums);
        for (int l = len - 1; l >= 3; l--){
	        for(int i = l - 1; i >= 2; i--){
	        	int j = 0, k = i - 1;
	        	while (j < k){
	        		int tmp = nums[i] + nums[j] + nums[k] + nums[l];
	        		if(tmp > target){
	        			k--;
	        		}else if(tmp < target){
	        			j++;
	        		}else{
	        			ArrayList<Integer> al = new ArrayList<Integer>();
	        			al.add(nums[j]);
	        			al.add(nums[k]);
	        			al.add(nums[i]);
	        			al.add(nums[l]);
	        			set.add(al);
	        			j++;
	        			k--;
	        		}
	        	}
	        }
        }
        
        for(List<Integer> x : set){
        	ret.add(x);
        }
        return ret;
    }
    
    public static void main(String[] args){
    	foursum sln = new foursum();
    	int[] sums = {1, 2, 3, 4, -1, 0};
    	List<List<Integer>> lst = sln.fourSum(sums, 5);
    	for (int i = 0; i < lst.size(); i++){
    		List<Integer> tlst = lst.get(i);
    		for (int j = 0; j < tlst.size(); j++){
    			System.out.print(tlst.get(j) + " ");
    		}
    		System.out.println("");
    	}
    }
}
