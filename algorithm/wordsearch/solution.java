package wordsearch;

public class solution {
    public boolean exist(char[][] board, String word) {
    	int m = board.length;
    	if (m == 0) return false;
    	int n = board[0].length;
    	if (word.length() == 0 || m * n < word.length()) return false;
    	boolean[][] visited = new boolean[m][n];
    	char[] cWord = word.toCharArray();
        for (int i = 0; i < m; i++){
        	for (int j = 0; j < n; j++){
        		if(searchword(board, i, j, cWord, 0, visited)) return true;
        	}
        }
        
        return false;
    }
    
    boolean searchword(char[][] board, int row, int col, char[] cWord, int ind, boolean[][] visited){
    	
    	if (row < 0 || row >= board.length) return false;
    	if (col < 0 || col >= board[0].length) return false;
    	if (visited[row][col] || board[row][col] != cWord[ind]) return false;
    	if (ind == cWord.length - 1) return true;
    	visited[row][col] = true;
    	if(searchword(board, row - 1, col, cWord, ind + 1, visited)) return true;
    	if(searchword(board, row + 1, col, cWord, ind + 1, visited)) return true;
    	if(searchword(board, row, col - 1, cWord, ind + 1, visited)) return true;
    	if(searchword(board, row, col + 1, cWord, ind + 1, visited)) return true;
    	visited[row][col] = false;
    	return false;
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	char[][] board = {
    			{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
    	};
    	System.out.println(sln.exist(board, "ABCCED"));
    	System.out.println(sln.exist(board, "SEE"));
    	System.out.println(sln.exist(board, "ABCB"));
    }
}
