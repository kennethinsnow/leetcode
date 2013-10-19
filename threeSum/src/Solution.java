import java.util.*;
public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num){
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tempArr;
		Arrays.sort(num);
		num = filterThree(num);
		int zeroP = Arrays.binarySearch(num, 0);
		if(zeroP < 0){zeroP = -1-zeroP;}
		
		int i, j, k;
		int len = num.length;
		
		int tempSum = -1;
		
		if(len < 3){
			return null;
		}
		
		for(i=0;i<zeroP;i++){
    	    j=i+1;
            k=len-1;
            while(j<k){
                tempSum = num[i]+num[j]+num[k];
                if(tempSum>0){
                    k--;
                }else if(tempSum<0){
                    j++;
                }else{
                    tempArr = new ArrayList<Integer>();
					tempArr.add(num[i]);
					tempArr.add(num[j]);
					tempArr.add(num[k]);
					if((ret.size() <= 0) || (!tempArr.equals(ret.get(ret.size()-1)))){
						ret.add(tempArr);
					}
                    j++;
                    k--;
                }
            }
		}
		
		/*
		for(i=0;i<zeroP;i++)
			for(j=i+1;j<len;j++)
				for(k=j+1;k<len;k++){
					tempSum = num[i]+num[j]+num[k];
					if(tempSum == 0){
						tempArr = new ArrayList<Integer>();
						tempArr.add(num[i]);
						tempArr.add(num[j]);
						tempArr.add(num[k]);
						if(!ret.contains(tempArr)){
							ret.add(tempArr);
						}
					}else if(tempSum > 0){
						if(k<len-1){
							k = len;
						}
						else{
							j = len;
						}
					}
				}
		*/
		return ret;
	}
	
	public int[] filterThree(int[] arr){
		int one, two, three, i;
		int[] arr1 = new int[arr.length];
		arr1[0] = arr[0];
		arr1[1] = arr[1];
		one = 0;
		two = 1;
		three =2;
		i = 2;
		System.out.println("Before while loop.");
		while(three < arr.length){
			if((arr[one] != arr[two]) || (arr[one] != arr[three])){
				arr1[i] = arr[three];
				i++;
				one = two;
				two = three;
				three++;
			}else{
				three++;
			}
			System.out.print("loop: " + three + " ");
		}
		
		arr = new int[i];
		for (int j = 0; j < i; j++){
			arr[j] = arr1[j];
		}
		return arr;
	}
	public static void main(String[] args){
		int[] num = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		Solution sol = new Solution();
		ArrayList<ArrayList<Integer>> result = sol.threeSum(num);
		try{
		for(int i=0; i<result.size();i++){
			System.out.println("[" + result.get(i).get(0) + " " +
					result.get(i).get(1) + " " + result.get(i).get(2) + "]");
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}
