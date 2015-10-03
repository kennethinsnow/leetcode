package compareVersion;

public class solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length, len2 = v2.length;
        int i = 0;
        while(i < len1 && i < len2){
            double diff = 0;
            if(i == 0){
                diff = Integer.parseInt(v1[i]) - Integer.parseInt(v2[i]);
            }else{
                diff = Double.parseDouble(v1[i]) - Double.parseDouble(v2[i]);
            }
            if(diff > 0) return 1;
            else if(diff < 0) return -1;
            i++;
        }
        if(len1 > len2) return 1;
        else if(len1 < len2) return -1;
        else return 0;
    }
    public static void main(String[] args){
    	solution sln = new solution();
    	System.out.println(sln.compareVersion("1.1", "0.1"));
    }
}
