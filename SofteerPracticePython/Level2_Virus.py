import time

start = time.time()

K, P, N = list(map(int, input().split()))
a = 1000000007

"""
K = K % 1000000007
P = P % 1000000007

for _ in range(N):
    K = K * P % 1000000007
"""

"""
K * P**N % a
= (K % a) * (P**N % a) % a
"""


print((K % a) * (P**N % a) % a)

print(time.time() - start)