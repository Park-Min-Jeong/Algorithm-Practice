import time

start = time.time()

K, P, N = list(map(int, input().split()))

K = K % 1000000007
P = P % 1000000007

for _ in range(N):
    K = K * P % 1000000007

print(K)

print(time.time() - start)