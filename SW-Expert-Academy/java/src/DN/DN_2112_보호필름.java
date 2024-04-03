package DN;

import java.util.*;

public class DN_2112_보호필름 {

    static int d;
    static int w;
    static int k;
    static int[][] film;
    static boolean[] visited;
    static int answer;

    static int[] a0;
    static int[] a1;

    static boolean performanceTest(int[][] filmCopy) {
        boolean answer = true;

        for (int x = 0; x < w; x++) {
            int count = 1;
            for (int y = 1; y < d; y++) {
                if (filmCopy[y][x] == filmCopy[y - 1][x]) {
                    count++;
                }
                else {
                    count = 1;
                }
                if (count == k) {
                    break;
                }
            }
            if (count < k) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }

    static int[][] addMedicine(int[][] filmCopy, int yIndex, int[] a) {
        filmCopy[yIndex] = a;
        return filmCopy;
    }

    static void dfs(int count, int yIndex, int[][] filmCopy) {
        if (performanceTest(filmCopy)) {
            answer = Math.min(answer, count);
            return;
        }

        if (yIndex == d) {
            return;
        }

        int[] temp = new int[w];
        System.arraycopy(filmCopy[yIndex], 0, temp, 0, w);

        dfs(count + 1, yIndex + 1, addMedicine(filmCopy, yIndex, a0));
        dfs(count + 1, yIndex + 1, addMedicine(filmCopy, yIndex, a1));
        dfs(count, yIndex + 1, addMedicine(filmCopy, yIndex, temp));
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {

            d = sc.nextInt();
            w = sc.nextInt();
            k = sc.nextInt();
            answer = Integer.MAX_VALUE;

            film = new int[d][w];
            visited = new boolean[w];

            a0 = new int[w];
            a1 = new int[w];
            Arrays.fill(a1, 1);

            for (int y = 0; y < d; y++) {
                for (int x = 0; x < w; x++) {
                    film[y][x] = sc.nextInt();
                }
            }

            dfs(0, 0, film.clone());

            System.out.printf("#%d %d\n", t, answer == Integer.MAX_VALUE ? -1: answer);

        }

        sc.close();

    }

}
