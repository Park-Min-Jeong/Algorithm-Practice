package Level2;

import java.util.Scanner;

public class SpeedChange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		String answer = "";
		while (true) {
			boolean whether = true;
			for (int i = 0; i < 8; i++) {
				if (arr[i] != i + 1) {
					whether = false;
				}
			}
			if (whether == true) {
				answer = "ascending";
				break;
			}
			
			whether = true;
			for (int i = 0; i < 8; i++) {
				if (arr[i] != 8 - i) {
					whether = false;
				}
			}
			if (whether == true) {
				answer = "descending";
				break;
			}
			
			answer = "mixed";
			break;
		}
		
		System.out.println(answer);
	}
}
