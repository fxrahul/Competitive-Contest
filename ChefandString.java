// https://www.codechef.com/JUNE20B/submit/XYSTR
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ChefandString {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String s = br.readLine();
            int n = s.length();
            int [] a = new int[n];
            int pair = 0;
            for(int j = 0 ; j < n-1 ; j++){
                if(s.charAt(j)=='x' && s.charAt(j+1) == 'y' && a[j] == 0 && a[j+1] == 0){
                    pair++;
                    a[j] = 1;
                    a[j+1] = 1;
                }
                if(s.charAt(j)=='y' && s.charAt(j+1) == 'x' && a[j] == 0 && a[j+1] == 0){
                    pair++;
                    a[j] = 1;
                    a[j+1] = 1;
                }
            }
            System.out.println(pair);
        }
    }
}
