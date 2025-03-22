def solution(genres, plays):
    answer = []
    # [[0, 500], [1, 600], [2, 150], [3, 800], [4, 2500]]
    index_play = list()
    for i in range(len(plays)):
        index_play.append([i, plays[i]])

    # 딕셔너리 형태 만들기
    # {"classic":[[0, 500], [2, 150], [3, 800]], "plays": [[1, 600], [4, 2500]]} 형태.
    dict_genres = {}
    for i in range(len(genres)):
        if(genres[i] in dict_genres):
            dict_genres[genres[i]].append(index_play[i])
        else:
            dict_genres[genres[i]] = [index_play[i]]

    # 딕셔너리 값 1번째 인덱스 기준으로 정렬해서 update
    # {'classic': [[3, 800], [0, 500], [2, 150]], 'pop': [[4, 2500], [1, 600]]}
    for k, v in dict_genres.items():
        dict_genres[k] = sorted(v, key=lambda x:x[1], reverse=True)    

    # 총합 딕셔너리 생성
    # {'classic': 1450, 'pop': 3100}
    dict_genres_sum = {}
    for k, v in dict_genres.items():
        playSum =0
        for p in v:
            playSum += p[1]
        dict_genres_sum[k] = playSum

    # 총합 추가
    # {'classic': [[3, 800], [0, 500], [2, 150], 1450], 'pop': [[4, 2500], [1, 600], 3100]}
    for k, v in dict_genres_sum.items():
        dict_genres[k].append(v)

    # 딕셔너리 정렬 총합 기준으로.
    # 
    dict_genres = dict(sorted(dict_genres.items(), key=lambda x:x[1], reverse=True))

    for k, v in dict_genres.items():
        if(len(v)==1):
            answer.append(v[0][0])
            continue
        else:
            answer.append(v[0][0])
            answer.append(v[1][0])

    return answer