/*baekjoon_14500_테트로미노*/
//원래 의도는 dfs로 푸는 것이지 하드코딩을 하는 것이 아니다. 다음에 다시 풀어보자.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int n,m;
	static int[][] map;
	static int max=0;
	public static void main(String args[]) throws IOException {
		init();


	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		} // map생성
		
		solve();
		System.out.println(max);
	}

	public static void solve() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				get1(i, j);
				get2(i, j);
				get3(i, j);
				get4(i, j);
				get5(i, j);
				get6(i, j);
				get7(i, j);
				get8(i, j);
				get9(i, j);
				get10(i, j);
				get11(i, j);
				get12(i, j);
				get13(i, j);
				get14(i, j);
				get15(i, j);
				get16(i, j);
				get17(i, j);
				get18(i, j);
				get19(i, j);
			}
		}
	}
	
	public static void get1(int y, int x) {
		if(x>=0 && x+3<m) {
			int value = map[y][x] + map[y][x+1] + map[y][x+2] + map[y][x+3];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get2(int y, int x) {
		if(y>=0 && y+3<n) {
			int value = map[y][x] + map[y+1][x] + map[y+2][x] + map[y+3][x];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get3(int y, int x) {
		if(y>=0 && y+1<n && x>=0 && x+1<m) {
			int value = map[y][x] + map[y+1][x] + map[y+1][x+1] + map[y][x+1];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get4(int y, int x) {
		if(y>=0 && y+2<n && x>=0 && x+1<m) {
			int value = map[y][x] + map[y+1][x] + map[y+2][x] + map[y+2][x+1];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get5(int y, int x) {
		if(y-1>=0 && x+2<m) {
			int value = map[y][x] + map[y][x+1] + map[y][x+2] + map[y-1][x+2];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get6(int y, int x) {
		if(y+2<n && x+1<m) {
			int value = map[y][x] + map[y][x+1] + map[y+1][x+1] + map[y+2][x+1];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get7(int y, int x) {
		if(y+1<n && x+2<m) {
			int value = map[y][x] + map[y+1][x] + map[y][x+1] + map[y][x+2];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get8(int y, int x) {
		if(y-2>=0 && x+1<m) {
			int value = map[y][x] + map[y][x+1] + map[y-1][x+1] + map[y-2][x+1];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get9(int y, int x) {
		if(y+1<n && x+2<m) {
			int value = map[y][x] + map[y][x+1] + map[y][x+2] + map[y+1][x+2];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get10(int y, int x) {
		if(y+2<n && x+1<m) {
			int value = map[y][x] + map[y+1][x] + map[y+2][x] + map[y][x+1];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get11(int y, int x) {
		if(y+1<n && x+2<m) {
			int value = map[y][x] + map[y+1][x] + map[y+1][x+1] + map[y+1][x+2];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get12(int y, int x) {
		if(y+2<n && x+1<m) {
			int value = map[y][x] + map[y+1][x] + map[y+1][x+1] + map[y+2][x+1];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get13(int y, int x) {
		if(y-1>=0 && y<n && x+2<m) {
			int value = map[y][x] + map[y][x+1] + map[y-1][x+1] + map[y-1][x+2];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get14(int y, int x) {
		if(y+1<n && x+2<m) {
			int value = map[y][x] + map[y][x+1] + map[y+1][x+1] + map[y+1][x+2];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get15(int y, int x) {
		if(y+2<n && x<m && x-1>=0) {
			int value = map[y][x] + map[y+1][x] + map[y+1][x-1] + map[y+2][x-1];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get16(int y, int x) {
		if(y+1<n && x+2<m) {
			int value = map[y][x] + map[y][x+1] + map[y][x+2] + map[y+1][x+1];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get17(int y, int x) {
		if(y+2<n && x+1<m) {
			int value = map[y][x] + map[y+1][x] + map[y+2][x] + map[y+1][x+1];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get18(int y, int x) {
		if(y-1>=0 && y<n && x+2<m) {
			int value = map[y][x] + map[y][x+1] + map[y-1][x+1] + map[y][x+2];
			if(max<value) max=value;
			return;
		}
		return;
	}
	
	public static void get19(int y, int x) {
		if(y-1>=0 && y+1<n && x+1<m) {
			int value = map[y][x] + map[y][x+1] + map[y+1][x+1] + map[y-1][x+1];
			if(max<value) max=value;
			return;
		}
		return;
	}
}