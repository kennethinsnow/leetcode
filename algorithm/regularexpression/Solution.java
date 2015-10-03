package regularexpression;

import java.util.Arrays;

public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        boolean[] pre_dp = new boolean[len2 + 1];
        boolean[] cur_dp = new boolean[len2 + 1];
        pre_dp[0] = true;
        for(int i = 1; i < len2; i++){
            if(p.charAt(i) == '*')
                pre_dp[i + 1] = pre_dp[i - 1];
        }
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                char cur = p.charAt(j);
                if(cur == '.' || cur == s.charAt(i)) cur_dp[j + 1] = pre_dp[j];
                else if(cur == '*' && j > 0){
                    if(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)){
                        cur_dp[j + 1] = cur_dp[j] || pre_dp[j + 1];
                    }else{
                        cur_dp[j + 1] = cur_dp[j - 1];
                    }
                }else{
                    cur_dp[j + 1] = false;
                }
            }
            pre_dp = Arrays.copyOf(cur_dp, len2 + 1);
        }
        return pre_dp[len2];
    }
    
    public static void main(String[] args){
    	Solution sln = new Solution();
    	String s = "aasdfasdfasdfasdfas";
    	String p = "aasdf.*asdf.*asdf.*asdf.*s";
    	System.out.println(p + " matches " + s + "? " + sln.isMatch(s, p));
    }
}
