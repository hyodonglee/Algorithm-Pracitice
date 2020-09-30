import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, b, c;
	static long arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		long cnt = 0;
		for(int i=0;i<n;i++) {
			arr[i]-=(long)b;
			cnt++;
			
			if(arr[i]<=0) continue;
			
			long temp = arr[i]%c;
			if(temp==0)
				cnt+=arr[i]/(long)c;
			else
				cnt+=(arr[i]/(long)c+1);
		}
		
		System.out.println(cnt);
	}
}
