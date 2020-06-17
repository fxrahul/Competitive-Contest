// https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem

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
            long no3= (n-1)/3;
            long no5 = (n-1)/5;
            long no3_mul_5 = (n-1)/15;
            // System.out.println(no3+" "+no5+" "+no3_mul_5);
            long s_no3 = ( (no3)*(2*3+ (no3-1)*3) )/2;
            long s_no5 = ( (no5)*(2*5+ (no5-1)*5) )/2;
            long s_no3_mul_5 = ( (no3_mul_5)*(2*15+ (no3_mul_5-1)*15) )/2;
            //  System.out.println(s_no3+" "+s_no5+" "+s_no3_mul_5);
            // // int total =  ((int)s_no3+(int)s_no5+(int)s_no3_mul_5);
            // //  System.out.println(total);

            System.out.println(s_no3+s_no5-s_no3_mul_5);

        }
    }
}

