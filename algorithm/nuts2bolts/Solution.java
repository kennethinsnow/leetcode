package nuts2bolts;

import java.util.*;

/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
	public class NBComparator{
		 public int cmp(String a, String b){
			 Map<String, Integer> nuts = new HashMap();
			 Map<String, Integer> bolts = new HashMap();
			 nuts.put("gg", 1);
			 nuts.put("ab", 2);
			 nuts.put("bc", 3);
			 nuts.put("dd", 4);
			 bolts.put("DD", 1);
			 bolts.put("GG", 2);
			 bolts.put("AB", 3);
			 bolts.put("BC", 4);
			 if (!nuts.containsKey(a)) return -2;
			 if (!bolts.containsKey(b)) return -2;
			 int ret = nuts.get(a) - bolts.get(b);
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
        int len1 = nuts.length, len2 = bolts.length;
        if (len1 <= 0 || len1 != len2) return;
        quicksort(nuts, bolts, 0, len1 - 1, compare);
    }
    void quicksort(String[] nuts, String[] bolts, int hd, int ta, NBComparator compare){
        if (hd >= ta) return;
        // quicksort both nuts and bolts
        int qhd = hd, qta = ta;
        String pivot = nuts[hd];
        int pind = 0;
        while (qhd <= qta){
            if (compare.cmp(pivot, bolts[qhd]) == 1) qhd++;
            else if (compare.cmp(pivot, bolts[qhd]) == 0){
                pind = qhd;
                qhd++;
            } else if (compare.cmp(pivot, bolts[qta]) == -1) qta--;
            else {
                exch(bolts, qhd, qta);
            }
        }
        exch(bolts, pind, qta);
//        System.out.print(pivot + " " + bolts[qta] + " " + qhd + " " + qta);
//        for (String str : bolts) System.out.print(" " + str + " ");
//        System.out.println("");
        pivot = bolts[qta];
        qhd = hd;
        qta = ta;
        while (qhd <= qta){
            if (compare.cmp(nuts[qhd], pivot) == -1) qhd++;
            else if (compare.cmp(nuts[qhd], pivot) == 0){
                pind = qhd;
                qhd++;
            } else if (compare.cmp(nuts[qta], pivot) == 1) qta--;
            else {
                exch(nuts, qhd, qta);
            }
        }
        exch(nuts, pind, qta);
//        for (String str : nuts) System.out.print(" " + str + " ");
//        System.out.println("");
        quicksort(nuts, bolts, hd, qta - 1, compare);
        quicksort(nuts, bolts, qta + 1, ta, compare);
    }

    void exch(String[] a, int x, int y){
        String tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
    
    public static void main(String[] args){
    	Solution sln = new Solution();
    	String[] nuts = {"ab","bc","dd","gg"};
    	String[] bolts = {"AB","BC","DD","GG"};
    	sln.sortNutsAndBolts(nuts, bolts, sln.new NBComparator());
    	for (String str : nuts) System.out.print(" " + str);
    	System.out.println("");
    	for (String str : bolts) System.out.print(" " + str);
    }
};
