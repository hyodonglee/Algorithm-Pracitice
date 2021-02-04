//programmers_60061_기둥과 보 설치

import java.io.*;

class Solution {
    static boolean[][] pillars, beams;
    static int count = 0;
    static final int PILLAR = 0;
    static final int BEAM = 1;
    static final int DESTRUCT = 0;
    static final int CONSTRUCT = 1;
    
    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        pillars = new boolean[n+3][n+3];
        beams = new boolean[n+3][n+3];

        for(int i=0;i<n+3;i++){
            for(int j=0;j<n+3;j++){
                pillars[i][j]=false;
                beams[i][j]=false;
            }
        }

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0]+1;
            int y = build_frame[i][1]+1;
            int shape = build_frame[i][2];//기둥인지 보인지
            int command = build_frame[i][3];//설치할지 삭제할지

            make(x, y, shape, command, n);
        }

        answer = new int[count][3];
        int k=0;
        for(int i=1;i<=n+1;i++){
            for(int j=1;j<=n+1;j++){
                if(pillars[i][j])
                    answer[k++] = new int[]{i-1, j-1, PILLAR};
                if(beams[i][j])
                    answer[k++] = new int[]{i-1, j-1, BEAM};
            }
        }

        return answer;
    }

    public static void make(int x, int y, int shape, int command, int n) {
        if(command==CONSTRUCT){
            if(shape==PILLAR){
                if(constructPillar(x, y)){
                    pillars[x][y]=true;
                    count++;
                }
            }else{
                if(constructBeam(x, y)){
                    beams[x][y]=true;
                    count++;
                }
            }
        }else{//command==DESTRUCT
            if(shape==PILLAR){
                pillars[x][y]=false;
            }else{
                beams[x][y]=false;
            }
            count--;

            if(!destruct(n)){
                count++;
                if(shape==PILLAR) pillars[x][y]=true;
                if(shape==BEAM) beams[x][y]=true;
            }

        }
    }

    public static boolean constructPillar(int x, int y){
        return y==1 || pillars[x][y-1] || beams[x][y] || beams[x-1][y];
    }

    public static boolean constructBeam(int x, int y){
        return pillars[x][y-1] || pillars[x+1][y-1] || (beams[x-1][y] && beams[x+1][y]);
    }

    public static boolean destruct(int n){
        for(int i=1;i<=n+1;i++){
            for(int j=1;j<=n+1;j++){
                if(pillars[i][j] && !constructPillar(i, j)) return false;
                if(beams[i][j] && !constructBeam(i, j)) return false;
            }
        }
        return true;
    }
}