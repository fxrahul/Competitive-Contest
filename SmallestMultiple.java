// https://www.hackerrank.com/contests/projecteuler/challenges/euler005/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            ArrayList<Integer> primes = new ArrayList<>();
            boolean primeOccurence[] = new boolean[n+1];
            for(int i=1;i<=n;i++){
                primeOccurence[i] = true;
            }

            for(int k = 2;k<=n;k++){
                if(primeOccurence[k] == true){
                    for(int j=k*k;j<=n;j=j+k){
                        primeOccurence[j] = false;
                    }

                }
            }

            for(int s=2;s<=n;s++){
                if(primeOccurence[s]== true){
                    //System.out.print(s+ " ");
                    primes.add(s);
                }
            }


            int lcm =1;
            for(int h=0;h<primes.size();h++){
                int c=0;
                while(Math.pow(primes.get(h),c)<=n){

                    c++;
                }

                lcm = lcm * (int)  Math.pow(primes.get(h),--c) ;


            }

            System.out.println(lcm);
        }
    }
}

