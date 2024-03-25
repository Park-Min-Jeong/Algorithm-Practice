package Level2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxWeight {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int W = sc.nextInt();
		int N = sc.nextInt();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int n = 0; n < N; n++) {
			int m = sc.nextInt();
			int p = sc.nextInt();
			
			if (map.keySet().contains(p)) {
				map.put(p, map.get(p) + m);
			} else {
				map.put(p, m);
			}
		}
		
		int weight = 0;
		int price = 0;
		
		while (true) {
			int maxP = Collections.max(map.keySet());
			int maxW = map.get(maxP);
			map.remove(maxP);
			
			if (maxW > (W - weight)) {
				price += (W - weight) * maxP;
				weight += (W - weight);
			} else {
				price += maxW * maxP;
				weight += maxW;
			}
			
			if (weight >= W || map.size() == 0) {
				break;
			}
		}
		
		sc.close();
		
		System.out.println(price);
	}
}
