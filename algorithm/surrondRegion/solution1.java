package surrondRegion;

public class solution1 {
    public void solve(char[][] board) {
        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;
        UF myUf = new UF(row * col + 1);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O' && (i == 0 || i == row - 1 || j == 0 || j == col - 1 ))
                    myUf.connect(i * col + j, row * col);
                if(i < row - 1 && j < col - 1 && board[i][j] == 'O'){
                    if(board[i + 1][j] == 'O') myUf.connect(i * col + j, i * col + j + col);
                    if(board[i][j + 1] == 'O') myUf.connect(i * col + j, i * col + j + 1);
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!myUf.connected(i * col + j, row * col)) board[i][j] = 'X';
            }
        }
    }
    
    class UF{
        private int[] weight;
        private int[] uid;
        private int size;
        public UF(int capacity){
            weight = new int[capacity];
            uid = new int[capacity];
            size = capacity;
            for(int i = 0; i < capacity; i++){
              uid[i] = i;
              weight[i] = 1;
            }
        }
        
        public int size(){
            return size;
        }
        
        public int find(int p){
            int start = p, tmp;
            while(uid[p] != p){
                p = uid[p];
            }
            // path compression
            while(uid[start] != p){
                tmp = uid[start];
                uid[start] = p;
                start = tmp;
            }
            return p;
        }
        
        public boolean connected(int p, int q){
            return find(p) == find(q);
        }
        
        public void connect(int p, int q){
            int pid = find(p);
            int qid = find(q);
            if(pid == qid) return;
            if(weight[pid] > weight[qid]){
                uid[qid] = pid;
                weight[pid] += weight[qid];
            }else{
                uid[pid] = qid;
                weight[qid] += weight[pid];
            }
            size--;
        }
    }
    public static void main(String[] args){
    	solution1 sln = new solution1();
    	String[] inp = {"XOXX","OXOX","XOXO","OXOX","XOXO","OXOX"};
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
