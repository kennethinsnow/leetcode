package maxProduct;

public class solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len <= 0) return 0;
        
        long bfirst = 0, alast = 0;
        long maxP = nums[0];
        long cur = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                if(cur == 0) cur = 1;
                if(bfirst == 0){
                    bfirst = cur * nums[i];
                }
                alast = 1;
            }else if(nums[i] == 0){
                if(cur > maxP) maxP = cur;
                else if (cur < 0 && bfirst != 0){
                    if(cur / bfirst > cur / alast) maxP = cur / bfirst;
                    else maxP = cur / alast;
                }
                bfirst = 0;
                alast = 0;
                cur = 0;
            }else{
                if(cur == 0) cur = 1;
            }
            cur *= nums[i];
            if(alast != 0) alast *= nums[i];
        }
        if(cur > maxP) maxP = cur;
        else if (cur < 0 && bfirst != 0){
            if(cur / bfirst > cur / alast) maxP = cur / bfirst;
            else maxP = cur / alast;
        }
        
        return (int)maxP;
    }
    public static void main(String[] args){
    	solution sln = new solution();
    	int[] nums = {-2};
    	System.out.println(sln.maxProduct(nums));
    }
}
