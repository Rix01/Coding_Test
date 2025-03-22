def solution(genres, plays):
    answer = []
    dict_playSum = {}
    # genre, play, idx
    # [['classic', 500, 0], ['pop', 600, 1], ['classic', 150, 2], ['classic', 800, 3], ['pop', 2500, 4]]
    g_p_i = [[genres[i], plays[i], i] for i in range(len(genres))]
    # 횟수는 내림차순, 인덱스는 오름차순 정렬
    g_p_i = sorted(g_p_i, key=lambda x:(-x[1], x[2]))
    
    for i in range(len(g_p_i)):
        if(g_p_i[i][0] in dict_playSum):
            dict_playSum[g_p_i[i][0]] += g_p_i[i][1]
        else:
            dict_playSum[g_p_i[i][0]] = g_p_i[i][1]
    
    # 딕셔너리 내림차순
    dict_playSum = dict(sorted(dict_playSum.items(), key= lambda x:-x[1]))
    
    for k, v in dict_playSum.items():
        count = 0
        for j in range(len(g_p_i)):
            if(k==g_p_i[j][0]):
                count+=1
                if(count>2):
                    break
                answer.append(g_p_i[j][2])

    return answer