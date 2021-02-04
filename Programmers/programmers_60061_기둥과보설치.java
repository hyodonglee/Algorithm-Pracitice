//programmers_60061_기둥과 보 설치

import java.io.*;

public class Main {
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        int[][] arr = {
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {2, 1, 0, 1},
                {2, 2, 1, 1},
                {5, 0, 0, 1},
                {5, 1, 0, 1},
                {4, 2, 1, 1},
                {3, 2, 1, 1}
        };

        int n = 5;
        map = new int[n][n];

        int[][] ans = solution(n, arr);


    }

    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};


        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];//기둥인지 보인지
            int b = build_frame[i][3];//설치할지 삭제할지

            make(x, y, a, b);
            //-1은 보, 1은 기둥
        }

        return answer;
    }

    public static void make(int x, int y, int a, int b)
    {
        if (a == 0) {//기둥
            if (checkGidoong(y, x)) {
                if (b == 0) {
                    map[y][x] = 1;
                    map[y + 1][x] = 1;
                } else {
                    if (map[y + 1][x]==-1){
                        if(map[y+1][x+1]==1){
                            if(inBound(y,x+1) && map[y][x+1]==1)
                        }
                    }
                }
            }
        } else {//보
            if (checkBo(y, x)) {
                if(b==0){
                    map[y][x]=-1;
                    map[y][x+1]=-1;
                }else{
                    if(map[y][x+1]==1){
                        if(inBound(y+1, x+1) && map[y+1][x+1]==1){
                            return;
                        }else{
                            if(inBound(y-1, x) && map[y-1][x]==)
                                map[y][x]=0;
                        }
                    }else if(map[y][x+1]==-1){

                    }else{

                    }
                }
            }
        }
    }

    public static boolean checkGidoong(int y, int x) {
        if (inBound(y, x) && inBound(y + 1, x)) {
            if (y == 0 || map[y][x] != 0)
                return true;
            return false;
        }
        return false;
    }

    public static boolean checkBo(int y, int x) {
        if (inBound(y, x) && inBound(y, x + 1)) {
            if (map[y][x] == 1 || map[y][x + 1] == 1 || (map[y][x] == -1 && map[y][x + 1] == -1))
                return true;
            return false;
        }
        return false;
    }

    public static boolean inBound(int y, int x) {
        if (y >= 0 && x >= 0 && y <= n - 1 || x <= n - 1) return true;
        return false;
    }
}