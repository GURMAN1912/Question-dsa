import java.util.ArrayList;
import java.util.List;

public class Nqueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        boolean [][] board=new boolean[n][n];
        queen(board,0,ans);
        return ans;
    }
    private void queen(boolean [][]board,int r,List<List<String>>ans){
        if(r==board.length){
            ans.add(construct(board));
            return;            
        }
        for(int c=0;c<board.length;c++){
            if(isSafe(board,r,c)){
                board[r][c]=true;
                queen(board,r+1,ans);
                board[r][c]=false;
            }
        }
        return;
    }
    private boolean isSafe(boolean [][] board,int r,int c){
        //vertical
        for(int i=0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }
         for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }
        
        // Check right diagonal
        for (int i = r, j = c; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) return false;
        }
        return true;
    }
    private List <String> construct(boolean [][]board){
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                s.append(board[i][j] ? 'Q' : '.');
            }
            temp.add(s.toString());
        }
        return temp;
    }
    public static void main(String[] args) {
        Nqueen ob=new Nqueen();
        List<List<String>> ans=ob.solveNQueens(4);
        System.err.println(ans);
    }
}
