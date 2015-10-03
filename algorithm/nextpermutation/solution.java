package nextpermutation;

import java.util.Arrays;

public class solution {
    public void nextPermutation(int[] nums) {
        int start = -1, end = -1;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                start = i - 1;
                for(int j = i; j < nums.length; j++){
                    if(nums[j] <= nums[i - 1]){
                        end = j - 1;
                        break;
                    }
                }
                if (end == -1) end = nums.length - 1;
                break;
            }
        }
        if(start == -1){
            Arrays.sort(nums);
        }else{
            int k = nums[start];
            nums[start] = nums[end];
            nums[end] = k;
            Arrays.sort(nums, start + 1, nums.length);
        }
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	int[] nums = {5,4,7,5,3,2};
    	sln.nextPermutation(nums);
    	for (int i = 0; i < nums.length; i++){
    		System.out.print(nums[i] + " ");
    	}
    }
}
