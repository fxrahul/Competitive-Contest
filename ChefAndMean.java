// https://www.codechef.com/JULY19B/problems/CHFM

import java.util.*;

class ChefandMEan {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int  i= 1;

        while(i<=N){
            int n = sc.nextInt();
            long sum=0;
            int coinNo = 0;

            long min = Long.MAX_VALUE;

            long[] a = new long[n];
            for(int j =0;j<n;j++){
                a[j] = sc.nextLong();
                sum = sum + a[j];
            }




            //calculating original arithmetic mean
            double originalAM = (double) sum / n  ;


            for(int k=0;k<n;k++){
                if( (  ( (double) sum - a[k] ) / (n-1) )  == originalAM ){

                    if( a[k]<min ){
                        min = a[k] ;
                        coinNo = k;
                    }

                }
            }
            if(min != Long.MAX_VALUE){
                System.out.println(coinNo+1);
            }else{
                System.out.println("Impossible");
            }

            i++;

        }
        //System.out.println();

    }

}