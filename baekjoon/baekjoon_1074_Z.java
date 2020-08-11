/*baekjoon_1074_Z*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, n, m;
	static int start = 0;
	static int end = 0;
	static int cnt=0;
	public static void main(String args[]) throws IOException {
		init();
		solve(0, 0, (int)Math.pow(2, N)-1, (int)Math.pow(2, N)-1, end, cnt);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		n = Integer.parseInt(s[1]);
		m = Integer.parseInt(s[2]);
		
		start = 0;
		end = (int)Math.pow(2, N)*(int)Math.pow(2, N);
		cnt = (int)Math.pow(2, N-1);
	}

	public static void solve(int sy, int sx, int ey, int ex, int end, int cnt){
		if(sy<=n && n<=ey && sx<=m && m<=ex) {
			if(ey-sy==1 && ex-sx==1) {
				if(n == sy && m == sx) System.out.println(end-4);
				else if(n==sy && m==ex) System.out.println(end-3);
				else if(n==ey && m == sx) System.out.println(end-2);
				else if(n==ey && m == ex) System.out.println(end-1);
				return;
			}
			solve(sy, sx, (sy+ey)/2, (sx+ex)/2, end-3*cnt*cnt, cnt/2);
			solve(sy, (sx+ex)/2+1, (sy+ey)/2, ex, end-2*cnt*cnt, cnt/2);
			solve((sy+ey)/2+1, sx, ey, (sx+ex)/2, end-cnt*cnt, cnt/2);
			solve((sy+ey)/2+1, (sx+ex)/2+1, ey, ex, end, cnt/2);
		}
		return;
	}
}