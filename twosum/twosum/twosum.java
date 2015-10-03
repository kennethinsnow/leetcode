package twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class twosum{
	public int[] getSolution(int[] numbers, int target){
		Integer[] numberbak = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            numberbak[i] = numbers[i];
        }
		Arrays.sort(numbers);
		int[] index = {1, numbers.length};
		while(index[0] < index[1]){
			int tmp = numbers[index[0] - 1] + numbers[index[1] - 1];
			if (tmp < target){
				index[0] = index[0] + 1;
			}else if (tmp > target){
				index[1] = index[1] - 1;
			}else{
				List<Integer> lst = Arrays.asList(numberbak);
			    index[0] = lst.indexOf(numbers[index[0] - 1]) + 1;
			    index[1] = lst.indexOf(numbers[index[1] - 1]) + 1;
				return index;
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		int[] num = {3, 2, 4};
		int[] index = new twosum().getSolution(num, 6);
		System.out.println(index[0] + " " + index[1]);
	}
}