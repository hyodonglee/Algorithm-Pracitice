import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int rx, ry, bx, by, ox, oy;
    static char[][] map;
    static Queue<Info> q = new LinkedList<>();
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = chars[j];
                if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'O') {
                    ox = i;
                    oy = j;
                }
            }
        }//map 받기

        q.add(new Info(rx, ry, bx, by, 0));

        while (!q.isEmpty()) {
            Info p = q.poll();
            if (p.rx == ox && p.ry == oy) {
                System.out.println(p.cnt);
                return;
            }
            //3가지 경우로 나누기
            //1. R, B가 가로, 세로 좌표가 다를경우
            int dirX, dirY, nrx, nry, nbx, nby;
            if (p.rx != p.bx && p.ry != p.by) {
                for (int i = 0; i < 4; i++) {
                    dirX = dx[i];
                    dirY = dy[i];

                    nrx = p.rx;
                    nry = p.ry;
                    nbx = p.bx;
                    nby = p.by;

                    //파랑이 구멍에 들어가는지 먼저 봐야함으로 파랑부터
                    boolean flag = false;
                    while (map[nbx + dirX][nby + dirY] != '#') {
                        nbx += dirX;
                        nby += dirY;

                        if (map[nbx][nby] == 'O') {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) continue;

                    while (map[nrx + dirX][nry + dirY] != '#') {
                        nrx += dirX;
                        nry += dirY;

                        if (map[nrx][nry] == 'O') {
                            break;
                        }
                    }

                    if (p.cnt < 10) q.add(new Info(nrx, nry, nbx, nby, p.cnt + 1));
                }
            } else if (p.rx == p.bx && p.ry != p.by) {//2. 가로같은 상황
                for (int i = 0; i < 4; i++) {
                    dirX = dx[i];
                    dirY = dy[i];

                    nrx = p.rx;
                    nry = p.ry;
                    nbx = p.bx;
                    nby = p.by;

                    if (i == 1 || i == 3) {//위,아래
                        //파랑이 구멍에 들어가는지 먼저 봐야함으로 파랑부터
                        boolean flag = false;
                        while (map[nbx + dirX][nby] != '#') {
                            nbx += dirX;

                            if (map[nbx][nby] == 'O') {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) continue;

                        while (map[nrx + dirX][nry] != '#') {
                            nrx += dirX;

                            if (map[nrx][nry] == 'O') {
                                break;
                            }
                        }

                        if (p.cnt < 10) q.add(new Info(nrx, nry, nbx, nby, p.cnt + 1));
                    } else if (i == 0) {//오른쪽
                        if (p.ry < p.by) {//RB
                            //파랑이 구멍에 들어가는지 먼저 봐야함으로 파랑부터
                            boolean flag = false;
                            while (map[nbx][nby + dirY] != '#') {
                                nby += dirY;

                                if (map[nbx][nby] == 'O') {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) continue;

                            while (map[nrx][nry + dirY] != '#' && nry + dirY < nby) {
                                nry += dirY;

                                if (map[nrx][nry] == 'O') {
                                    break;
                                }
                            }

                            if (p.cnt < 10) q.add(new Info(nrx, nry, nbx, nby, p.cnt + 1));
                        } else {//BR
                            //빨강부터 움직이기
                            while (map[nrx][nry + dirY] != '#') {
                                nry += dirY;

                                if (map[nrx][nry] == 'O') {
                                    break;
                                }
                            }

                            boolean flag = false;
                            while (map[nbx][nby + dirY] != '#' && nby + dirY < nry) {
                                nby += dirY;

                                if (map[nbx][nby] == 'O') {
                                    flag = true;
                                    break;
                                }
                            }
                            if (map[nbx][nby+dirY] == 'O') {
                                flag = true;
                            }
                            if (flag) continue;
                            if (p.cnt < 10) q.add(new Info(nrx, nry, nbx, nby, p.cnt + 1));
                        }
                    } else {//왼쪽 i==2
                        if (p.ry < p.by) {//RB
                            //빨강부터 움직이기
                            while (map[nrx][nry + dirY] != '#') {
                                nry += dirY;

                                if (map[nrx][nry] == 'O') {
                                    break;
                                }
                            }

                            boolean flag = false;
                            while (map[nbx][nby + dirY] != '#' && nby + dirY > nry) {
                                nby += dirY;

                                if (map[nbx][nby] == 'O') {
                                    flag = true;
                                    break;
                                }
                            }
                            if (map[nbx][nby+dirY] == 'O') {
                                flag = true;
                            }
                            if (flag) continue;
                            if (p.cnt < 10) q.add(new Info(nrx, nry, nbx, nby, p.cnt + 1));
                        } else {//BR
                            //파랑이 구멍에 들어가는지 먼저 봐야함으로 파랑부터
                            boolean flag = false;
                            while (map[nbx][nby + dirY] != '#') {
                                nby += dirY;

                                if (map[nbx][nby] == 'O') {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) continue;

                            while (map[nrx][nry + dirY] != '#' && nry + dirY > nby) {
                                nry += dirY;

                                if (map[nrx][nry] == 'O') {
                                    break;
                                }
                            }

                            if (p.cnt < 10) q.add(new Info(nrx, nry, nbx, nby, p.cnt + 1));

                        }
                    }
                }
            } else {//3. 세로같은상황
                for (int i = 0; i < 4; i++) {
                    dirX = dx[i];
                    dirY = dy[i];

                    nrx = p.rx;
                    nry = p.ry;
                    nbx = p.bx;
                    nby = p.by;

                    if (i == 0 || i == 2) {//왼쪽, 오른쪽
                        //파랑이 구멍에 들어가는지 먼저 봐야함으로 파랑부터
                        boolean flag = false;
                        while (map[nbx][nby + dirY] != '#') {
                            nby += dirY;

                            if (map[nbx][nby] == 'O') {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) continue;

                        while (map[nrx][nry + dirY] != '#') {
                            nry += dirY;

                            if (map[nrx][nry] == 'O') {
                                break;
                            }
                        }

                        if (p.cnt < 10) q.add(new Info(nrx, nry, nbx, nby, p.cnt + 1));
                    } else if (i == 1) {//위쪽
                        if (p.rx > p.bx) {//BR
                            //파랑이 구멍에 들어가는지 먼저 봐야함으로 파랑부터
                            boolean flag = false;
                            while (map[nbx + dirX][nby] != '#') {
                                nbx += dirX;

                                if (map[nbx][nby] == 'O') {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) continue;

                            while (map[nrx + dirX][nry] != '#' && nrx + dirX > nbx) {
                                nrx += dirX;

                                if (map[nrx][nry] == 'O') {
                                    break;
                                }
                            }

                            if (p.cnt < 10) q.add(new Info(nrx, nry, nbx, nby, p.cnt + 1));
                        } else {//RB
                            //빨강부터 움직이기
                            while (map[nrx + dirX][nry] != '#') {
                                nrx += dirX;

                                if (map[nrx][nry] == 'O') {
                                    break;
                                }
                            }

                            boolean flag = false;
                            while (map[nbx + dirX][nby] != '#' && nbx + dirX > nrx) {
                                nbx += dirX;

                                if (map[nbx][nby] == 'O') {
                                    flag = true;
                                    break;
                                }
                            }
                            if (map[nbx+dirX][nby] == 'O') {
                                flag = true;
                            }
                            if (flag) continue;
                            if (p.cnt < 10) q.add(new Info(nrx, nry, nbx, nby, p.cnt + 1));
                        }
                    } else {//아래쪽
                        if (p.rx < p.bx) {//RB
                            //파랑이 구멍에 들어가는지 먼저 봐야함으로 파랑부터
                            boolean flag = false;
                            while (map[nbx + dirX][nby] != '#') {
                                nbx += dirX;

                                if (map[nbx][nby] == 'O') {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) continue;

                            while (map[nrx + dirX][nry] != '#' && nrx + dirX < nbx) {
                                nrx += dirX;

                                if (map[nrx][nry] == 'O') {
                                    break;
                                }
                            }

                            if (p.cnt < 10) q.add(new Info(nrx, nry, nbx, nby, p.cnt + 1));
                        } else {//BR
                            //빨강부터 움직이기
                            while (map[nrx + dirX][nry] != '#') {
                                nrx += dirX;

                                if (map[nrx][nry] == 'O') {
                                    break;
                                }
                            }

                            boolean flag = false;
                            while (map[nbx + dirX][nby] != '#' && nbx + dirX < nrx) {
                                nbx += dirX;

                                if (map[nbx][nby] == 'O') {
                                    flag = true;
                                    break;
                                }
                            }
                            if (map[nbx+dirX][nby] == 'O') {
                                flag = true;
                            }
                            if (flag) continue;
                            if (p.cnt < 10) q.add(new Info(nrx, nry, nbx, nby, p.cnt + 1));
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }

    private static class Info {
        int rx, ry, bx, by, cnt;

        Info(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
}
