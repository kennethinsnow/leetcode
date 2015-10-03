package nuts2bolts;

import nuts2bolts.Solution.NBComparator;

public class Solution1 {
	public class NBComparator{
		 public int cmp(String a, String b){
			 if (a.equals(a.toUpperCase())) return -2;
			 if (b.equals(b.toLowerCase())) return -2;
			 int ret = a.compareTo(b.toLowerCase());
			 if (ret > 0) return 1;
			 else if (ret < 0) return -1;
			 else return 0;
		 }
	}
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || bolts == null) return;
        if (nuts.length != bolts.length) return;

        qsort(nuts, bolts, compare, 0, nuts.length - 1);
    }

    private void qsort(String[] nuts, String[] bolts, NBComparator compare, 
                       int l, int u) {
        if (l >= u) return;
        // find the partition index for nuts with bolts[l]
        int part_inx = partition(nuts, bolts[l], compare, l, u);
        // partition bolts with nuts[part_inx]
        partition(bolts, nuts[part_inx], compare, l, u);
        // qsort recursively
        qsort(nuts, bolts, compare, l, part_inx - 1);
        qsort(nuts, bolts, compare, part_inx + 1, u);
    }

    private int partition(String[] str, String pivot, NBComparator compare, 
                          int l, int u) {
          //
        int m = l;
        for (int i = l + 1; i <= u; i++) {
            if (compare.cmp(str[i], pivot) == -1 || 
                compare.cmp(pivot, str[i]) == 1) {
                //
                m++;
                swap(str, i, m);
            } else if (compare.cmp(str[i], pivot) == 0 || 
                       compare.cmp(pivot, str[i]) == 0) {
                // swap nuts[l]/bolts[l] with pivot
                swap(str, i, l);
                i--;
            }
        }
        // move pivot to proper index
        swap(str, m, l);

        return m;
    }

    private void swap(String[] str, int l, int r) {
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
    public static void main(String[] args){
    	Solution1 sln = new Solution1();
    	String[] nuts = {"ab","bc","dd","gg"};
    	String[] bolts = {"AB","GG","DD","BC"};
    	sln.sortNutsAndBolts(nuts, bolts, sln.new NBComparator());
    	for (String str : nuts) System.out.print(" " + str);
    	System.out.println("");
    	for (String str : bolts) System.out.print(" " + str);
    }
}
