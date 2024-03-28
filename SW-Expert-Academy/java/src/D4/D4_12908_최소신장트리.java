package D4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class D4_12908_최소신장트리 {

    static int[][] edges;
	static int[] parent;
	
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
			
			int v = sc.nextInt(); // 0번부터 v번까지의 노드
			int e = sc.nextInt(); // 간선
			
			edges = new int[e][3];
			parent = new int[v + 1];
			
			for (int i = 0; i < e; i++) {
				for (int j = 0; j < 3; j++) {					
					edges[i][j] = sc.nextInt();
				}
			}
			
			// 1. 오름차순 정렬
			Arrays.sort(edges, new Comparator<int[]>() {
				@Override
				public int compare(int[] e1, int[] e2) {
					return e1[2] - e2[2];
				}
			});
			
			// 2. V-1개의 간선 선정
			for (int i = 0; i <= v; i++) {
				parent[i] = i;
			}
						
			int answer = 0;
			int count = 0;
			
			for (int i = 0; i < e; i++) {				
				int x = edges[i][0];
				int y = edges[i][1];
								
				if (findSet(x) != findSet(y)) {
					union(x, y);
					answer += edges[i][2];
					count++;
				}
			}
			
			System.out.printf("#%d %d\n", t, answer);
			
		}
		
		sc.close();
	}

}
