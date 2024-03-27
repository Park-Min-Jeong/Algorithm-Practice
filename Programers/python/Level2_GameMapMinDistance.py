# 깊이 너비 우선 탐색

def solution(maps):
    answer = 999
    
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    stack = [[4, 4, 1]]
    log = [[4, 4]]
    
    while (len(stack) > 0):
        y, x, cnt = stack.pop()
        
        print(y, x, cnt)

        if x == 0 and y == 0 and answer > cnt:
            answer = cnt
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if (0 <= nx <= 4) and (0 <= ny <= 4) and [ny, nx] not in log and maps[ny][nx] == 1:
                stack.append([ny, nx, cnt + 1])
                log.append([ny, nx])

    if answer == 999:
        answer = -1
    
    return answer


print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]))