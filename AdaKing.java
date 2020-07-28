import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class AdaKing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase ; i++){
            int k = Integer.parseInt(br.readLine());
            char[][] chessBoard = new char[8][8];
            for(char[] row: chessBoard) {
                Arrays.fill(row, '.');
            }

            int row = 0;
            int col = 0;
            for(int j = 0 ; j < k; j++){
                if(row <= 7){
                    if(row ==0 && col == 0){
                        chessBoard[row][col] = 'O';
                    }else{
                        chessBoard[row][col] = '.';
                    }
                    if (col < 7) {
                        chessBoard[row][col + 1] = 'X';
                    }
                    if(row < 7){
                        chessBoard[row+1][col] = 'X';
                    }
                    if(row < 7 && col < 7){
                        chessBoard[row + 1][col + 1] = 'X';
                    }
                    col++;
                    if(col > 7){
                        col = 0;
                        row++;
                    }
                }else{
                    break;
                }

            }
            for(int m = 0 ; m < 8 ;m++){
                for(int n = 0 ; n < 8 ; n++){
                    System.out.print(chessBoard[m][n]);
                }
                System.out.println();
            }
        }
    }
}
