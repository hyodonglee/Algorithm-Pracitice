/*baekjoon_10830_행렬제곱*/
/*
 반례:
 B=1일때
 1000을 하면 0이 나와야함 */
/*
 다른 사람들의 코드를 보니 내코드가 매우 비효율적으로 길다는 것을 알았고 다음에 다시 코딩해봐야겠다.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long[][] a;
	static int n;
	static long m;

	public static void main(String args[]) throws IOException {
		init();
		long[][] ans = solve(1, m);
		print_arr(ans);
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Long.parseLong(s[1]);

		a = new long[n][n];

		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");

			for (int j = 0; j < n; j++) {
				a[i][j] = Long.parseLong(s[j]);
			}
		} // 행렬 받기
	}

	public static long[][] mult(long[][] arr1, long[][] arr2) {
		long[][] c = new long[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					c[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				c[i][j]%=1000;
		}
		return c;
	}

	public static long[][] solve(long start, long end) {
		if(start==end) return a;
		else if(start==end-1) {
			return mult(a, a);
		}
		long mid = (start+end)/2;
		//case나눠서 계산 줄이기
		long cnt = end-start+1;
		if(cnt%2==0) {
			long[][] temp = solve(start, mid);
			return mult(temp, temp);
		}
		else {
			long[][] temp = solve(start, mid-1);
			return mult(mult(temp, a), temp);
		}
	}
	
	public static void print_arr(long[][] ans) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(ans[i][j]==1000)ans[i][j]=0;
				System.out.print((int)ans[i][j]+ " ");
			}
			System.out.println();
		}
	}
}