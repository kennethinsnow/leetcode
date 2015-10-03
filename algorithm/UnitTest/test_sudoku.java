package UnitTest;
import org.junit.Test;

import static org.junit.Assert.*;
import sudoku.*;

public class test_sudoku{
	@Test
	public void testOne(){
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
    	char[][] board = new char[9][9];
    	for(int i = 0; i < 9; i++){
    		for (int j = 0; j < 9; j++){
    			board[i][j] = bd[i].charAt(j);
    		}
    	}
    	sln.solveSudoku(board);
    	for(int i = 0; i < 9; i++){
    		for (int j = 0; j < 9; j++){
    			assertTrue(board[i][j] > '0');
    			assertTrue(board[i][j] <= '9');
    		}
    	}
	}
}
