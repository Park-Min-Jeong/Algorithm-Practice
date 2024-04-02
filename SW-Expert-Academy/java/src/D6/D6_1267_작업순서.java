/* 위상정렬: Queue를 활용하여 구현 */

package D6;

import java.util.*;

public class D6_1267_작업순서 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {

            int v = sc.nextInt();
            int e = sc.nextInt();
            int[][] adj = new int[v + 1][v + 1];
            int[] degree = new int[v + 1];

            for (int i = 0; i < e; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj[a][b] = 1;
                degree[b]++;
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= v; i++) {
                if (degree[i] == 0) {
                    queue.offer(i);
                }
            }

            System.out.printf("#%d ", t);

            while (!(queue.isEmpty())) {
                int curr = queue.poll();
                System.out.printf("%d ", curr);

                for (int i = 1; i <= v; i++) {
                    if (adj[curr][i] == 1) {
                        degree[i]--;
                        adj[curr][i] = 0;

                        if (degree[i] == 0) {
                            queue.offer(i);
                        }
                    }
                }
            }

            System.out.println();
        }

        sc.close();

    }

}
