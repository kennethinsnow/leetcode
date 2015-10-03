package nqueen;

import java.util.*;

public class solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> ret = new ArrayList<String[]>();
        boolean[] invalid = new boolean[5*n];
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
        	Arrays.fill(board[i], '.');
        }
        placeQueen(0, board, invalid, ret);
        return ret;
    }
    
    void placeQueen(int row, char[][] board, boolean[] inv, List<String[]> ret){
    	int size = board.length;
    	if (row == size){
    		String[] oneBd = new String[size];
    		for(int i = 0;i < size; i++){
    			oneBd[i] = new String(board[i]);
    		}
    		ret.add(oneBd);
    		return;
    	}
    	
    	for(int i = 0; i < size; i++){
    		if(!inv[i] && !inv[i + row + size] && !inv[row - i + 4 * size]){
    			board[row][i] = 'Q';
    			inv[i] = inv[i + row + size] = inv[row - i + 4 * size] = true;
    			placeQueen(row + 1, board, inv, ret);
    			board[row][i] = '.';
    			inv[i] = inv[i + row + size] = inv[row - i + 4 * size] = false;
    		}
    	}
    }
}
