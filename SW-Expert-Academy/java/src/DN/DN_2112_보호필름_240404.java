package DN;

import java.util.*;

public class DN_2112_보호필름_240404 {

    static int answer;
    static int D;
    static int W;
    static int K;
    static int[][] film;
    static int[] m0;
    static int[] m1;

    static boolean test(int[][] filmCopy) {
        boolean result = true;

        for (int x = 0; x < W; x++) {
            int count = 1;

            for (int y = 1; y < D; y++) {
                if (filmCopy[y-1][x] == filmCopy[y][x]) count++;
                else count = 1;
                if (count == K) break; 
            }
            
            if (count < K) {
                result = false;
                return result;
            }
        }

        return result;
    }

    static int[][] addMedicine(int[][] filmCopy, int index, int[] medicine) {
        filmCopy[index] = medicine;
        return filmCopy;
    }

    static void dfs(int index, int count, int[][] filmCopy) {
        if (test(filmCopy)) {
            if (count < answer) answer = count;
            return;
        }
        if (index == D) return;

        int[] temp = filmCopy[index];
        dfs(index + 1, count + 1, addMedicine(filmCopy, index, m0));
        dfs(index + 1, count + 1, addMedicine(filmCopy, index, m1));
        dfs(index + 1, count, addMedicine(filmCopy, index, temp));
    }

   public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            
            answer = Integer.MAX_VALUE;
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            
            film = new int[D][W];
            m0 = new int[W];
            m1 = new int[W];
            Arrays.fill(m1, 1);

            for (int y = 0; y < D; y++) {
                for (int x = 0; x < W; x++) {
                    film[y][x] = sc.nextInt();
                }
            }

            // System.out.printf("#%d %s", t, test(film));
            dfs(0, 0, film.clone());

            System.out.printf("#%d %d\n", t, answer == Integer.MAX_VALUE ? -1 : answer);
        }
        
        sc.close();

   }

}
