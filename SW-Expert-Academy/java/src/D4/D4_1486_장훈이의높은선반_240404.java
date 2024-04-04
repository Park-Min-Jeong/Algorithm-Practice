    package D4;

    import java.util.*;

    public class D4_1486_장훈이의높은선반_240404 {

        static int answer;
        static int N;
        static int B;
        static int[] height;

        static void dfs(int index, int result) {
            if (index == N) {
                int temp = result - B;
                if ((temp >= 0) && (temp < answer)) {
                    answer = temp;
                }
                return;
            }

            dfs(index + 1, result + height[index]); // 해당 인덱스의 점원 키를 더한 경우
            dfs(index + 1, result); // 해당 인덱스의 점원 키를 더하지 않은 경우
        }
        
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int tc = sc.nextInt();

            for (int t = 1; t <= tc; t++) {

                answer = Integer.MAX_VALUE;

                N = sc.nextInt();
                B = sc.nextInt();

                height = new int[N];

                for (int i = 0; i < N; i++) {
                    height[i] = sc.nextInt();
                }
                
                dfs(0, 0);

                System.out.printf("#%d %d\n", t, answer);
            }

            sc.close();
        }

    }
