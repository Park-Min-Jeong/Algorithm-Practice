package Level1;

import java.util.Scanner;

public class CompareDistance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		
		
		String answer = "";
		
		if (A > B) {
			answer = "A";
		} else if (A < B) {
			answer = "B";
		} else {
			answer = "same";
		}
		
		System.out.println(answer);
	}
}
