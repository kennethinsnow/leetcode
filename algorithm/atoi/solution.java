package atoi;

public class solution {
    public int myAtoi(String str) {
        String myStr = str.trim();
        if (myStr.length() == 0) return 0;
        char[] myChar = myStr.toCharArray();
        long res = 0;
        int mark = 1;
        // first char must be 0-9 or +/-
        if (myChar[0] == '+' || myChar[0] == '-' || (myChar[0] >= '0' && myChar[0] <= '9')){
        	if (myChar[0] == '-'){
        		mark = -1;
        	}else if(myChar[0] >= '0' && myChar[0] <= '9'){
        		res = myChar[0] - '0';
        	}
        	int i = 1;
        	while(i < myChar.length && myChar[i] >= '0' && myChar[i] <= '9'){
        		res = res * 10 + myChar[i] - '0';
        		if (mark == -1 && (-res) <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
                if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        		i++;
        	}
        	
        }else{
        	return 0;
        }
        
        res = res * mark;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE - 1;
        return (int)res;
    }
    
    public static void main(String[] args){
    	String s  = "-2147483648";
    	System.out.println(new solution().myAtoi(s));
    }
}
