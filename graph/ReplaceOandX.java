package graph;

public class ReplaceOandX {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' &&!vis[i][0]){
                // vis[i][0]=true;
                dfs(vis,board,i,0);
            }
            if(board[i][n-1]=='O'&& !vis[i][n-1]){
                // vis[i][n-1]=true;
                dfs(vis,board,i,n-1);  
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O' &&!vis[0][i]){
                // vis[0][i]=true;
                dfs(vis,board,0,i);
            }
            if(board[m-1][i]=='O'&& !vis[m-1][i]){
                // vis[m-1][i]=true;
                dfs(vis,board,m-1,i);  
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }

    }
    private void dfs(boolean[][] visited, char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 'X') {
            return;
        }

        visited[i][j] = true;

        // Explore all four possible directions
        dfs(visited, grid, i - 1, j); // up
        dfs(visited, grid, i + 1, j); // down
        dfs(visited, grid, i, j - 1); // left
        dfs(visited, grid, i, j + 1); // right
    }
    public static void main(String[] args) {
        char[][]board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        int m=board.length;
        int n=board[0].length;
        ReplaceOandX obj=new ReplaceOandX();
        obj.solve(board);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j] +" ");
            }
            System.err.println();
        }
    }
}
