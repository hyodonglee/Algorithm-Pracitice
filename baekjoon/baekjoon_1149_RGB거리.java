import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int d[][];
	static int w[][];
	public static void main(String args[]) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		d = new int[n+1][3];
		w = new int[n+1][3];
		
		for(int i=1;i<n+1;i++) {
			String s[] = br.readLine().split(" ");			
			for(int j=0;j<3;j++)
				w[i][j] = Integer.parseInt(s[j]);
		}
		
		for(int i=0;i<3;i++)
			d[1][i]=w[1][i];
		
		for(int i=2;i<n+1;i++) {
			for(int j=0;j<3;j++) {
				if(j==0) {
					d[i][j]=Math.min(d[i-1][1], d[i-1][2])+w[i][j];
				}
				else if(j==1) {
					d[i][j]=Math.min(d[i-1][0], d[i-1][2])+w[i][j];
				}
				else {
					d[i][j]=Math.min(d[i-1][0], d[i-1][1])+w[i][j];
				}
					
			}
		}
		
		int minD = Math.min(d[n][0], d[n][1]);
		minD = Math.min(d[n][2], minD);
		System.out.println(minD);
		
	}
	
}