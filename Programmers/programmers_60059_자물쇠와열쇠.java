//programmers_60059_자물쇠와열쇠

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        int key[][] = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };

        int lock[][] = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        boolean check = false;
        int n = lock[0].length;
        int m = key[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(lock[i][j]==0){
                    check = true;
                    break;
                }
            }
            if(check) break;
        }
        if(!check) return true;

        int map[][] = new int[3*n][3*n];
        for(int i=n;i<2*n;i++) {
            for(int j=n;j<2*n;j++){
                map[i][j]=lock[i-n][j-n];
            }
        }

        int origin[][] = new int[3*n][3*n];
        for(int i=0;i<3*n;i++){
            for(int j=0;j<3*n;j++){
                origin[i][j] = map[i][j];
            }
        }

        int cnt=4;

        while(cnt>0){
            for(int sx=0; sx<=2*n-1;sx++){
                for(int sy=0; sy<=2*n-1;sy++){
                    //시작점 정하기
                    boolean flag = true;

                    for(int i=0;i<3*n;i++){
                        for(int j=0;j<3*n;j++){
                            map[i][j] = origin[i][j];
                        }
                    }

                    for(int i=sx;i<sx+m;i++){
                        for(int j=sy;j<sy+m;j++){
                                map[i][j] += key[i-sx][j-sy];
                        }
                    }

                    for(int t=n;t<2*n;t++) {
                        for(int s=n;s<2*n;s++){
                            if(map[t][s]!=1){
                                flag = false;
                                break;
                            }
                        }
                        if(!flag) break;
                    }

                    if(flag) return true;
                }
            }

            int[][] newkey = rotate(key);
            key = newkey;
            cnt--;
        }
        return answer;
    }

    public static int[][] rotate(int[][] arr){
        int n = arr.length;
        int[][] rotate = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rotate[i][j] = arr[n-1-j][i];
            }
        }

        return rotate;
    }
}
