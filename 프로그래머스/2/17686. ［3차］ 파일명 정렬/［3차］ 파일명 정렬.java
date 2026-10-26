import java.io.*;
import java.util.*;

class Solution {
    List<HeadNumber> fileList = new ArrayList<>();
    
    public String[] solution(String[] files) {
        // 일단 객체로 만들기
        int idx = 0;
        for(String file:files) {
            // toCharArray로 만들기
            char[] charArr = file.toCharArray();
            
            // charArr 돌면서 head, tail 구분
            splitUntilNum(charArr, idx);
            idx++;
        }
        
        // 정렬
        fileList.sort((a,b) -> {
            int headResult = a.head.compareTo(b.head);
            if(headResult!=0) {
                return headResult;
            }
            
            return Integer.compare(a.number, b.number);
        });
        
        String[] answer = new String[fileList.size()];
        for(int i = 0; i < fileList.size(); i++) {
            answer[i] = files[fileList.get(i).idx];
        }
        
        return answer;
    }
    
    public void splitUntilNum(char[] charArr, int idx) {
        boolean hasStartNum = false;
        int numStartIdx = 0;
        int numEndIdx = charArr.length - 1;
        for(int i = 0; i < charArr.length; i++) {
            
            if(!hasStartNum && Character.isDigit(charArr[i])) {
                numStartIdx = i;
                hasStartNum = true;
            }
            
            // 숫자 가지고 있고
            if(hasStartNum && !(Character.isDigit(charArr[i]))) {
                numEndIdx = i-1;
                break;
            }
            
            // 최대 5글자
            if(hasStartNum && (i - numStartIdx >= 5)) {
                numEndIdx = i;
                break;
            }
        }
        
        // 헤더 조립
        String head = changeToHeadString(charArr, numStartIdx);
        // 대문자로
        String headUpper = head.toUpperCase();
        
        // number 조립
        String number = changeToNumberString(charArr, numStartIdx, numEndIdx);
        // string에서 int로
        int num = Integer.parseInt(number);
        
        fileList.add(new HeadNumber(headUpper, num, idx));
    }
    
    public String changeToHeadString(char[] charArr, int start) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < start; i++) {
            sb.append(charArr[i]);
        }
        return String.valueOf(sb);
    }
    
    public String changeToNumberString(char[] charArr, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i <=end ; i++) {
            sb.append(charArr[i]);
        }
        return String.valueOf(sb);
    }
    
    public class HeadNumber {
        String head;
        int number;
        int idx;
        
        public HeadNumber(String head, int number, int idx) {
            this.head = head;
            this.number = number;
            this.idx = idx;
        }
    }
}

/*
영문 대소문자, 숫자, 공백, ., -
대소문자 구분 X
>> 파일명은 영문자로 시작, 숫자 하나 이상 포함.

HEAD (문자로만. 1글자 이상)
NUMBER(1~5글자. 연속된 숫자로 이루어짐. 앞쪽에 0 가능. 0 ~ 99999. 00000도 가능)
TAIL 형태(숫자가 다시 나타날 수 있음. 아무 글자도 없을 수 있음.)

3가지 부분으로 나누고 HEAD 사전순 정렬

동일할 경우, 입력 순서대로!

예제1번
"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"

객체로 만들기?
String head // 대문자로 통일
int head

img1.png, IMG01.GIF
img / 1 / .png
img / 1 / .GIF


*/