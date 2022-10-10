from collections import Counter
from sys import stdin

n = stdin.readline().rstrip()
card = list(map(int, stdin.readline().split()))
m = stdin.readline().rstrip()
test = list(map(int, stdin.readline().split()))

# Counter는 리스트를 값으로 주게 되면
# 해당 원소들이 몇 번 등장했는지 세어 딕셔너리 형태로 반환한다.
# {원소:개수, ...} 형태다. 개수의 내림차순으로 정렬된다.
count = Counter(card)
# Counter({10: 3, 3: 2, -10: 2, 6: 1, 2: 1, 7: 1})

# test에서 하나씩 뽑아낸 값(i)이
# card의 각 원소 개수를 세어 저장한 count에
# 있는지 확인하여 있다면 그 개수를, 없다면 0을 출력한다
# 딕셔너리로 저장된 원소(수)를 입력하면 그에 해당하는 값(개수)이 출력된다.
for i in test:
    if i in count:
        print(count[i], end=' ')
    else:
        print(0, end=' ')