T = int(input())

for t in range(T):
    A, B = list(map(int, input().split()))
    print(f"Case #{t+1}: {A+B}")