# https://velog.io/@ledcost/%EB%B0%B1%EC%A4%80-9375-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%ED%8C%A8%EC%85%98%EC%99%95-%EC%8B%A0%ED%95%B4%EB%B9%88-%EC%8B%A4%EB%B2%843-%EC%A1%B0%ED%95%A9%EB%A1%A0

import sys

T = int(sys.stdin.readline())
for _ in range(T):
    dress = {}
    for _ in range(int(sys.stdin.readline())):
        a, b = map(str, sys.stdin.readline().rstrip().split())  # a: 옷, b:옷 종류
        if dress.get(b) == None:
            dress[b] = set()    # 옷의 종류 별로 집합을 만들어 줌
        dress[b].add(a)  # 집합이라 옷 여러 개를 add()로 추가할 수 있다.

    # 의류 종류가 둘 이상이라면, (어떤 의류 종류의 의류 수 + 안 입는 경우 1)를 모든 종류에 대해
    # 서로 곱해주고, 1을 빼준다. 마지막에 1을 빼는 이유는 알몸인 경우를 제외하기 위함이다.
    count = 1
    for key in dress.keys():
        count *= len(dress[key]) + 1
    print(count - 1)