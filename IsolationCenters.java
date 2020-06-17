// https://www.codechef.com/MAY20B/problems/CORUS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class IsolationCenter {
    public static long find(String s, int c){
        int finalCount = 0;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 97]++;
        }

        for(int j = 0;j < count.length;j++){
            if(count[j]>c){
                int remaining = count[j] - c;
                finalCount = finalCount + remaining;
            }
        }
        return finalCount;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int i = 0;
        while(i < testCase) {

            String[]  a = br.readLine().trim().split("\\s+");
            int numberOfPeople = Integer.parseInt(a[0]);
            int q = Integer.parseInt(a[1]);
            String s = br.readLine();

            for(int j = 0;j < q ; j++){
                int c = Integer.parseInt(br.readLine());
                long numberPendingQueue = find(s, c);
                System.out.println(numberPendingQueue);
            }
            i++;

        }
    }
}