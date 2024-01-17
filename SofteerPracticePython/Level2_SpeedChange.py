speed = list(map(int, input().split()))

answer = ""
whether = True

while True:
    whether = True

    for i in range(8):
        if speed[i] != i + 1:
            whether = False
    if whether == True:
        answer = "ascending"
        break

    whether = True
    for i in range(8):
        if speed[i] != (8 - i):
            whether = False
    if whether == True:
        answer = "descending"
        break

    answer = "mixed"
    break

print(answer)