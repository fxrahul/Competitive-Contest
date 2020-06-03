// https://www.hackerrank.com/contests/projecteuler/challenges/euler002/problem

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
            long n = in.nextLong();

            long a=0,b=2;
            long c=b*4+a;
            long sum=2;

            while(c<=n){
                sum= sum+c;
                a=b;
                b=c;
                c=b*4+a;
            }
            System.out.println(sum);
        }
    }
}

