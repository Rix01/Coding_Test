# 문자열 길이가 4 혹은 6 and 숫자로만 구성.
# isdigit() 메소드를 활용하면 문자열이 숫자의 형태인지 판별
def solution(s):
    len_s = len(s)
    if(len_s == 4 or len_s == 6):
        if(s.isdigit()):
            return True
    return False