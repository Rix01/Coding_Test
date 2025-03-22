def solution(array, commands):
    answer = []
    
    for c in range(len(commands)):
        i = commands[c][0]
        j = commands[c][1]
        k = commands[c][2]
        array_slice = array[i-1:j]
        # 오름차순 정렬
        array_slice.sort()
        answer.append(array_slice[k-1])
    return answer