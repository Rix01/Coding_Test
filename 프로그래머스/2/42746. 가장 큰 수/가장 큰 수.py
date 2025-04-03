def solution(numbers):
    # 문자열로 바꿔야지
    for i in range(len(numbers)):
        numbers[i] = str(numbers[i])
    answer = sorted(numbers, key=lambda x:x*3, reverse=True)
    res = ''.join(answer)

    # 단, 000000 같은 경우가 생길 수 있으므로 한번 숫자로 변환 후에 다시 str로 바꾸기!
    res = str(int(res))
    return res;