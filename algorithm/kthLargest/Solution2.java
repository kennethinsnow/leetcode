package kthLargest;

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        // quick select
        int head = 0, tail = nums.length - 1;
        while (true){
            int i = head + 1, j = tail;
            while (i <= j){
                if (nums[i] >= nums[head]) i++;
                else if (nums[j] < nums[head]) j--;
                else    exch(nums, i++, j--);
            }
            if (i == k) return nums[head];
            else if (i < k) head = i;
            else tail = j - 1;
        }
    }
    
    void exch(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void main (String[] args){
    	Solution2 sln = new Solution2();
    	System.out.println(sln.findKthLargest(new int[]{-1, 2, 0}, 1));
    }
}