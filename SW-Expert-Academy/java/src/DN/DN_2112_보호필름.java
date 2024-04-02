package DN;

import java.util.*;

public class DN_2112_보호필름 {

    static int d;
    static int w;
    static int k;
    static int[][] film;
    static boolean[] visited;
    static int answer;


    static boolean performanceTest(int[][] filmCopy) {
        boolean answer = true;

        for (int x = 0; x < w; x++) {
            int maxCount = 0;
            int check = -1;
            int tempCount = 0;
            for (int y = 0; y < d; y++) {
                if (filmCopy[y][x] != check) {
                    if (tempCount > maxCount) maxCount = tempCount;
                    tempCount = 0;
                    check = filmCopy[y][x];
                }
                tempCount++;
            }
            if (tempCount > maxCount) maxCount = tempCount;

            if (maxCount < k) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {

            d = sc.nextInt();
            w = sc.nextInt();
            k = sc.nextInt();

            film = new int[d][w];
            visited = new boolean[w];

            for (int y = 0; y < d; y++) {
                for (int x = 0; x < w; x++) {
                    film[y][x] = sc.nextInt();
                }
            }

            System.out.printf("#%d %s\n", t);

        }

        sc.close();

    }

}
