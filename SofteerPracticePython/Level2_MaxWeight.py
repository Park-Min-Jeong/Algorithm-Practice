W, N = list(map(int, input().split()))

m_list = []
p_list = []

wp_dict = {}

for _ in range(N):
    m, p = list(map(int, input().split()))
    if p in wp_dict.keys():
        wp_dict[p] += m
    else:
        wp_dict[p] = m

weight = 0
price = 0

while True:
    max_p = max(wp_dict.keys())
    max_m = wp_dict[max_p]
    wp_dict.pop(max_p)

    if max_m > (W - weight):
        price += (W - weight) * max_p
        weight += (W - weight)
    else:
        price += max_m * max_p
        weight += max_m

    if weight >= W or len(wp_dict) == 0:
        break
    
print(price)
    