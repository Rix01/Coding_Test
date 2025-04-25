def solution(numbers):
    answer = -100000000
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            gop = numbers[i]*numbers[j]
            if(gop>answer):
                answer = gop
    return answer