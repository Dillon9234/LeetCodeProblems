import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(rowTest(board)&&colTest(board)&&sqTest(board))
            return true;
        return false;
    }

    private boolean rowTest(char[][] board){
        HashSet<Character> list = new HashSet<>();
        for(int i=0;i<9;i++){
            list.clear();
            for(int j=0;j<9;j++){
                if(board[i][j] == '.')
                    continue;
                if(!list.add(board[i][j]))
                    return false;
            }
        }
        return true;
    }

    private boolean colTest(char[][] board){
        HashSet<Character> list = new HashSet<>();
        for(int i=0;i<9;i++){
            list.clear();
            for(int j=0;j<9;j++){
                if(board[j][i] == '.')
                    continue;
                if(!list.add(board[j][i]))
                    return false;
            }
        }
        return true;
    }
    
    private boolean sqTest(char[][] board){
        HashSet<Character> list = new HashSet<>();
        int xOffset=0, yOffset=0;
        for(int i=0;i<9;i++){
            list.clear();
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    if(board[j+xOffset][k+yOffset] == '.')
                        continue;
                    if(!list.add(board[j+xOffset][k+yOffset]))
                        return false;
                }
            }
            if(i!=2&&i!=5)
                yOffset += 3;
            else{
                xOffset += 3;
                yOffset = 0;
            }
        }

        return true;
    }

}
