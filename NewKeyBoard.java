import java.util.LinkedList;

class NewKeyBoard {
    public static void  main(String[] args){
        String s = "ss";
        LinkedList<Character> ll = new LinkedList<>();
        int llCurrentIndex = -1;
        StringBuilder st = new StringBuilder();
        int n = s.length();
        boolean num = true;
        int i = 0;
        while(i < n){
            if(s.charAt(i) == '*'){
                if(llCurrentIndex >= 0) {
                    ll.remove(llCurrentIndex);
                    llCurrentIndex--;
                }
                i++;
            }else if(s.charAt(i) == '<'){
                llCurrentIndex = -1;
                i++;
            }else if(s.charAt(i) == '>'){
                llCurrentIndex = ll.size() - 1;
                i++;
            }else if(s.charAt(i) == '#'){
                num = !num;
                i++;
            }else if(Character.isDigit(s.charAt(i))){
                if(num) {
                    ll.add(llCurrentIndex+1,s.charAt(i));
                    llCurrentIndex++;
                }
                i++;
            }else{
                ll.add(llCurrentIndex+1,s.charAt(i));
                llCurrentIndex++;
                i++;
            }
        }
        for(Character c : ll){
            st.append(c);
        }
        System.out.println(st);
    }
}
