import math
def solution(n):
    if int(math.sqrt(n)) == math.sqrt(n):
        answer = math.pow(math.sqrt(n)+1,2)
    else:
        answer = -1
    return answer