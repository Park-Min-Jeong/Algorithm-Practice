package Level3;

import java.util.Scanner;

public class MeanScores {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        for (int j = 1; j <= K; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
                        
            double answer = 0.0d;
            
            for (int idx = a; idx <= b; idx++) {
            	answer += scores[idx - 1];
            }
            
            answer /= (b - a + 1);
            
            
            System.out.printf("%.2f", answer);
        }
        
        sc.close();
	}
}
