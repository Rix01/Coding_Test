def solution(citations):
    n = len(citations)
    # 내림차순 정렬
    citations = sorted(citations, reverse=True)
    
    h_max = 0
    for idx, v in enumerate(citations):
        if idx+1 <= v:
            h_max = idx+1
    return h_max 