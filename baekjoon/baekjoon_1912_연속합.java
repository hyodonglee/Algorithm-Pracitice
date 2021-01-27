import java.io.*;

public class Main{
    static int d[];
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int maxNum;
        String s[];

        n = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");

        d = new int[n+1];
        arr = new int[n+1];

        for(int i=1;i<n+1;i++){
            arr[i] = Integer.parseInt(s[i-1]);
        }

        d[1]=arr[1];
        maxNum = d[1];

        for(int i=2;i<n+1;i++){
            d[i] = Math.max(d[i-1]+arr[i], arr[i]);
            maxNum = Math.max(d[i], maxNum);
        }

        System.out.println(maxNum);
    }

}