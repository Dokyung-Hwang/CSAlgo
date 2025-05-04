package algorithm.solution.smileDK.baejoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder roomNumber = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken()); // 사용x 입력o
            int N = Integer.parseInt(st.nextToken());

            int floor = N % H;
            int room = N / H + 1;

            if (floor == 0) {
                floor = H;
                room -= 1;
            }

            // 층수는 그대로, 방 번호는 2자리로 표현 (예: 402, 1203)
            roomNumber.append(floor);
            if (room < 10) {
                roomNumber.append("0"); // 한 자리 수일 경우 앞에 0 붙이기
            }
            roomNumber.append(room).append("\n");
        }

        System.out.print(roomNumber);
    }

}
