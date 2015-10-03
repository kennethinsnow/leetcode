package MedianOfTwoSortedArray;

public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int size1 = nums1.length, size2 = nums2.length;
    	int size = size1 + size2;
    	double m1 = kth(nums1, 0, size1, nums2, 0, size2, size/2 + 1);
    	if (size % 2 == 0){
    		double m2 = kth(nums1, 0, size1, nums2, 0, size2, size/2);
    		return (m1 + m2) / 2.0;
    	}
    	return m1;
    }
    
    double kth(int[] a, int astart, int asize, int[]b, int bstart, int bsize, int k){
    	if (asize < bsize) return kth(b, bstart, bsize, a, astart, asize, k);
    	if (bsize == 0) return a[k - 1];
    	if (k == 1) return min(a[astart], b[bstart]);
    	
    	int j = min(bsize, k/2);
    	int i = k - j;
    	if (a[astart + i - 1] > b[bstart + j - 1]){
    		return kth(a, astart, asize, b, bstart + j, bsize - j, k - j);
    	}else{
    		return kth(a, astart + i, asize - i, b, bstart, bsize, k - i);
    	}
    }
    
    int min(int x, int y){
    	return x < y ? x : y;
    }
    boolean odd(int n){
    	return (n & 0x1) == 1;
    }
}
