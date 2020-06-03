// https://www.hackerrank.com/contests/projecteuler/challenges/euler006/problem

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
            int no = in.nextInt();
            long n = (long) no;
            long sumOfSquares = ( n*(n+1)*(2*n+1) ) / 6;
            long squareOfSum = (long) Math.pow(( (n * (n+1) ) / 2), 2) ;
            System.out.println(Math.abs( squareOfSum - sumOfSquares) );
        }
    }
}

