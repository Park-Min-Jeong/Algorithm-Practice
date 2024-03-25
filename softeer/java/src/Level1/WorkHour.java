package Level1;

import java.util.Scanner;

public class WorkHour {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int answer = 0;
		
		for (int i = 0; i < 5; i++) {
			String start[] = sc.next().split(":");
			String end[] = sc.next().split(":");
			
			answer += (Integer.parseInt(end[0]) - Integer.parseInt(start[0]) - 1) * 60;
			
			answer += Integer.parseInt(end[1]);
			answer += (60 - Integer.parseInt(start[1]));
		}
		
		sc.close();
		
		System.out.println(answer);
	}
}
