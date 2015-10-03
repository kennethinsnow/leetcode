package searchrotatedarray;

/*Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.*/

public class solution2 {
    public boolean search(int[] nums, int target) {
        int l = 0, u = nums.length - 1;
        int m;
        while(l <= u){
            m = (l + u) / 2;
            if (nums[m] == target){
                return true;
            }else if (nums[l] == nums[m]){
            	l++;
            }else if (nums[m] == nums[u]){
            	u--;
            }else if (nums[l] < nums[m]){
                if(target > nums[m]){
                    l = m + 1;
                }else if(target == nums[l]){
                	return true;
                }
            	else if(target > nums[l]){ 
                    u = m - 1;
                }else{
                    l = m + 1;
                }
            }else if(target < nums[m]){
                u = m - 1;
            }else if(target < nums[l]){
                l = m + 1;
            }else if(target == nums[l]){
            	return true;
            }else{
                u = m - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
    	solution2 sln = new solution2();
    	System.out.println(sln.search(new int[] {1,3,1,1,1}, 3));
    }
}
