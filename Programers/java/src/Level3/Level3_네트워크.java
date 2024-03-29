package Level3;

import java.util.*;

public class Level3_네트워크 {
    
    static int[][] array;
    static int[] parent;
    static int N;
    
    static void makeSet() {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }
    
    static int findSet(int x) {
        if (x != parent[x]) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }
    
    static void union(int x, int y) {
        int yIndex = findSet(y);
        int xIndex = findSet(x);
        
        for (int i = 0; i < N; i++) {
            if (parent[i] == yIndex) {
                parent[i] = xIndex;
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        array = computers;
        parent = new int[n];
        N = n;
        
        makeSet();
        
        for (int y = 0; y < n; y++) {
            for (int x = y + 1; x < n; x++) {
                if (array[y][x] == 1) {
                    union(x, y);
                }
            }
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (temp.contains(parent[i])) {
                continue;
            }
            temp.add(parent[i]);
        }

        return temp.size();
    }
    
}