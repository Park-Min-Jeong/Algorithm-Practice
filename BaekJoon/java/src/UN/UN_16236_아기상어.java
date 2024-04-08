import java.util.*;

public class UN_16236_아기상어 {

    static int N;
    static int[][] map;
    static int[] shark;


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        shark = new int[2];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                int temp =  sc.nextInt();
                map[y][x] = temp;

                if (temp == 9) {
                    shark[0] = y;
                    shark[1] = x;
                }
            }
        }


        sc.close();
    
    }    
}
