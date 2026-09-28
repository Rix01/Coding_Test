import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int nLen = numbers.length;
        int[] maxValue = new int[nLen];
        int[] stack = new int[nLen];
        int top = -1; // 스택이 비어있다는 표시

        for (int i = nLen - 1; i >= 0; i--) {
            // 스택 안 비어있고, 스택 맨 위에 있는 값이 현재 값보다 작으면 뺌
            while (top >= 0 && stack[top] <= numbers[i]) {
                top--;
            }
            
            // 맨 위 값이 큰 수
            maxValue[i] = top < 0 ? -1 : stack[top];
            stack[++top] = numbers[i];
        }

        return maxValue;
    }
}