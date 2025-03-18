def solution(s):
    # 공백도 유지해야 함.
    answer=''
    idx = 0
    for i in range(len(s)):
        # 공백이면 그대로 추가
        if(s[i]==' '):
            idx =0
            answer += s[i]
        else:
            if(idx%2==0):
                answer += s[i].upper()
            else:
                answer += s[i].lower()
            idx+=1
    return answer