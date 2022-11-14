# 1983. 조교의 성적 매기기
standard = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
for tc in range(1, int(input())+1):
    n, k = map(int, input().split())
    arr = []

    # 동일한 점수를 줄 수 있는 학생의 수
    scoreStandard = n//10

    # 점수 입력받고 index와 함께 정렬
    for i in range(n):
        a, b, c = map(int, input().split())
        arr.append([(a*35/100 + b*45/100 + c*20/100), i])
    arr2 = sorted(arr, key=lambda x: -x[0])
    
    # 정렬된 배열에 평점 부여
    index = 0
    for i in range(0, n, scoreStandard):
        for j in range(i, i+scoreStandard):
            arr2[j].append(standard[index])
        index += 1

    # 평점 부여된 배열을 다시 기존의 index 기준으로 정렬함
    arr = sorted(arr2, key=lambda x: x[1])

    print(f'#{tc} {arr[k-1][2]}')