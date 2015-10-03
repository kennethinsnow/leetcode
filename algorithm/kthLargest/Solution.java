package kthLargest;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // quick select
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (true){
            int j = partition(nums, lo, hi, k);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else break;
        }
        return nums[k];
    }
    
    int partition(int[] a, int lo, int hi, int k){
        if(lo >= hi) return lo;
        int i = lo + 1, j = hi;
        while (i <= j){
            if (a[i] <= a[lo]) i++;
            else if (a[j] > a[lo]) j--;
            else    exch(a, i++, j--);
        }
        exch(a, lo, j);
        return j;
    }
    
    void exch(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void main (String[] args){
    	Solution sln = new Solution();
    	System.out.println(sln.findKthLargest(new int[]{-1, 2, 0}, 3));
    }
}
