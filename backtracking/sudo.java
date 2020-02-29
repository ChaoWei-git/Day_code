class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    private boolean backtracking(char[][] board){
        int current_row = -1, current_col = -1;
        boolean isEmpty = true;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    current_col = j;
                    current_row = i;
                    isEmpty = false;
                    break;
                }
            }
            if(isEmpty) break;
        }
        if(isEmpty) return true;
        for(int num=1;num<=9;num++){
            if(isSafe(board, current_col, current_row, (char)(num + '0'))){
                board[current_row][current_col] = (char)(num + '0');
                if(backtracking(board)) return true;
                board[current_row][current_col] = '.';
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int col,int row,char num){
        for(int i=0;i<board.length;i++){
            if(row!=i&&board[i][col]==num) return false;
        }
        for(int i=0;i<board.length;i++){
            if(board[row][i]==num) return false;
        }
        
        int sqrt = (int) Math.sqrt(board.length); 
        int corner_row = row - row%sqrt,corner_col = col - col%sqrt;
        for(int i=corner_row;i<corner_row + sqrt;i++){
            for(int j=corner_col;j<corner_col + sqrt;j++){
                if(board[i][j]==num) return false;
            }
        }
        
        return true;
    }
}