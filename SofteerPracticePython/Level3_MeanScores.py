N, K = list(map(int, input().split()))

scores = list(map(int, input().split()))

for k in range(K):
    a, b = list(map(int, input().split()))
    print(f"{round(sum(scores[a-1:b])/(b-a+1), 2):.2f}")