package D4;

import java.util.*;

public class D4_1251_하나로_KRUSKAL {

    static long[][] map;
    static long[][] edges;
    static int[] parent;
    static int n;
    static long e;

    static long calcPrice(long[] a, long[] b) {
        return (long) (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2)) * e;
    }

    static int convertLongToInt(long x) {
        return Long.valueOf(x).intValue();
    }

    static void makeEdges() {
        int index = 0;

        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                edges[index][0] = a;
                edges[index][1] = b;
                edges[index][2] = calcPrice(map[a], map[b]);

                index++;
            }
        }

        Arrays.sort(edges, new Comparator<long[]>() {
            @Override
            public int compare(long[] e1, long[] e2) {
                return convertLongToInt(e1[2] - e2[2]);
            }
        });
    }

    static void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[n] = n;
        }
    }

    static int findSet(int x) {
        if (x != parent[x]) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        parent[findSet(y)] = findSet(x);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {

            n = sc.nextInt();
            map = new long[n][2];
            edges = new long[(n * (n - 1) / 2)][3];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            double temp = sc.nextFloat();
            long ratio = 1;
            while (temp < 1) {
                temp *= 10;
                ratio *= 10;
            }
            e = (long) temp;

            makeSet();

            long answer = 0;

            for (int i = 0; i < (n * (n - 1) / 2); i++) {
                int x = convertLongToInt(edges[i][0]);
                int y = convertLongToInt(edges[i][1]);
                
                System.out.printf("%d %d => %d, %d", x, y, findSet(x), findSet(y));
                if (findSet(x) != findSet(y)) {
                    union(x, y);
                    answer += edges[i][2];
                }
            }

            System.out.printf("#%d %d\n", t, answer / ratio);

        }

        sc.close();

    }
}
