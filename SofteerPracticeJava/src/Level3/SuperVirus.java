package Level3;

import java.math.BigInteger;
import java.util.Scanner;

public class SuperVirus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger K = BigInteger.valueOf(sc.nextLong());
		BigInteger P = BigInteger.valueOf(sc.nextLong());
		BigInteger N = BigInteger.valueOf(sc.nextLong());
		
		BigInteger a = BigInteger.valueOf(1000000007);
		
		sc.close();
		
		String bin10N = N.multiply(BigInteger.valueOf(10)).toString(2);

		BigInteger modK = K.mod(a);
		BigInteger modP = BigInteger.valueOf(1);
		
		
		BigInteger temp = P.mod(a);
		
		for (int idx = bin10N.length() - 1; idx >= 0; idx--) {
			if (bin10N.charAt(idx) == '1') {
				modP = modP.multiply(temp);
			}
			temp = temp.multiply(temp).mod(a);
		}
		
		System.out.println(modK.multiply(modP).mod(a));
	}
}
