package D4;

import java.util.Scanner;

public class D4_7465_창용마을무리의개수 {
    static int[][] arr;
	
	static int n;
	static int m;
	
	static int getCount() {
		int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			if (arr[i][1] == 0) {
				continue;
			}
			answer++;
		}
		
		return answer;
	}

	
	static void makeSet(int x) {
		arr[x][1] = x;
	}
	
	static int findSet(int x) {
		int answer = -1;
		
		iter: for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				if (arr[r][c] == x) {
					answer = r;
					break iter;
				}
			}
		}
		
		return answer;
	}
	
	static void union(int x, int y) {
		int xIndex = findSet(x);
		int yIndex = findSet(y);
				
		if (xIndex == yIndex) {
			return;
		}
		
		int minIndex = Math.min(xIndex, yIndex);
		int maxIndex = Math.max(xIndex, yIndex);
		
		int index = 0;
		
		for (int i = 1; i <= n; i++) {
			if (arr[minIndex][i] == 0) {
				index = i;
				break;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (arr[maxIndex][i] == 0) {
				break;
			}
			arr[minIndex][index++] = arr[maxIndex][i];
			arr[maxIndex][i] = 0;
		}
	}	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			arr = new int[n + 1][n + 1];
			
			for (int i = 1; i <= n; i++) {
				makeSet(i);
			}
			
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				union(a, b);
			}
			
			System.out.printf("#%d %d\n", t, getCount());
			
		}
		
		sc.close();
		
	}
}
