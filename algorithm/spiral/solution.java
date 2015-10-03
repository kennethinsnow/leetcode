package spiral;

import java.util.*;

public class solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int dir = 0;
        int row = 0, col = 0, currow, curcol;
        List<Integer> ret = new ArrayList<Integer>();
        
        if (matrix.length == 0 ) return ret;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visit = new boolean[m][n];
        
        int turntime = 0;
        ret.add(matrix[0][0]);
        visit[0][0] = true;
        while(turntime < 2){
           
            currow = row;
            curcol = col;
            switch (dir){
                case 0:
                    curcol++;
                    break;
                case 1:
                    currow++;
                    break;
                case 2:
                    curcol--;
                    break;
                case 3:
                    currow--;
                    break;
            }
            if(currow >= m || currow < 0 || curcol >= n || curcol < 0 || visit[currow][curcol]){
                dir += 1;
                dir = dir % 4;
                turntime++;
            }else{
                row = currow;
                col = curcol;
                ret.add(matrix[row][col]);
                visit[row][col] = true;
                turntime = 0;
            }
        }
        return ret;
    }
}
