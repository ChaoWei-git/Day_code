class Solution {
    private int total =0 ;
    public int totalNQueens(int n) {
        if(n<1) return 0;
        char[][] board = new char[n][n];
        for(char[] row : board) {
            for(int j=0; j<n; j++) {
                row[j] = '.';
            }
        }
        backtracking(board, 0);
        return total;
    }
    private boolean backtracking(char[][] board, int colums){
        //place complete
        if(colums==board.length){
            //save board
            total +=1;
            return false; // return false so will backtrack
        }
        for(int i=0;i<board.length;i++){
            if(isSafe(board,colums,i)){
                board[i][colums] = 'Q';
                if(backtracking(board,colums+1)) return true;
                board[i][colums] = '.';
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int colums,int row){
        //search in current row
        for(int i=0;i<colums;i++){
            if(board[row][i] != '.') return false;
        }
        //search 左上角
        int step = Math.min(colums,row);
        while(step>0 ){
            if(board[row-step][colums-step]!='.') return false;
            step--;
        }
        //search 左下角
        step = 1;
        while(step+row<board.length&&colums-step>=0){
            if(board[row+step][colums-step]!='.') return false;
            step++;
        }
        return true;

    }
}