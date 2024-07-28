import java.util.*;
public class tictactoe{
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                board[row][col]=' ';
            }
        }
        char player='X';
        boolean gameOver=false;
        while(!gameOver){
            printboard(board);
            Scanner t=new Scanner(System.in);
            System.out.print("Player "+player+" Enter :");
            int row=t.nextInt();
            int col=t.nextInt();
            if(board[row][col]==' '){
                board[row][col]=player;
                gameOver=hasWon(board, player);
                if(gameOver){
                    System.out.println("Player " +player+" has won");
                }
                else{
                    if(player=='X'){
                        player='O';
                    }
                    else{
                        player='X';
                    }
                }
            }
            else{
                System.out.println("Invalid Move.Try Again");
            }
            }
            printboard(board);
        }
    public static boolean hasWon(char[][]board, char player){
        //for rows
        for(int row=0;row<board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }
        //for col
        for(int col=0;col<board.length;col++){
            if(board[col][0]==player && board[col][1]==player && board[col][2]==player){
                return true;
            }
        }
        //for diagonal
            if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
                return true;
            }
            if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
                return true;
            }
            return false;
        }
    public static void printboard(char[][]board){
        for(int row=0;row< board.length;row++){
            for(int col=0;col< board[row].length;col++){
                System.out.print(board[row][col]+" "+" | ");
            }
            System.out.println();
        }
    }
}