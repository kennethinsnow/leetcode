package reverseint;

import java.util.Stack;

public class solution {
    public int reverse(int x) {
        long result = 0;
        //long type is for compare. Only larger range can compare Max and Min Integer 

        while(x!=0)
        {
            int mod = x%10;
            x = x/10;
            result = result*10 + mod;
            if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) return 0;
        }
        return (int) result;
    }
}
