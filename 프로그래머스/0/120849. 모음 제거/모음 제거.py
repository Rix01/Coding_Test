def solution(my_string):
    my_list = list(my_string)
    # 모음 set
    moeum = {"a", "e", "i", "o", "u"}
    answer = ""
    for i in range(len(my_list)):
        if(my_list[i] not in moeum):
            answer += my_list[i]
    return answer