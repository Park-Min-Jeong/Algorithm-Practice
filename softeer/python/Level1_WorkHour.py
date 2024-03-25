answer = 0

for _ in range(5):
    start, end = input().split()

    s_hour, s_minute = list(map(int, start.split(":")))
    e_hour, e_minute = list(map(int, end.split(":")))

    answer += (e_hour - s_hour - 1) * 60

    answer += e_minute
    answer += (60 - s_minute)

print(answer)