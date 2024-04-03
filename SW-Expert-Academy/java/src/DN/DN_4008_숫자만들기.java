package DN;

import java.util.*;

public class DN_4008_숫자만들기 {

    static int n;
    static int[] operator; // + - * /
    static int[] number;

    static int max;
    static int min;

    static void bfs(int index, int[] operTemp, int result) {
        if (index == n) {
            if (result > max) max = result;
            if (result < min) min = result;
        }

        if (operTemp[0] > 0) {
            operTemp[0]--;
            bfs(index + 1, operTemp, result + number[index]);
            operTemp[0]++;
        }
        if (operTemp[1] > 0) {
            operTemp[1]--;
            bfs(index + 1, operTemp, result - number[index]);
            operTemp[1]++;
        }
        if (operTemp[2] > 0) {
            operTemp[2]--;
            bfs(index + 1, operTemp, result * number[index]);
            operTemp[2]++;
        }
        if (operTemp[3] > 0) {
            operTemp[3]--;
            bfs(index + 1, operTemp, result / number[index]);
            operTemp[3]++;
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {

            n = sc.nextInt();

            operator = new int[4];
            number = new int[n];

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            for (int i = 0; i < 4; i++) {
                operator[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                number[i] = sc.nextInt();
            }

            bfs(1, operator.clone(), number[1]);

            System.out.printf("#%d %d\n", t, max - min);

        }

        sc.close();

    }

}
