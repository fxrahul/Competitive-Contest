// https://www.codechef.com/JUNE20B/problems/EOEO

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class TomandJerryGame {
    public static  boolean twoFactor(long x){
        return x!=0 && ((x&(x-1)) == 0);
    }

    public static  boolean fourFactor(long x){
        return (x & 3) == 0;
    }


    public static boolean isOdd(long n){
        long isOdd = n & 1;
        return isOdd == 1;
    }

    public static long getFirstSetBitPos(long n)
    {
        return (long)((Math.log(n & -n)) / Math.log(2)) + 1;
    }


    public static void  main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCase ; i++){
            long tomValue = Long.parseLong(br.readLine());
            long possibleValues = 0;
            if(isOdd(tomValue)) { // when tom value is odd he will always lose
                possibleValues = tomValue / 2;
            }else{ // when tom value is even we have to check even values of jerry to see if we divide both values, jerry is winning or not
                if(!twoFactor(tomValue)){
                    long numberofElementsOfPower2 = getFirstSetBitPos(tomValue) ;
                    long number = (long) Math.pow(2, numberofElementsOfPower2);
//                    System.out.println("number: "+number);
                    possibleValues = tomValue / number;
                }
            }
            System.out.println(possibleValues);
        }
    }
}

