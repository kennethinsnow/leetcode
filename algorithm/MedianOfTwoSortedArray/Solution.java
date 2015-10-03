package MedianOfTwoSortedArray;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length, size2 = nums2.length;
        int size = size1 + size2;
        int i = 0, j = 0;
        double med = 0, current = 0;
        while((i < size1) && j < size2 && (i + j) < size/2){
        	if(nums1[i] <= nums2[j]){
        		current = nums1[i];
        		i++;
        	}else{
        		current = nums2[j];
        		j++;
        	}
        }
        if (i < size1){
        	while((i + j) < size/2){
        		current = nums1[i];
        		i++;
        	}
        }
        if (j < size2){
        	while((i + j) < size/2){
        		current = nums2[j];
        		j++;
        	}
        }
        if (i < size1 && j < size2){
	        if((size % 2) == 0){
	        	med = (current + ((nums1[i] <= nums2[j]) ? nums1[i] : nums2[j])) / 2.0;
	        }else{
	        	med = (nums1[i] <= nums2[j]) ? nums1[i] : nums2[j];
	        }
        }else if(i >= size1){
	        if((size % 2) == 0){
	        	med = (current + nums2[j]) / 2.0;
	        }else{
	        	med = nums2[j];
	        }
        }else{
	        if((size % 2) == 0){
	        	med = (current + nums1[i]) / 2.0;
	        }else{
	        	med = nums1[i];
	        }
        }
        
        return med;
    }
    
    double min(double x, double y){
    	return x < y ? x : y;
    }
    boolean odd(int n){
    	return (n & 0x1) == 1;
    }
    double medianOfSortedArr(int[] A, int n){
    	return odd(n)? (double)A[n/2] : (double)(A[n/2] + A[n/2 - 1])/2.0;
    }
}
