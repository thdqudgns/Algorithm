def solution(arr):
    answer = []
    # 다음에 중복된 값이 들어오면 pop한다.
    for i in range(len(arr)):
        answer.append(arr[i])
        if i > 0 and arr[i] == arr[i-1]:
            answer.pop()    
    # print(answer)
    return answer