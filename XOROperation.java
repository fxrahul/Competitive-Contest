import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class XOROperation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase ; i++){
            String number = br.readLine();
            int n = number.length();
            int k = Integer.parseInt(br.readLine());
            char[] number2 = new char[n];
            Arrays.fill(number2, '0');
            for(int j = 0 ; j < n ; j++){
                if(k <= 0){
                    break;
                }
                if(number.charAt(j) == '0'){
                    number2[j] = '1';
                    k--;
                }
            }
            for(int l = 0 ; l < n ; l++){
                System.out.print(number2[l]);
            }
        }
    }
}
