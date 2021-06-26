//BOJ_1316_그룹단어체커

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0;i<n;i++){
            boolean[] alp = new boolean[26];
            char[] chars = br.readLine().toCharArray();

            boolean flag = false;
            char ch = 'A';
            for(int j=0;j<chars.length;j++){
                if(ch!=chars[j]){
                    flag = false;
                    ch = chars[j];
                    if(!alp[chars[j]-'a']){
                        alp[chars[j]-'a'] = true;
                    }else{
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(n-cnt);
    }
}