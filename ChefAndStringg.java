import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ChefAndStringg {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase ; i++){
            int n = Integer.parseInt(br.readLine());
            long total = 0;
            String[] line1 = br.readLine().split(" ");
            int previousElement = Integer.parseInt(line1[0]);
            for(int j = 1 ; j < n ; j++){
                int currentElement = Integer.parseInt(line1[j]);
                total += Math.abs(currentElement - previousElement) - 1;
                previousElement = currentElement;
            }
            System.out.println(total);
        }
    }
}
