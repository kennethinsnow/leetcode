package calculator;

import java.util.*;

public class solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> pro = new Stack<Integer>();
        reversePolishNotation(s, 0, pro);
        return cal(pro);
    }
    
    int reversePolishNotation(String s, int i, Stack<Integer> pro){
        int len = s.length();
        int op = 0;
        while(i < len){
            char c= s.charAt(i++);
            if(c == '('){
                i = reversePolishNotation(s, i, pro);
                if(op != 0){ 
                    pro.push(op);
                    op = 0;
                }
            }
            if(c == ')') return i;
            if(c == '+') op = -1;
            if(c == '-') op = -2;
            if(c >= '0' && c <= '9'){
                int num = c - '0';
                c = s.charAt(i);
                while(i < len && c >= '0' && c <= '9'){
                    num *= 10;
                    num += c - '0';
                    i++;
                }
                pro.push(num);
                if(op != 0){
                    pro.push(op);
                    op = 0;
                }
            }
        }
        return i;
    }
    
    int cal(Stack<Integer> stk){
        int op = stk.pop();
        if(op == -1){
            return cal(stk) + cal(stk);
        }else if (op == -2){
            return -cal(stk) + cal(stk);
        }else{
            return op;
        }
        
    }
	public static void main(String[] args){
		solution sln = new solution();
		System.out.println(sln.calculate("(1)"));
	}
}
