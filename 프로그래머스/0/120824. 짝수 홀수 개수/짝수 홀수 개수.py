def solution(num_list):
    # 짝수, 홀수 순서
    answer = [0]*2
    for i in num_list:
        # 짝수라면
        if(i%2==0):
            answer[0] += 1
        # 홀수라면
        else:
            answer[1] += 1
    
    return answer