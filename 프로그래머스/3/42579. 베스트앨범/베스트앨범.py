def solution(genre_array, play_array):
    result = []
    genre_index = dict()
    genre_total = dict()

    for i in range(len(genre_array)):
        if genre_array[i] not in genre_index:
            genre_index[genre_array[i]] = [(i, play_array[i])]
            genre_total[genre_array[i]] = play_array[i]
        else:
            genre_index[genre_array[i]].append((i, play_array[i]))
            genre_total[genre_array[i]] += play_array[i]

    # 1. 많이 재생된 장르 먼저 수록 (장르 선택)
    first_sort = sorted(genre_total, key=lambda x:genre_total[x], reverse=True)

    # 2. 장르 내에서 많이 재생된 노래를 먼저 수록, 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
    for k, v in genre_index.items():
        # 정렬 후 다시 넣기
        genre_index[k] = sorted(v, key=lambda x: (-x[1], x[0]))

    # 장르별로 돌면서 추가
    for genre in first_sort:
        for i in range(min(2, len(genre_index[genre]))):
            result.append(genre_index[genre][i][0])

    return result