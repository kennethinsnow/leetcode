package surrondRegion;

import java.util.*;

public class solution {
    public void solve(char[][] board) {
        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;
        int[][] map = new int[row][col];
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O'){
            	map[0][i] = 1;
                findNearBy(0, i, board, map);
            }
            if(board[row - 1][i] == 'O'){
            	map[row - 1][i] = 1;
                findNearBy(row - 1, i, board, map);
            }
        }
        
        for(int i = 1; i < row - 1; i++){
            if(board[i][0] == 'O'){
            	map[i][0] = 1;
                findNearBy(i, 0, board, map);
            }
            if(board[i][col - 1] == 'O'){
            	map[i][col - 1] = 1;
                findNearBy(i, col - 1, board, map);
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(map[i][j] == 1){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    void findNearBy(int i, int j, char[][] board, int[][] map){
        Queue<Integer> searchQue = new LinkedList<Integer>();
        int row = board.length;
        int col = board[0].length;
        searchQue.offer(i * col + j);
        while(!searchQue.isEmpty()){
            int ind = searchQue.poll();
            int cRow = ind / col;
            int cCol = ind % col;
            if((cRow + 1 < row) && board[cRow + 1][cCol] == 'O' && map[cRow + 1][cCol] != 1){
                map[cRow + 1][cCol] = 1;
                searchQue.offer(ind + col);
            }
            if((cRow - 1 >= 0) && board[cRow - 1][cCol] == 'O'  && map[cRow - 1][cCol] != 1){
                map[cRow - 1][cCol] = 1;
                searchQue.offer(ind - col);
            }
            if((cCol + 1 < col) && board[cRow][cCol + 1] == 'O' && map[cRow][cCol + 1] != 1){
                map[cRow][cCol + 1] = 1;
                searchQue.offer(ind + 1);
            }
            if((cCol - 1 >= 0) && board[cRow][cCol - 1] == 'O'  && map[cRow][cCol - 1] != 1){
                map[cRow][cCol - 1] = 1;
                searchQue.offer(ind - 1);
            }
        }
    }
    public static void main(String[] args){
    	solution sln = new solution();
    	String[] inp = {"XOXOXO","OXOXOX","XOXOXO","OXOXOX"};
    	char[][] input = new char[inp.length][inp[0].length()];
    	for(int i = 0; i < inp.length; i++){
    		input[i] = inp[i].toCharArray();
    	}
    	sln.solve(input);
    	System.out.println("[");
    	for(int i = 0; i < input.length; i++){
    		String ss = new String(input[i]);
    		System.out.println(ss);
    	}
    	System.out.println("]");
    }
}
