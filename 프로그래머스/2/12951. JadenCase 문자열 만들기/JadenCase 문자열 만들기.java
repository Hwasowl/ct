import java.util.*;
class Solution {
    public String solution(String s) {
        s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(s.charAt(0)));
        for(int i = 1; i < s.length(); i++) {
            //문자열 길이만큼 반복하여 이전 문자가 공백일 경우 현재 문자를 대문자로 변경 후 저장
            if (s.charAt(i-1) == ' ') sb.append(Character.toUpperCase(s.charAt(i)));
            else sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }
}