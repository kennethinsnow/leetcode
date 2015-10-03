package zigzag;

public class solution {
    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1 || s.length() <= numRows) return s;
        int len = s.length();
        char[] cbuf = new char[len];
        int edge = numRows - 1;
        int j = 0;
        for (int i = 0; i < numRows; i++){
            int k = i;
            while(k < len){
                cbuf[j] = s.charAt(k);
                j++;
                if (i == 0 || i == edge) k += 2 * edge;
                else k += 2 * (edge - k % edge);
            }
        }
        return String.valueOf(cbuf);
    }
}
