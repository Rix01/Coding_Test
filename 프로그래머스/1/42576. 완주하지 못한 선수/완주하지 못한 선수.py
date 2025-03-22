def solution(participant, completion):
    p_dict = dict()
    for i in participant:
        # 이미 있다면
        if(i in p_dict):
            p_dict[i] += 1
        else:
            p_dict[i] = 1   # 그대로
    
    for i in completion:
        p_dict[i] -=1
    
    for k, v in p_dict.items():
        if v==1:
            return k