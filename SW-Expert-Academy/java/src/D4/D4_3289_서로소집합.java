package D4;

import java.util.*;
import java.io.*;

public class D4_3289_서로소집합 {

    static int[] arr;
	static int n;
	static int m;
	
	static void makeSet() {
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
	}
	
	static int findSet(int x) {
		if (x != arr[x]) {
			arr[x] = findSet(arr[x]);
		}
		return arr[x];
	}
	
	static void union(int x, int y) {
		int xIndex = findSet(x);
		int yIndex = findSet(y);
		
		if (xIndex != yIndex) {
			arr[yIndex] = xIndex;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {

            sb.append("#" + t + " ");
			
            st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n + 1];
			makeSet();
			
			for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
				int oper = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (oper == 0) {
					union(a, b);
				}
				else if (oper == 1) {
					if (findSet(a) == findSet(b)) {
                        sb.append(1);
                    }
                    else {
                        sb.append(0);
                    }
				}
			}
			sb.append("\n");
			
		}
		
        System.out.println(sb);

		br.close();

	}

}
