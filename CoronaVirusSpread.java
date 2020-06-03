// https://www.codechef.com/MAY20B/problems/COVID19


import java.util.*;
import java.lang.*;
class Covid {

    static ArrayList<Integer> diffArray(ArrayList<Integer> a){
        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0;i<a.size()-1;i++){
            b.add(Math.abs(a.get(i+1)-a.get(i)));
        }
        return b;
    }
    static int Max(ArrayList<Integer> b){

        int count = 0;
        int max = 0;
        for(int j = 0;j < b.size();j++){
            if(b.get(j) <= 2){
                count++;
            }else{
                if(count > max) {
                    max = count;
                }
                count = 0;
            }

        }

        if(count>max){
            max = count;
        }
        return max+1;
    }

    static int Min(ArrayList<Integer> b){
        int min = Integer.MAX_VALUE;
        int count  = 0;
        for(int j = 0;j < b.size(); j++){
            if(b.get(j)<=2){
                count++;
            }else{
                if(count < min) {
                    min = count;
                }
                count = 0;
            }

        }

        if(count < min){
            min = count;
        }
        return min+1;
    }

    public static void main(String[] args){
//        ArrayList<ArrayList>
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int i = 0;
        while(i < testCase){
            int max = 0;
            int min= 0;
            int numberOfElements = sc.nextInt();
            ArrayList<Integer> elements = new ArrayList<>();
            for(int j=0;j<numberOfElements;j++){
                elements.add(sc.nextInt());
            }

            ArrayList<Integer> b = diffArray(elements);
            max = Max(b);
            min = Min(b);
            System.out.println(min + " "+ max);
            i++;
        }
    }
}
