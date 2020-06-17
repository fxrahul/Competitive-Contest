import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.codechef.com/JUNE20B/problems/TTUPLE
class TTuple {
    public static Map mostFrequent(long[] arr, int n)
    {

        // Insert all elements in hash
        Map<Long, Long> hp =
                new HashMap<>();

        for(int i = 0; i < n; i++) {
            if (arr[i] != Long.MIN_VALUE) {
                long key = arr[i];
                if (hp.containsKey(key)) {
                    long freq = hp.get(key);
                    freq++;
                    hp.put(key, freq);
                } else {
                    hp.put(key, 1L);
                }
            }
        }

        return hp;

    }
    public static boolean equal(long[] tuple1, long[] tuple2){
        for(int i = 0 ; i < 3; i++){
            if(tuple1[i] != tuple2[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase ; i++){
            String s1 = br.readLine();
            String[] tuple1String = s1.split(" ");
            String s2 = br.readLine();
            String[] tuple2String = s2.split(" ");

            long[] tuple1 = new long[3];
            for(int j = 0 ; j < 3 ; j++){
                tuple1[j] = Long.parseLong(tuple1String[j]);
            }

            long[] tuple2 = new long[3];
            for(int j = 0 ; j < 3 ; j++){
                tuple2[j] = Long.parseLong(tuple2String[j]);
            }

            int operations = 0;

//            while(!equal(tuple1,tuple2)){
//                long[] resultTupleAddition = new long[3];
//                long[] resultTupleMultiplication = new long[3];
//
//                for(int k = 0 ; k < 3 ; k++){
//                    if(tuple1[k] != tuple2[k]) {
//                        resultTupleAddition[k] = tuple2[k] - tuple1[k];
//                        if (tuple1[k]!=0 && tuple2[k] % tuple1[k] == 0) {
//                            resultTupleMultiplication[k] = tuple2[k] / tuple1[k];
//                        }
//                    }
//                }
//                long[] resultAddition = mostFrequent(resultTupleAddition, 3);
//                long[] resultMultiplication = mostFrequent(resultTupleMultiplication, 3);
//                if(resultAddition[1] <= resultMultiplication[1]){
//                    //do multiplication
//                    for(int l = 0 ; l < 3 ; l++){
//                        if(tuple1[l] != tuple2[l]){
//                            tuple1[l] = tuple1[l] * resultMultiplication[0];
//                        }
//                    }
//                }else{
//                    // do addition
//                    for(int l = 0 ; l < 3 ; l++){
//                        if(tuple1[l] != tuple2[l]){
//                            tuple1[l] = tuple1[l] + resultAddition[0];
//                        }
//                    }
//                }
//                operations++;
//            }
//
//            System.out.println(operations);

            if(!equal(tuple1,tuple2)){
                long[] resultTupleAddition = new long[3];
                long[] resultTupleMultiplication = new long[3];

                for(int k = 0 ; k < 3 ; k++){
                    if(tuple1[k] != tuple2[k]) {
                        resultTupleAddition[k] = tuple2[k] - tuple1[k];
                        if (tuple1[k]!=0 && tuple2[k] % tuple1[k] == 0) {
                            resultTupleMultiplication[k] = tuple2[k] / tuple1[k];
                        }else{
                            resultTupleMultiplication[k] = Long.MAX_VALUE - k; // something
                        }
                    }else{
                        resultTupleAddition[k] = Long.MIN_VALUE;
                        resultTupleMultiplication[k] = Long.MIN_VALUE;
                    }
                }
                Map<Long, Long> resultAddition = mostFrequent(resultTupleAddition, 3);
                Map<Long, Long> resultMultiplication = mostFrequent(resultTupleMultiplication, 3);
                System.out.println("addition: "+ resultAddition.size());
                System.out.println("multiplication: "+ resultMultiplication.size());
                if(resultAddition.size() > resultMultiplication.size()){
                    // consider multiplication
                    operations = resultMultiplication.size();
                }else{
                    operations= resultAddition.size();
                }
            }

            System.out.println(operations);

             double l = 1000000000;

        }

    }
}
