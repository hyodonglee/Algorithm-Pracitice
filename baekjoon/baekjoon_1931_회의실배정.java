import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        Point[] work = new Point[n];

        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            work[i] = new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        Arrays.sort(work, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.y > p2.y) {
                    return 1;
                }else if(p1.y == p2.y){
                    if(p1.x>p2.x) return 1;
                }
                return -1;
            }
        });

        int i = 0;
        int min = 0;
        int cnt = 0;
        while(i<n){
            if(min>work[i].x){
                i++;
                continue;
            }

            cnt++;
            min = work[i].y;
            i++;
        }

        System.out.println(cnt);
    }

}
