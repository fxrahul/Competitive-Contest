import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.codechef.com/JUNE20B/problems/PRICECON
class ChefandPriceControl {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++){
            String s = br.readLine();
            String[] line1 = s.split(" ");
            int arraySize = Integer.parseInt(line1[0]);
            int K = Integer.parseInt(line1[1]);
            int[] a= new int[arraySize];
            String arrayString = br.readLine();
            String[] array = arrayString.split(" ");
            int loss = 0 ;
            for(int k = 0 ; k < array.length; k++){
                a[k] = Integer.parseInt(array[k]);
                if(a[k]>K){
                    int rem = a[k] - K;
                    loss+=rem;
            }
            }
            System.out.println(loss);
        }

    }
}
