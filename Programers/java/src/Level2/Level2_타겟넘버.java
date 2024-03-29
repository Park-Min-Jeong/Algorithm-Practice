package Level2;

public class Level2_타겟넘버 {
    
    static int answer;
    
    static void dfs(int cnt, int temp, int[] numbers, int target) {
        if (cnt >= numbers.length) {
            if (temp == target) {
                answer++;
            }
            return;
        }
        
        dfs(cnt + 1, temp - numbers[cnt], numbers, target);
        dfs(cnt + 1, temp + numbers[cnt], numbers, target);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }

}
