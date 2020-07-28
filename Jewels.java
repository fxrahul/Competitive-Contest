import java.util.LinkedList;
import java.util.Stack;

class Jewels{
    public static void main(String[] args){
        String s = "abccbda";
        int n = s.length();
        int maxScore = 0;
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i = 1 ; i < n ; i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }else{
                if(s.charAt(i) == st.peek()){
                    st.pop();
                    maxScore++;
                }else{
                    st.push(s.charAt(i));
                }
            }
        }
        System.out.println(maxScore);
    }
}