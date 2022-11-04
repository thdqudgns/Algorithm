# T = int(input())
for tc in range(1, 11):
    dump = int(input())     # 1~1000
    box = list(map(int, input().split()))   # 1~100
    while dump > 0:
        maxidx = box.index(max(box))
        minidx = box.index(min(box))
        box[maxidx] -= 1
        box[minidx] += 1
        dump -= 1
    result = max(box) - min(box)
    print(f'#{tc} {result}')