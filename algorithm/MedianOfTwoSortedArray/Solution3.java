package MedianOfTwoSortedArray;

class Solution3 {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len1 = A.length, len2 = B.length;
        double v = (double)findKth(A, 0, len1 - 1, B, 0, len2 - 1, (len1 + len2 + 1) / 2);
        if ((len1 + len2) % 2 == 0){
            v += (double)findKth(A, 0, len1 - 1, B, 0, len2 - 1, (len1 + len2) / 2 + 1);
            v /= 2;
        }
        return v;
    }

    int findKth(int[] A, int as, int ae, int[] B, int bs, int be, int k){
        if (as > ae) return B[bs + k - 1];
        if (bs > be) return A[as + k - 1];
        int meda = as + (ae - as) / 2;
        int medb = bs + (be - bs) / 2;
        if (A[meda] > B[medb]){
            if (k < (meda + medb - as - bs + 2)) return findKth(A, as, meda - 1, B, bs, be, k);
            else return findKth(A, as, ae, B, medb + 1, be, k - medb + bs - 1);
        } else {
            if (k < (meda + medb - as - bs + 2)) return findKth(A, as, ae, B, bs, medb - 1, k);
            else return findKth(A, meda + 1, ae, B, bs, be, k - meda + as - 1);
        }
    }
    
    public static void main(String[] args){
    	Solution3 sln = new Solution3();
    	int[] A = {1,2,3,4};
    	int[] B = {5,6,7,8,9};
    	System.out.println(sln.findMedianSortedArrays(A, B));
    }
}
