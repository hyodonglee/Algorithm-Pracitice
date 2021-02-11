//baekjoon_18310_안테나

import java.io.*;
import java.lang.*;
import java.util.*;
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(s[i]));
        }

        Collections.sort(list);
        System.out.println(list.get((list.size())/2-1));
    }
}



