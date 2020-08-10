
/*baekjoon_1188_음식평론가*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	static int n, m;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		int total = m*n;
		int cnt=0;
		while(total>0) {
			int res = total - n;
			if(res!=0) {
				cnt++;
				int temp = res%m;
				if(temp==0) cnt--;
				
				total = res;
			}else {
				total = 0;
			}
		}
		
		System.out.println(cnt);
	}

}