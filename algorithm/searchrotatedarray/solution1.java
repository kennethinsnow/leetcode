package searchrotatedarray;

/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.*/

public class solution1 {
    public int search(int[] nums, int target) {
        int l = 0, u = nums.length - 1;
        int m;
        while(l <= u){
            m = (l + u) / 2;
            if (nums[m] == target){
                return m;
            }else if (nums[l] <= nums[m]){
                if(target > nums[m]){
                    l = m + 1;
                }else if(target >= nums[l]){
                    u = m - 1;
                }else{
                    l = m + 1;
                }
            }else if(target < nums[m]){
                u = m - 1;
            }else if(target < nums[l]){
                l = m + 1;
            }else{
                u = m - 1;
            }
        }
        return -1;
    }
}
