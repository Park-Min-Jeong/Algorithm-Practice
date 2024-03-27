package DN;

import java.util.*;

public class DN_1952_수영장 {
    
    static int[] price;
	static int[] month;
	
	static int answer;
	
	static void DFS(int m, int p, int sum) {
		if (m >= 12) { // 달 범위 넘어간 경우
			answer = Math.min(sum, answer); // 최솟값 선택
			return;
		}
		
		if (p == 1) { // 1일권 또는 1달권
            int temp = Math.min(month[m] * price[0], price[1]);
			sum += temp; 
			m += 1;
		}
		else if (p == 2) { // 3달권
			sum += price[p];
			m += 3;
		}
		
		for (int i = 1; i <= 2; i++) {
			DFS(m, i, sum);
		}
	}
	
	static void getMinPrice() {
		for (int i = 1; i <= 2; i++) {
			DFS(0, i, 0);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			price = new int[4];
			month = new int[12];
			
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
						
			for (int i = 0; i < 12; i++) {
				month[i] = sc.nextInt();
			}
			
			answer = price[3]; // 1년 이용권
			getMinPrice();
			
			System.out.printf("#%d %d\n", t, answer);
			
		} // tc
		
		sc.close();
	}
}
