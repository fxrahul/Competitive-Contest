import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ChefAndCardGame {
    public static int calculateSum(int a){
        int sum = 0;
        while( a != 0){
            sum += (a % 10);
            a = a / 10;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase ; i++){
            int n = Integer.parseInt(br.readLine());
            int chefScore = 0;
            int montyScore = 0;
            for(int j = 0 ; j < n ; j++){
                String[] game = br.readLine().split(" ");
                int a = Integer.parseInt(game[0]);
                int b = Integer.parseInt(game[1]);
                int suma = calculateSum(a);
                int sumb = calculateSum(b);
                if(suma > sumb){
                    chefScore++;
                }
                else if(suma < sumb){
                    montyScore++;
                }else{
                    chefScore++;
                    montyScore++;
                }
            }
            if(chefScore > montyScore){
                System.out.println(0 + " "+ chefScore);
            }else if( chefScore < montyScore){
                System.out.println(1 + " " + montyScore);
            }else{
                System.out.println(2 + " " + chefScore);
            }
        }
    }
}
