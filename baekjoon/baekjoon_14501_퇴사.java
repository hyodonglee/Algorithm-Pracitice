/*baekjoon_14501_Επ»η*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
	static int n;
	static int[] t;
	static int[] p;
	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String[] s =br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		int max=0;
		t = new int[n+2];
		p = new int[n+2];
		for(int i=1;i<=n;i++) {
			s = br.readLine().split(" ");
			
			int time = Integer.parseInt(s[0]);
			int profit = Integer.parseInt(s[1]);
			
			int next = i+time;
			if(p[i]>max)
				max=p[i];
			if(next>n+1) continue;
			if(p[next]<max+profit) {
				p[next]=max+profit;
			}

		}
		if(p[n+1]>max)
			max=p[n+1];
		System.out.println(max);
	}
	
}