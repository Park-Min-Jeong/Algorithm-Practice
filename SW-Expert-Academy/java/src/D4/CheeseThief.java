package Level4;

import java.util.*;

public class CheeseThief {
	
	static int n;
	
	static int[][] arr;
	static boolean[][] visited;
	
	static void DFS(int y, int x) {
		 
		if ((y < 0) || (y >= n) || (x < 0) || (x >= n)) {
			return;
		}
        
        if ((arr[y][x] == 0) || (visited[y][x])) {
        	return;
        }
		
		visited[y][x] = true;
		
		DFS(y + 1, x);
		DFS(y - 1, x);
		DFS(y, x + 1);
		DFS(y, x - 1);
		
	}
	
	static int calcCount() {
		
		int count = 0;

        visited = new boolean[n][n];
				
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (visited[y][x]) {
					continue;
				}
				
				if (arr[y][x] > 0) {
                    DFS(y, x);
					count++;
				}
			}
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			int answer = 0;
			
			n = sc.nextInt();
			arr = new int[n][n];
            
			
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					arr[y][x] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < 101; i++) {

				for (int y = 0; y < n; y++) {
					for (int x = 0; x < n; x++) {
						if (arr[y][x] == i) {
							arr[y][x] = 0;
						}
					}
				}
				
				int count = calcCount();
				
				if (count > answer) {
					answer = count;
				}

			}			
			
			System.out.printf("#%d %d\n", t, answer);
			
		}
		
		sc.close();
		
	}
	
}
