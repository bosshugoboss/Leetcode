public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board.length == 0) return;
        for(int i = 0; i < board.length; i ++){
            if(board[i][0] == 'O')
            DFS(board, i, 0);
            if(board[i][board[0].length - 1] == 'O')
            DFS(board, i, board[0].length - 1);
        }
        for(int j = 1; j < board[0].length - 1; j ++){
            if(board[0][j] == 'O')
            DFS(board, 0, j);
            if(board[board.length - 1][j] == 'O')
            DFS(board, board.length - 1, j);
        }
        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j < board[0].length; j ++){
                if(board[i][j] == 'D') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    
    private void DFS(char[][] board, int x, int y){
            board[x][y] = 'D';
            if(x - 1 >= 0 && board[x-1][y] == 'O'){
                DFS(board, x - 1, y);
            }
            if(x + 1 < board.length && board[x+1][y] == 'O'){
                DFS(board, x + 1, y);
            }
            if(y - 1 >= 0 && board[x][y-1] == 'O'){
                DFS(board, x, y - 1);
            }
            if(y + 1 < board[0].length && board[x][y+1] == 'O'){
                DFS(board, x, y + 1);
            }
        }
    }
    
/* new */
public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board == null || board.length == 0) return;
        int width = board[0].length;
        int height = board.length;
        Queue<Integer> Xqueue = new LinkedList<Integer>();
        Queue<Integer> Yqueue = new LinkedList<Integer>();
        for(int i = 0; i < height; i ++){
            for(int j = 0; j < width; j ++){
                if(board[i][j] == 'O' && (i == 0 || i == height - 1 || j == 0 || j == width - 1)){
                    Xqueue.offer(i); Yqueue.offer(j);
                    board[i][j] = 'B';
                    while(!Xqueue.isEmpty()){
                        int x = Xqueue.poll();
                        int y = Yqueue.poll();
                        if(x - 1 >= 0 && board[x-1][y] == 'O'){
                           Xqueue.offer(x-1);
                           Yqueue.offer(y);
                           board[x-1][y] = 'B';
                        }
                        if(x + 1 < height && board[x+1][y] == 'O'){
                           Xqueue.offer(x+1);
                           Yqueue.offer(y);
                           board[x+1][y] = 'B';
                        }
                        if(y - 1 >= 0 && board[x][y-1] == 'O'){
                           Xqueue.offer(x);
                           Yqueue.offer(y-1);
                           board[x][y-1] = 'B';
                        }
                        if(y + 1 < width && board[x][y+1] == 'O'){
                           Xqueue.offer(x);
                           Yqueue.offer(y+1);
                           board[x][y+1] = 'B';
                        }
                    }
                }
            }
        }
        for(int i = 0; i < height; i ++){
            for(int j = 0; j < width; j ++){
                if(board[i][j] == 'B') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }   
}
