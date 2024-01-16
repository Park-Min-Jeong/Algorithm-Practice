package Level2;

import java.util.Scanner;

public class Virus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long K = sc.nextLong() % 1000000007;
		long P =  sc.nextLong() % 1000000007;
		long N =  sc.nextLong();
		
		for (int n = 0; n < N; n++) {
			K = K * P % 1000000007;
		}
		
		sc.close();
		
		System.out.println(K);
	}
}
