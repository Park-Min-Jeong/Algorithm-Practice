package DN;

import java.util.*;

public class DN_2105_디저트카페_240405 {

    static int N;
    static int[][] map;
    static int answer;
    static int max;

    static int[] dy = {1, 1, -1, -1};
    static int[] dx = {1, -1, -1, 1};

    static int yStart;
    static int xStart;

    static boolean check(int y, int x) {
        if ((y >= 0) && (y < N) && (x >= 0) && (x < N)) return true;
        return false;
    }

    static int calcDesert(boolean[] desert) {
        int answer = 0;
        for (int i = 0; i < desert.length; i++) {
            if (desert[i]) {
                answer++;
            }
        }
        return answer;
    }

    static void dfs(int y, int x, int a, int b, int d, boolean[] desert) {

        // 범위를 벗어나면
        if (!(check(y, x))) {
            return;
        }

        // 시작점에 다시 돌아오면
        if ((d > 0) && (a == 0) && (b == 0)) {
            int count = calcDesert(desert);
            answer = Math.max(answer, count);
            return;
        }

        // 한 번 이상 먹은 디저트
        if (desert[map[y][x]]) return;

        desert[map[y][x]] = true;

        if (d == 0) {
            // d -> 0
            dfs(y + dy[0], x + dx[0], a + 1, b, 0, desert.clone()); 
            // d -> 1
            dfs(y + dy[1], x + dx[1], a, b + 1, 1, desert.clone());
        }
        else if (d == 1) {
            // d -> 1
            dfs(y + dy[1], x + dx[1], a, b + 1, 1, desert.clone());
            // d -> 2
            dfs(y + dy[2], x + dx[2], a - 1, b, 2, desert.clone());
        }
        else if (d == 2) {
            // aCount만큼 d -> 2
            if (a > 0) dfs(y + dy[2], x + dx[2], a - 1, b, 2, desert.clone());
            // d -> 3으로 넘어가기
            else dfs(y + dy[3], x + dx[3], a, b - 1, 3, desert.clone()); 
        }
        else if (d == 3) {
            // bCount만큼 d -> 3
            dfs(y + dy[3], x + dx[3], a, b - 1, 3, desert.clone());
        }
    }

    static void findDesert() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                boolean[] desert = new boolean[max + 1];
                dfs(y, x, 0, 0, 0, desert);
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {

            N = sc.nextInt();
            map = new int[N][N];
            answer = -1;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    map[y][x] = sc.nextInt();

                    max = Math.max(max, map[y][x]);
                }
            }
            
            findDesert();
            
            System.out.printf("#%d %d\n", t, answer);

        }

        sc.close();

    }

}