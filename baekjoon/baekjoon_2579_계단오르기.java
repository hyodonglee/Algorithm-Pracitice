import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] W;
	static int[][] D;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		W = new int[n+1];
		D = new int[n+1][2];
			
		for(int i=1;i<n+1;i++) {
			W[i]=Integer.parseInt(br.readLine());
		}
		
		if(n==1) {
			System.out.println(W[1]);
			return;
		}
			
		else if(n==2) {
			System.out.println(W[1]+W[2]);
			return;
		}
		
		
		D[0][0]=0;
		D[0][1]=0;

		W[0]=0;
		
		D[1][0]=W[1];
		D[1][1]=-999999+W[1];

		
		D[2][0]=W[2];
		D[2][1]=D[1][0]+W[2];
		
		if(n>=3) {
			int a,b;
			for(int i=3;i<n+1;i++) {
				a = D[i-2][0];
				b = D[i-2][1];
				
				D[i][0] = Math.max(a,b)+W[i];		
				D[i][1] = D[i-1][0]+W[i];
			}
		}
		int score = Math.max(D[n][0], D[n][1]);
		System.out.println(score);

	}

}