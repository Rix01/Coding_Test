def solution(my_string):
    answer = ''
    for c in my_string:
        if c.isupper():
            answer += c.lower()
        else:
            answer += c.upper()
    return answer