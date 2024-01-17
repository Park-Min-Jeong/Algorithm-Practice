import time

start = time.time()

K, P, N = list(map(int, input().split()))

"""
K * P**10N % a
= (K % a) * (P**10N % a) % a

참고: https://ko.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/fast-modular-exponentiation

"""

mod_k = K % 1000000007

bin_10n = str(bin(10 * N))[2:]

temp = P % 1000000007
mod_p = 1

for i in range(len(bin_10n)-1, -1, -1):
    if bin_10n[i] == "1":
        mod_p *= temp

    temp = (temp * temp) % 1000000007

print(mod_k * mod_p % 1000000007)

print(time.time() - start)