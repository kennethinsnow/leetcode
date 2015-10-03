package fraction;

import java.util.*;

public class solution {
    public String fractionToDecimal(int numerator, int denominator) {
    	String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs(numerator);
        long den = Math.abs(denominator);
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuffer sbuf = new StringBuffer();

        sbuf.append(sign);
        sbuf.append(num / den);
        long rem = num % den;
        if(rem != 0) sbuf.append(".");
        long dig;
        while(rem != 0){
            long tmp = rem * 10;
            dig = tmp / denominator;
            rem = tmp % denominator;
            if(map.get(dig) == rem){
                sbuf.insert(sbuf.length() - 1, "(");
                sbuf.append(")");
                break;
            }
            if(dig != 0 || rem != 0){
                sbuf.append(dig);
            }
            map.put(rem, sbuf.length());
        }
        return sbuf.toString();
    }
    public static void main(String[] args){
    	solution sln = new solution();
    	System.out.println(sln.fractionToDecimal(1, 99));
    }
}
