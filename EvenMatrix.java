import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EvenMatrix {
    public static boolean even(int n){
        return (n & 1) == 0;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase ; i++){
            int number = Integer.parseInt(br.readLine());
            int range = number * number;
            if(!even(number)){
                for(int j = 1 ; j <= range ; j++) {
                    System.out.print(j + " ");
                    if (j % number == 0) {
                        System.out.println();
                    }
                }
            }else{
                int odd = 1;
                int even = 2;
                boolean oddFlag = true;
                for(int j = 1 ; j <= range ; j++) {
                    if(oddFlag){
                        System.out.print(odd + " ");
                        odd += 2;
                        oddFlag = false; // odd is printed so odd will now become false
                    }else{
                        System.out.print(even + " ");
                        even += 2;
                        oddFlag = true; // even is printed so odd will now become true
                    }
                    if(j % number == 0){
                        if(oddFlag){
                            oddFlag = false;
                        }else{
                            oddFlag = true;
                        }
                        System.out.println();
                    }
                }

            }

        }
    }
}
