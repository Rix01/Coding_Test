import java.io.*;
import java.util .*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            // input 내용을 하나씩 검사
            sb.append(input.charAt(i));

            // 길이가 bomb보다 길다면 그때마다 검사
            if (sb.length() >= bomb.length()) {
                boolean isBomb = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (sb.charAt(sb.length() - bomb.length() + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }
        if(sb.length()==0) {
            bw.write("FRULA");
        } else {
            bw.write(sb.toString());
        }
        bw.close();
    }
}
