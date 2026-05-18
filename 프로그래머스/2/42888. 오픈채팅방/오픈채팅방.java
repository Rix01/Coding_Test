import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // record를 돌면서 uid에 따라 일단 User Map 만들기
        // uid: nickname 형태
        int changeCount = 0;
        Map<String, String> userMap = new HashMap<>();
        for(String rcd : record) {
            String[] splitRcd = rcd.split(" ");
            // [0]: Enter / [1]: uid / [2]: nickname
            if(splitRcd[0].equals("Enter")) {
                if(userMap.containsKey(splitRcd[1])) {
                    userMap.remove(splitRcd[1]);
                }
                userMap.put(splitRcd[1], splitRcd[2]);
            }
            else if(splitRcd[0].equals("Leave")) {
                // userMap.remove(splitRcd[1]); // 나간다고 delete를 하면 안 되네
            }
            else if(splitRcd[0].equals("Change")) {
                userMap.remove(splitRcd[1]);
                userMap.put(splitRcd[1], splitRcd[2]);
                changeCount++;
            }
        }
        
        // record 길이
        int recordLen = record.length;
        String[] answer = new String[recordLen - changeCount];
        int idx = 0;
        for(String rcd : record) {
            String[] splitRcd = rcd.split(" ");
            if(splitRcd[0].equals("Enter")) {
                // 닉네임 찾기
                String nickName = userMap.get(splitRcd[1]);
                answer[idx] = nickName + "님이 들어왔습니다.";
                idx++;
            }
            else if(splitRcd[0].equals("Leave")) {
                String nickName = userMap.get(splitRcd[1]);
                answer[idx] = nickName + "님이 나갔습니다.";
                idx++;
            }
        }
        return answer;
    }
}

/**
[유저 아이디]
[닉네임]

Enter [아이디] [닉네임]
Leave [아이디]
Change [아이디] [닉네임]

- 대소문자 구별
- 아이디와 닉네임 길이 1 ~ 10

예제 코드를 보면
["Enter uid1234 Muzi", 
"Enter uid4567 Prodo",
"Leave uid1234",
"Enter uid1234 Prodo",
"Change uid4567 Ryan"]

uid1234: Prodo
uid4567: Ryan


**/