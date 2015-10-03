package spiral;

import java.util.*;

public class solution2 {
	public int[][] generateMatrix(int n) {
        
        int dir = 0;
        int row = 0, col = 0, currow, curcol;
        int[][] nMatrix = new int[n][n];
        if (n == 0 ) return nMatrix;
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		nMatrix[i][j] = 0;
        	}
        }
        
        int turntime = 0, idx = 2;
        nMatrix[0][0] = 1;

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
            if(currow >= n || currow < 0 || curcol >= n || curcol < 0 || nMatrix[currow][curcol] != 0){
                dir += 1;
                dir = dir % 4;
                turntime++;
            }else{
                row = currow;
                col = curcol;
                nMatrix[row][col] = idx++;
                turntime = 0;
            }
        }
        return nMatrix;
    }
}
