/*baekjoon_2447_별찍기10*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static char[][] map;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		
		map = new char[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				map[i][j]=' ';
		}
		
		make(n, 0, 0);
		
		for(int i=0;i<n;i++) {
				bw.write(map[i]);
			bw.write('\n');
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void make(int n, int y, int x) {
		if(n==1) {
			map[y][x]='*';
			return;
		}
		int div = n/3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				make(div, y + (div * i), x + (div * j));
			}
		}
		return;
	}
}