class Solution {
    public String solution(String new_id) {
        // 1단계: 모든 대문자를 소문자로 치환
        String step1 = doStep1(new_id);
        // 2단계: 모든 문자 제거
        String step2 = doStep2(step1);
        // 3단계: 마침표가 2번 이상이면 하나로 치환
        String step3 = doStep3(step2);
        // 4단계: 앞뒤 마침표 없애기
        String step4 = doStep4(step3);
        // 5단계: 빈 문자열이라면 a 대입
        String step5 = doStep5(step4);
        // 6단계: 15자까지 자르고 마지막. 검사
        int maxIdx = Math.min(step5.length(), 15);
        String step6 = step5.substring(0, maxIdx);
        step6 = removeEndPoint(step6);
        // 7단계: 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙입
        String step7 = doStep7(step6);
        
        System.out.println(step7);
        return step7;
    }
    
    public String doStep1(String id) {
        char[] charArr = id.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(char c:charArr) {
            if(Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public String doStep2(String id) {
        return id.replaceAll("[^a-z0-9-._]", "");
    }
    
    public String doStep3(String id) {
        return id.replaceAll("\\.+", ".");
    }
    
    public String doStep4(String id) {
        return removeEndPoint(removeFirstPoint(id));
    }
    
    public String removeFirstPoint(String id) {
        return id.replaceAll("^[.]", "");
    }
    
    public String removeEndPoint(String id) {
        return id.replaceAll("[.]$", "");
    }
    
    public String doStep5(String id) {
        if(id.isBlank()) {
            return "a";
        }
        return id;
    }
    
    public String doStep7(String id) {
        StringBuilder sb = new StringBuilder(id);
        while(sb.length() <= 2) {
            char last = id.charAt(id.length() - 1);
            sb.append(last);
        }
        return sb.toString();
    } 
}