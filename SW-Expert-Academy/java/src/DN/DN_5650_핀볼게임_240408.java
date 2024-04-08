package DN;

import java.util.*;

public class DN_5650_핀볼게임_240408 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int answer;
    static int N;
    static int[][] map;
    static WormWhole[] wormwholes;
    static Queue<Point> startpoints;
    static int xStart;
    static int yStart;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            answer = 0;
            N = sc.nextInt();
            map = new int[N][N];
            wormwholes = new WormWhole[11];
            startpoints = new LinkedList<>();

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    int temp = sc.nextInt();
                    map[y][x] = temp;

                    if (temp == 0) {
                        startpoints.offer(new Point(y, x));
                    }
                    else if (temp >= 6) {
                        if (wormwholes[temp] == null) wormwholes[temp] = new WormWhole(y, x);
                        else wormwholes[temp].addWormWhole(y, x);
                    }
                }
            }

            travel();

            System.out.printf("#%d %d\n", t, answer);
        }

        sc.close();
    }

    static class Point {
        public int x;
        public int y;

        Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static class WormWhole {
        public int x1;
        public int x2;
        public int y1;
        public int y2;

        public WormWhole(int y, int x) {
            this.x1 = x;
            this.y1 = y;
        }

        public void addWormWhole(int y, int x) {
            this.x2 = x;
            this.y2 = y;
        }

        public int[] meetWormWhole(int y, int x) {
            int[] temp = new int[2];

            if ((y == this.y1) && (x == this.x1)) {
                temp[0] = this.y2;
                temp[1] = this.x2;
            }
            else {
                temp[0] = this.y1;
                temp[1] = this.x1;
            }

            return temp;
        }
    }

    static int meetBlock(int direction, int d) {
        int dNew = -1;
        switch (direction) {
            case 1:
                if (d == 0) dNew = 2;
                else if (d == 1) dNew = 3;
                else if (d == 2) dNew = 1;
                else if (d == 3) dNew = 0;
                break;
            case 2:
                if (d == 0) dNew = 1;
                else if (d == 1) dNew = 3;
                else if (d == 2) dNew = 0;
                else if (d == 3) dNew = 2;
                break;
            case 3:
                if (d == 0) dNew = 3;
                else if (d == 1) dNew = 2;
                else if (d == 2) dNew = 0;
                else if (d == 3) dNew = 1;
                break;
            case 4:
                if (d == 0) dNew = 2;
                else if (d == 1) dNew = 0;
                else if (d == 2) dNew = 3;
                else if (d == 3) dNew = 1;
                break;
            case 5:
                if (d == 0) dNew = 2;
                else if (d == 1) dNew = 3;
                else if (d == 2) dNew = 0;
                else if (d == 3) dNew = 1;
                break;
        }
        return dNew;
    }

    static int meetWall(int d) {
        return (d + 2) % 4;
    }

    static void travel() {
        while (!(startpoints.isEmpty())) {
            Point temp = startpoints.poll();
            
            xStart = temp.x;
            yStart = temp.y;

            for (int i = 0; i < 4; i++) {
                // System.out.printf("\n>>> %d, %d\n", yStart, xStart);
                dfs(yStart, xStart, i, 0);
            }
        }
    }
    
    static void dfs(int y, int x, int d, int cnt) {

        if ((x < 0) || (x >= N) || (y < 0) || (y >= N)) { // 벽에 부딪히는 경우,
            d = meetWall(d);
            // ny = y;
            // nx = x;
            cnt++;
        }
        else if (map[y][x] == -1) { // 블랙홀
            answer = Math.max(answer, cnt);
            return;
        }
        else if (map[y][x] >= 6) { // 웜홀
            int[] p = wormwholes[map[y][x]].meetWormWhole(y, x);
            y = p[0];
            x = p[1];
        }
        else if (map[y][x] >= 1) { // 블록
            d = meetBlock(map[y][x], d);
            cnt++;
        }

        int ny = y + dy[d];
        int nx = x + dx[d];
        
        
        if ((nx == xStart) && (ny == yStart)) { // 출발 위치로!
            answer = Math.max(answer, cnt);
            return;
        }
        
        // try{
        //     Thread.sleep(100);
        // }catch(InterruptedException e){
        //     e.printStackTrace();
        // }
        
        // System.out.printf("%d, %d => %d, %d ~ %d\n", y, x, ny, nx, d);
        dfs(ny, nx, d, cnt);
    }
    
}