package wildcard;


// O(m+n) solution with two pointers and kmp
public class solution4 {
	boolean isMatch(String str, String pattern) {
        int s = 0, p = 0;           
        while (s < str.length()){
        	if (p < pattern.length() && pattern.charAt(p) == '*'){
                p++;
            }
            else if(p < pattern.length()){
            	int k = p;
            	while(k < pattern.length() && pattern.charAt(k) != '*') k++;
            	int n = kmpMatch(str.substring(s), pattern.substring(p, k));
            	if(n == -1) return false;
            	else s += n + 1;
            	p = k;
            }else{
            	if (p > 0 && pattern.charAt(p - 1) == '*') return true;
            	else break;
            }
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length() && s == str.length();
	}
	
	// match pattern p against string s, and return the end of the match, return -1 if no match is found
	int kmpMatch(String s, String p){
		int len = p.length(), slen = s.length();
		int[] overlap = new int[len];
		int preoverlap = 0;
		// setup overlap array
		for (int i = 1; i < p.length(); i++){
			while(preoverlap > 0 && p.charAt(i) != '?' && p.charAt(preoverlap) != p.charAt(i)){
				preoverlap = overlap[preoverlap - 1];
			}
			if(p.charAt(preoverlap) == p.charAt(i) || p.charAt(i) == '?'){
				preoverlap++;
				overlap[i] = preoverlap;
			}else{
				overlap[i] = 0;
			}
		}
		int k = 0, h = 0;
		while(k <= slen - len && h < len){
			while(h > 0 && s.charAt(k + h) != p.charAt(h) && p.charAt(h) != '?'){
				k += h - overlap[h - 1];
				h = overlap[h - 1];
			}
			if(s.charAt(k + h) == p.charAt(h) || p.charAt(h) == '?'){
				h++;
			}else{
				k++;
			}
		}
		
		if(h == len){
			return k + h - 1;
		}else{
			return -1;
		}
	}
	
    public static void main(String[] argv){
    	solution4 sln = new solution4();
    	long startTime = System.currentTimeMillis();
    	System.out.println(sln.isMatch("hi", "*?"));
    	long estTime = System.currentTimeMillis() - startTime;
    	System.out.println("running time: " + estTime);
//    	System.out.println("kmp result: " + sln.kmpMatch("reldktelzkel", "el?kel"));
    }
}
