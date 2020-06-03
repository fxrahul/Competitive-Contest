// https://www.hackerrank.com/contests/hack-the-interview-ii-global/challenges/maximal-char-requests

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMaxCharCount' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. 2D_INTEGER_ARRAY queries
     */
    public static class Node{
        public char c;
        public int count;
        public Node(char c, int count){
            this.c = c;
            this.count = count;
        }
    }

    public static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    public static Node findMax(Node left, Node right){
        int leftAsciiValue =  left.c;
        int rightAsciiValue = right.c;

        if(leftAsciiValue == rightAsciiValue){
            return new Node(left.c , (left.count+right.count));
        }else if(leftAsciiValue > rightAsciiValue){
            return new Node(left.c, left.count);
        }else{
            return new Node(right.c, right.count);
        }
    }

    public static void buildTree(String s, Node[] treeList, int start, int end, int treeNodeIndex){
        if(start == end ){
            treeList[treeNodeIndex] = new Node(s.charAt(start), 1);
            return;
        }

        int mid = getMid(start,end);

        buildTree(s, treeList, start, mid, 2*treeNodeIndex+1);
        buildTree(s, treeList, mid+1, end, 2*treeNodeIndex+2);

        treeList[treeNodeIndex] = findMax( treeList[2*treeNodeIndex+1], treeList[2*treeNodeIndex+2] );
    }

    public static Node getMaxCountUtil(int ss, int se, int qs, int qe, int si,Node[] treeList){
        if (qs <= ss && qe >= se)
            return treeList[si];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return new Node('\0',0);

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return findMax( getMaxCountUtil(ss, mid, qs, qe, 2 * si + 1, treeList),
                getMaxCountUtil(mid + 1, se, qs, qe, 2 * si + 2, treeList) );
    }


    public static Node getMaxCount(String s,int qs,int qe,Node[] treeList){
        return getMaxCountUtil(0, s.length() - 1, qs, qe, 0,treeList);
    }

    public static List<Integer> getMaxCharCount(String s, List<List<Integer>> queries) {
        // queries is a n x 2 array where queries[i][0] and queries[i][1] represents x[i] and y[i] for the ith query.
        List<Integer> maxList = new ArrayList<>();


        //building tree
        s = s.toLowerCase();

        int x = (int) (Math.ceil(Math.log(s.length()) / Math.log(2)));

        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        Node[] treeList = new Node[max_size];
        buildTree(s,treeList,0,s.length()-1,0);

        // for(int as = 0;as < treeList.length;as++){
        //     System.out.println(treeList[as].c+ " "+treeList[as].count);
        // }
        for(int l = 0; l< queries.size(); l++){
            Node result = getMaxCount(s,queries.get(l).get(0),queries.get(l).get(1),treeList);
            maxList.add(result.count);
        }


        return maxList;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> query = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                query.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = Result.getMaxCharCount(s, query);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
