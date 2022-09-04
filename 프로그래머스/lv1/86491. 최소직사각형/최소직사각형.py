def solution(sizes):
    # 가로와 세로 변수 생성
    width, height = 0, 0
    
    # 가로가 길도록 바꾼다.
    for i in sizes:
        if i[0] < i[1]:
            i[0], i[1] = i[1], i[0]
        # 더 긴 가로 or 세로가 나온다면 저장
        if i[0] > width:
            width = i[0]
        if i[1] > height:
            height = i[1]
    # print(sizes)
    # 가로의 최대와 세로의 최대를 곱한다.
    answer = width * height
    # print(answer)
    return answer