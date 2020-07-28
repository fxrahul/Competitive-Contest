import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class MissingPoint{
    public static boolean isOdd(long a){
        return (a & 1) == 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int noOfVertices = 4 * n - 1;
            Map<Long, LinkedList<Long>> horizontal = new HashMap<>();
            Map<Long, LinkedList<Long>> vertical = new HashMap<>();
            LinkedList<Long> xList;
            LinkedList<Long> yList;
            long xMissing = 0;
            long yMissing = 0;
            for (int k = 0; k < noOfVertices; k++) {
                String[] line = br.readLine().split(" ");
                long x = Long.parseLong(line[0]);
                long y = Long.parseLong(line[1]);
                if(horizontal.containsKey(x)){
                    yList = horizontal.get(x);
                    yList.add(y);
                    horizontal.put(x,yList);
                }else{
                    yList = new LinkedList<>();
                    yList.add(y);
                    horizontal.put(x,yList);
                }

                if(vertical.containsKey(y)){
                    xList = vertical.get(y);
                    xList.add(x);
                    vertical.put(y,xList);
                }else{
                    xList = new LinkedList<>();
                    xList.add(x);
                    vertical.put(y,xList);
                }
            }

            for(Map.Entry element : horizontal.entrySet()){
                LinkedList<Long> value = (LinkedList<Long>) element.getValue();
                if(isOdd(value.size())){
                    xMissing = (long) element.getKey();
                    break;
                }
            }

            for(Map.Entry element : vertical.entrySet()){
                LinkedList<Long> value = (LinkedList<Long>) element.getValue();
                if(isOdd(value.size())){
                    yMissing = (long) element.getKey();
                    break;
                }
            }
//            System.out.println("horizontal: "+horizontal);
//            System.out.println("vertical: "+vertical);

            System.out.println(xMissing + " " + yMissing);
        }
    }
}
