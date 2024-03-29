# 해시
def solution(clothes):
    answer = 1
    
    kind = dict()
    
    for v, k in clothes:
        if k in kind.keys():
            kind[k].append(v)
        else:
            kind[k] = [v]
    
    for v in kind.values():
        answer = answer * (len(v) + 1)
        
    return answer - 1