/*baekjoon_9663_N-Queen*/
import java.util.*;

public class Main{
	static int n;
	static boolean[][] board;
	static boolean flag = false;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new boolean[n][n];
		queen(0);
		
		System.out.println(count);
	}
	
	public static void queen(int cnt) {
		if(cnt == n) {
			count++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			board[cnt][i]=true;
			if(check(cnt, i)) {
				queen(cnt+1);
			}
			board[cnt][i]=false;
		}
		
	}
	
	public static boolean check(int y, int x) {
		for(int i=0;i<n;i++) {
			if(i!=y && board[i][x]) return false;
			if(i!=x && board[y][i]) return false;
		}
		
		int i=y-1;
		int j=x-1;
		
		while(i>=0 && j>=0) {
			if(board[i][j]) return false;
			i--;
			j--;
		}
		
		i=y+1;
		j=x-1;
		
		while(i<n && j>=0) {
			if(board[i][j]) return false;
			i++;
			j--;
		}
		
		i=y+1;
		j=x+1;
		
		while(i<n && j<n) {
			if(board[i][j]) return false;
			i++;
			j++;
		}
		
		i=y-1;
		j=x+1;
		
		while(i>=0 && j<n) {
			if(board[i][j]) return false;
			i--;
			j++;
		}
		
		return true;
		
	}
}