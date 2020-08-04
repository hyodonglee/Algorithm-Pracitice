
/*baekjoon_8958_OX퀴즈*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			int cnt = 0;
			int total = 0;
			
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)=='O') {
					cnt = cnt+1;
					total = total + cnt;
				}
				else {
					cnt=0;
				}
			}
			
			bw.write(String.valueOf(total));
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
	}
}