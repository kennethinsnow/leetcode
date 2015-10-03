package sudoku;

import java.util.ArrayList;
import java.util.Arrays;

public class solution {
    
    public void solveSudoku(char[][] board) {
    	char[] bd = new char[81];
    	
    	for(int i = 0; i < 9; i++){
    		for(int j = 0; j < 9; j++){
    			bd[i * 9 + j] = board[i][j];
    		}
    	}
    	for(int i = 0; i < 9; i++){
    		for(int j = 0; j < 9; j++){
    			if(board[i][j] == '.'){
    				if(findSudoku(bd, i * 9 + j) == 1){
	    				for (int k = 0; k < 9; k++){
	    				    for (int l = 0; l < 9; l++){
	    				        board[k][l] = bd[k * 9 + l];
	    				    }
	    				}
    				}
    				return;
    			}
    		}
    	}
    }
    
    int findSudoku(char[] bd, int start){
    	int i = start;
    	for (; i < 81; i++){
			if(bd[i] == '.'){
				ArrayList<Character> x = findSudokuNum(bd, i);
				for (int j = 0; j < x.size(); j++){
					char[] tbd = Arrays.copyOf(bd, 81);
					tbd[i] = x.get(j);
					if (findSudoku(tbd, i + 1) == 1){
						System.arraycopy(tbd, 0, bd, 0, 81);
						return 1;
					}
				}
				return -1;
			}
    	}
		if (i == 81) return 1;
		else return -1;
    }
    
    ArrayList<Character> findSudokuNum(char[] bd, int ind){
    	int nrow = ind / 9, ncol = ind % 9;
    	int[] ext = new int[9];
    	ArrayList<Character> ret = new ArrayList<Character>();
    	for(int i = 0; i < 9; i++){
    		if(bd[nrow*9 + i] != '.'){
    			ext[bd[nrow * 9 + i] - '1'] = 1;
    		}
    		if(bd[ncol + i * 9] != '.'){
    			ext[bd[ncol + i * 9] - '1'] = 1;
    		}
    	}
    	int brow = nrow / 3, bcol = ncol / 3;
    	for (int i = 0; i < 3; i++){
    		for(int j = 0; j < 3; j++){
        		if(bd[(brow * 3 + i) * 9 + bcol * 3 + j] != '.'){
        			ext[bd[(brow * 3 + i) * 9 + bcol * 3 + j] - '1'] = 1;
        		}
    		}
    	}
    	for(int i = 0; i < 9; i++){
    		if (ext[i] != 1){
    			ret.add((char)(i + '1'));
    		}
    	}
    	
    	return ret;
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	String[] bd = {"..9748...", 
    				   "7........",
    				   ".2.1.9...",
    				   "..7...24.",
    				   ".64.1.59.",
    				   ".98...3..",
    				   "...8.3.2.",
    				   "........6",
    				   "...2759.."};
    	/*String[] bd = {"5346789..",
    				   "672195.48",
    				   "198342567",
    				   "8597.1423",
    				   "426853791",
    				   "713924.56",
    				   "961537284",
    				   "287419635",
    				   "345286179"
    	};*/
    	char[][] board = new char[9][9];
    	for(int i = 0; i < 9; i++){
    		for (int j = 0; j < 9; j++){
    			board[i][j] = bd[i].charAt(j);
    		}
    	}
    	sln.solveSudoku(board);
    	for (int i = 0; i < 9; i++){
    		for (int j = 0; j < 9; j++){
    			System.out.print(board[i][j] + " ");
    		}
    		System.out.println("");
    	}
    	
    }
}
