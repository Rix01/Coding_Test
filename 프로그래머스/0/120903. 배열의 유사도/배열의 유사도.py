def solution(s1, s2):
    set1 = set(s1)
    set2 = set(s2)
    
    set3 = set1 & set2
    answer = len(set3)
    return answer