def solution(a, b):
    arr_len = len(a)
    answer = 0
    for i in range(arr_len):
        answer += a[i]*b[i]
    return answer