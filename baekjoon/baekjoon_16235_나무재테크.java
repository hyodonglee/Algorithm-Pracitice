/*baekjoon_16235_나무재테크*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
   static int n, m, k;
   static int[][] add;
   static int[][] fuel;
   static Deque<Pair> tree = new ArrayDeque<>();
   static Deque<Pair> fert = new ArrayDeque<>();

   static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
   static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] s = br.readLine().split(" ");
      n = Integer.parseInt(s[0]);
      m = Integer.parseInt(s[1]);
      k = Integer.parseInt(s[2]);

      fuel = new int[n][n];
      add = new int[n][n];
      
      for(int i=0;i<n;i++) {
         for(int j=0;j<n;j++)
            fuel[i][j]=5;
      }
      
      for(int i=0;i<n;i++) {
         s = br.readLine().split(" ");
         for(int j=0;j<n;j++)
            add[i][j]=Integer.parseInt(s[j]);
      }
      
      for(int i=0;i<m;i++) {
         s = br.readLine().split(" ");
         int age = Integer.parseInt(s[2]);
         
         if(i==0) {
        	 tree.offerFirst(new Pair(Integer.parseInt(s[0])-1, Integer.parseInt(s[1])-1, age));
        	 continue;
         }
         if(tree.peek().age>=age) {
        	 tree.offerFirst(new Pair(Integer.parseInt(s[0])-1, Integer.parseInt(s[1])-1, age));
         }else {
        	 tree.offerLast(new Pair(Integer.parseInt(s[0])-1, Integer.parseInt(s[1])-1, age));
         }
      }
      
      while(k>0) {
         k--;

         //spring
         Deque<Pair> tempTree = new ArrayDeque<>();
         while(!tree.isEmpty()) {
        	 Pair p = tree.poll();
        	 
        	 if(fuel[p.y][p.x]<p.age) {
        		 fert.offer(p);
        	 }else {
        		 fuel[p.y][p.x]-=p.age;
        		 p.age++;
        		 tempTree.offer(p);
        	 }
         }
         tree = tempTree;
         
         //summer
         while(!fert.isEmpty()) {
        	 Pair p = fert.poll();
        	 fuel[p.y][p.x]+=p.age/2;
         }
         
         //fall
         tempTree = new ArrayDeque<>();
         while(!tree.isEmpty()) {
        	 Pair p = tree.peek();
        	 tempTree.offer(p);
        	 tree.poll();
        	 
        	 if(p.age%5==0) {
        		 for(int j=0;j<8;j++) {
                     int ny = p.y+dy[j];
                     int nx = p.x+dx[j];
                     
                     if(!isBorder(ny, nx)) {
                        tempTree.offerFirst(new Pair(ny, nx, 1));
                     }
                  }
        	 }
         }
         tree = tempTree;
         
         //winter
         for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
               fuel[i][j]+=add[i][j];
            }
         }
      }
      
      System.out.println(tree.size());
   }

   public static boolean isBorder(int y, int x) {
      if (y < 0 || x < 0 || y > n - 1 || x > n - 1)
         return true;
      return false;
   }

   public static class Pair{
      int y;
      int x;
      int age;

      public Pair(int y, int x, int age) {
         this.y = y;
         this.x = x;
         this.age = age;
      }
   }
}