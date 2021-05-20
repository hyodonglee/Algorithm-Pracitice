//baekjoon_9012_괄호

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            boolean flag = false;
            Stack<Character> st = new Stack<>();
            char[] chars = br.readLine().toCharArray();
            for(int j=0;j<chars.length;j++){
                if(chars[j] == '(') st.push('(');
                else {
                    if(st.isEmpty()){
                        sb.append("NO\n");
                        flag = true;
                        break;
                    }else{
                        if(st.peek() == '(') st.pop();
                        else {
                            sb.append("NO\n");
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if(!flag){
                if(st.isEmpty()) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        System.out.println(sb.toString());
    }
}