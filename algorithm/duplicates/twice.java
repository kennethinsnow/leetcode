package duplicates;

public class twice {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int freq = 0;
        if(nums.length < 3) return nums.length;
        int curNum = nums[0];
        
        for (int i = 1; i < nums.length; i++){
        	if(nums[i] == curNum) {
        		freq++;
        		if(freq == 1){
        			nums[k] = nums[i]; 
        			k++;
        		}
        	}else{
        		curNum = nums[i];
        		nums[k] = nums[i]; 
    			k++;
    			freq = 0;
        	}
        }
        
        return k;
    }
    
    public static void main(String[] args){
    	twice sln = new twice();
    	System.out.println(sln.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
