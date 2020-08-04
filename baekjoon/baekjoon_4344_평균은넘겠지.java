
/*baekjoon_4344_평균은넘겠지*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
	static int c, n;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		c = Integer.parseInt(br.readLine());
		
		for(int i=0;i<c;i++) {
			String s = br.readLine();
			String[] str = s.split(" ");
			
			n = Integer.parseInt(str[0]);
			
			double total = 0;
			double avg = 0;
			double cnt = 0;
			for(int j=1;j<str.length;j++) {
				total+=Double.parseDouble(str[j]);
				avg = total/n;
			}
			for(int j=1;j<str.length;j++) {
				if(Double.parseDouble(str[j])>avg) {
					cnt++;
				}
			}
			
			double value = Math.round(100000*cnt/n);
			value/=1000;
			DecimalFormat df = new DecimalFormat("0.000");
			String v = df.format(value);
			System.out.println(v+"%");
		}
		br.close();
	}
}