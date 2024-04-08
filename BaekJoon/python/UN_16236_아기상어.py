def calculate_distance(shark, fish):
    return abs(shark[0] - fish[0]) + abs(shark[1] - fish)

N = int(input())
map = [[0 for _ in range(N)] for _ in range(N)]

shark_size = 1
shark = []

fish = {k: [] for k in range(1,7)}
fish_num = 0

for y in range(N):
    temp = list(map(int, input().split()))
    for x in range(N):
        map[y][x] = temp[x]

        if temp[x] == 9:
            shark.extend([y, x])
        elif temp[x] > 0:
            temp[x].append([y, x])
            fish_num += 1

