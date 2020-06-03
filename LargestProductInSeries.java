// https://www.hackerrank.com/contests/projecteuler/challenges/euler008/problem

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
            int noD = in.nextInt();
            int noB = in.nextInt();
            String no = in.next();
            long[] ar = new long[noD];


            for(int i=0;i<(no.length()-noB+1);i++){
                int start =i;
                int end  = start + noB -1;
                long product =1;
                // System.out.println("start" + "="+start + " "+"end"+"="+end);
                while(start <= end){
                    product = product * Integer.parseInt( String.valueOf(no.charAt(start)) );
                    start++;
                }


                ar[i]= product;
                // System.out.println(product + " "+ "start" + "="+start + " "+"end"+"="+end);

//           ar[i] = ar[i] * product;
//           if((end+1)<no.length()){
//               ar[end+1] = ar[end+1]*(1/product);
//           }
            }

//          for(int m =0;m<ar.length;m++){
//            System.out.println(ar[m]);
//        }

            //code

//        for(int c =1;c<ar.length;c++){
//            ar[c] = ar[c-1] * ar[c];
//        }



            long max = 0;
            for(int m=0; m<ar.length;m++){
                if(ar[m]>max){
                    max = ar[m];
                }
            }
//       // System.out.println(no.charAt(1));
//
            System.out.println(max);
        }
    }
}

