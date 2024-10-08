# 대문자 < 소문자
# 아스키코드 대문자 A가 65, 소문자 a가 97
# 그냥 리버스 정렬하면 됨.

def solution(s):
    arr_n = list(s)
    arr_n.sort(reverse=True)
    # 파이썬 리스트(list)를 문자열(string)로 변환 => join 사용!!
    result = ''.join(arr_n)
    return result