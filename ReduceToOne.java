// https://www.codechef.com/MAY19B/problems/REDONE

import java.util.*;



/**
 *
 * @author 91755
 */
class HackerRank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        int s=1;
        while(s<=T){
            long N=sc.nextLong();
            //int[] a=new int[N];
            long total=0L;
//                    for(int i=0;i<N;i++){
//                        a[i]= i + 1;
//                    }

            //Arrays.sort(a);

            if(N==1){
                total = N;
            }else if(N==2){
                total = N+(N-1)+((long)N*(N-1));
            }else{
                total = N+(N-1)+((long)N*(N-1));
                for(long b=N-2;b>0;b--){
                    total = total %1000000007;
                    total =b+total+((long)b*total);


//                        total = total + (N-2) + ((N-2)*total);
                }

            }
            System.out.println(total%1000000007);
            s++;
        }
    }
}