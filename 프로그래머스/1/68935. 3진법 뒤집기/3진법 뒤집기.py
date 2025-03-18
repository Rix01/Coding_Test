def solution(n):
    # 일단 3진법으로 변환
    tenToThree = []
    while(True):
        if(n<3):
            tenToThree.append(n) # 마지막엔 몫도 추가가
            break
        tenToThree.append(n%3)  # 나머지 추가가
        n = n//3

    answer = 0
    # 이제 10진법으로 다시 변환
    three = 0
    for i in range(len(tenToThree)-1, -1, -1):
        answer += tenToThree[i]*(3**three)
        three += 1
    return answer