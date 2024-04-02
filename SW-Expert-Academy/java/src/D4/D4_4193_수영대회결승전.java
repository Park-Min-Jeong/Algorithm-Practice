package D4;

import java.util.*;

public class D4_4193_수영대회결승전 {

    static class xy {
        public int x;
        public int y;
        public int time;
    
        public xy(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }    

    static int answer;
    static int n;

    static int[][] pool;
    static boolean[][] visited;
    static int[] start;
    static int[] end;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs() {
        Queue<xy> queue = new LinkedList<>();
        queue.offer(new xy(start[1], start[0], 0));
        visited[start[0]][start[1]] = true;

        while (!(queue.isEmpty())) {
            xy curr = queue.poll();

            int x = curr.x;
            int y = curr.y;
            int time = curr.time;

            if (x == end[1] && y == end[0]) {
                answer = time;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((nx < 0) || (nx >= n) || (ny < 0) || (ny >= n)) continue;
                if (pool[ny][nx] == 1) continue;
                if (visited[ny][nx]) continue;

                if (pool[ny][nx] == 2) {
                    if (time % 3 == 2) {
                        queue.offer(new xy(nx, ny, time + 1));
                        visited[ny][nx] = true;
                    }
                    else {
                        queue.offer(new xy(x, y, time + 1));
                        visited[y][x] = true;
                    }
                }
                else if (pool[ny][nx] == 0) {
                    queue.offer(new xy(nx, ny, time + 1));
                    visited[ny][nx] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {

            answer = -1;
            n = sc.nextInt();

            pool = new int[n][n];
            visited = new boolean[n][n];
            start = new int[2];
            end = new int[2];

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    pool[y][x] = sc.nextInt();
                }
            }

            start[0] = sc.nextInt();
            start[1] = sc.nextInt();
            end[0] = sc.nextInt();
            end[1] = sc.nextInt();
                        
            bfs();

            System.out.printf("#%d %d\n", t, answer);

        }

        sc.close();

    }
}
