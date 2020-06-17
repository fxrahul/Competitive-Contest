// https://www.hackerrank.com/contests/projecteuler/challenges/euler004/problem

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
            int n1 = in.nextInt();
            int n =n1-1;
            int flag = 0;
            while(1==1){
                String noo = Integer.toString(n);
                String no = "a" + noo + "b";
                int back = 4;
                int front =3;
                while(no.charAt(front) == no.charAt(back)){
                    front--;
                    back++;
                }
                if(back>6){
                    for (int i=999;i>=102;i--){
                        for(int j=102;j<=999;j++){
                            if(i*j==n){
                                flag = 1;
                            }
                        }
                    }
                }
                if(flag ==0){
                    n--;
                }else{
                    break;
                }
            }
            System.out.println(n);
        }
    }
}

