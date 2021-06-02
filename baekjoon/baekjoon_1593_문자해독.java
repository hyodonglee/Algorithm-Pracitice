//BOJ_1593_문자해독

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//꼭 조합을 구현해아 한다는 생각을 버리기,
class Main {
    static int n, m;
    static int cnt = 0;
    static char[] w;
    static char[] S;
    static int[] wAlpha = new int[52];
    static int[] sAlpha = new int[52];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        w = br.readLine().toCharArray();
        S = br.readLine().toCharArray();

        makeW();
        solution();
        System.out.println(cnt);
    }

    private static void makeW() {
        for(int i=0;i<n;i++){
            if(w[i]<'a') wAlpha[w[i]-'A']++;
            else wAlpha[w[i]-'a'+26]++;
        }
    }

    private static void solution() {
        int s=0, e=0, len=0;

        for(int i=0;i<m;i++){
            if(S[e]<'a') sAlpha[S[e]-'A']++;
            else sAlpha[S[e]-'a'+26]++;
            e++;
            len++;

            if(len==n){
                if(isSame()) {
                    cnt++;
                }
                if(S[s]<'a') sAlpha[S[s]-'A']--;
                else sAlpha[S[s]-'a'+26]--;
                s++;
                len--;
            }
        }
    }

    private static boolean isSame() {
        for (int i = 0; i < 52; i++) {
            if (wAlpha[i] != sAlpha[i]) {
                return false;
            }
        }
        return true;
    }
}