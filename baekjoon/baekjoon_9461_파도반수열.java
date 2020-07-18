import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = 101;
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			if(arr[i]>max)
				max = arr[i];
		}
		
		int k = max;
		long[] P = new long[k+1];
		Arrays.fill(P, 0);
		
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		
		for(int i=4;i<=k;i++) {
			P[i] = P[i-3]+P[i-2];
		}
		
		for(int i=0;i<n;i++)
			System.out.println(P[arr[i]]);
	}
}