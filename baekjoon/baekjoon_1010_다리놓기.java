import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
	
		k = Integer.parseInt(s[0]);
		
		for(int i=0;i<k;i++) {
			s = br.readLine().split(" ");
			
			int m = Integer.parseInt(s[0]);
			int n = Integer.parseInt(s[1]);
			
			System.out.println(combination(n, m));
		}
	}
	
	public static int combination(int n, int m) {
		if(n==m || m ==0) return 1;
		return combination(n-1, m-1)+combination(n-1, m);
	}
}
