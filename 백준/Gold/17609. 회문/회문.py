# 회문 검사
def check_palindrome(text):
    return text == text[::-1]

# 유사회문 검사
def check_pseudo_palindrome(text):
    start = 0
    end = len(text) -1

    while(text[start] == text[end]):
        start += 1
        end -= 1

    # 앞뒤 같지 않은 text 만나면 이제 유사회문 검사
    now_text = text[start:end+1]
    delete_right = now_text[:-1]
    delete_left = now_text[1:]

    if(check_palindrome(delete_right) or check_palindrome(delete_left)):
        return True
    else:
        return False

n = int(input())
for _ in range(n):
    text = input()
    if(check_palindrome(text)):
        print(0)
    else:
        is_pseudo_palindrome = check_pseudo_palindrome(text)
        if(is_pseudo_palindrome):
            print(1)
        else:
            print(2)