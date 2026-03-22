import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // - 기준으로 숫자 추출
        String input = br.readLine();
        String[] minusNumbers = input.split("[-]");

        // - 기준으로 나눠진 숫자들 + 기준으로 더해서 리스트에 넣기
        List<Integer> forMinus = new ArrayList<>();
        for(String n:minusNumbers) {
            String[] plusNumbers = n.split("[+]");
            forMinus.add(sum(plusNumbers));
        }

        int answer = forMinus.get(0);
        for(int i = 1; i < forMinus.size(); i++) {
            answer -= forMinus.get(i);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }

    public static int sum(String[] numbers) {
        int sum = 0;
        for(String n:numbers) {
           sum += Integer.parseInt(n);
        }
        return sum;
    }
}
