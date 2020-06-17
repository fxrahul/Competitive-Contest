import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// https://www.codechef.com/JUNE20B/problems/CHFICRM
class ChefandIcecream {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++) {
            int arraySize = Integer.parseInt(br.readLine());
            String arrayString = br.readLine();
            String[] array = arrayString.split(" ");
            int[] a = new int[arraySize];
            int flag = 0;
            int coin5 = 0;
            int coin10 = 0;
            for(int k = 0 ; k < array.length; k++){
                a[k] = Integer.parseInt(array[k]);
                if(a[k] == 10){
                   if(coin5 > 0){
                       coin5--;
                       coin10++;
                   }else{
                       flag = 1;
                       break;
                   }
                }else if(a[k] == 15){
                    if(coin10 > 0){
                        coin10--;
                    }else if(coin5 >= 2){
                        coin5 = coin5 - 2;
                    }else{
                        flag = 1;
                        break;
                    }
                }else{
                    coin5++;
                }
            }
            if(flag == 1){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }

    }
}
