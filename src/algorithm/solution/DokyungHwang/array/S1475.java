package algorithm.solution.DokyungHwang.array;

import algorithm.problem.array.P1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Q.
 * 자기 방 번호를 숫자로 문에 붙이려고 한다.
 * 숫자를 한 세트로 판다.
 * 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
 * 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값 출력
 * (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
 *
 * Input: 방 번호(1,000,000 보다 작거나 같은 자연수 N)
 * Output: 방 번호에 필요한 세트의 최소 갯수
 *
 * S.
 * 1. 문자열로 입력 받기
 * 2. 반복문으로 문자열 순회하면서 배열에 카운팅(6, 9 대체 가능)
 * 3. 6 or 9 처리 -> 6을 기준으로 카운팅해서 /2 + %2(홀, 짝)
 * 4. 배열의 요소 중 가장 큰 값이 최소 세트 갯수
 * */


public class S1475 implements P1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNum = br.readLine();

        int[] digitCounts = new int[10];

        for (int i = 0; i < roomNum.length(); i++) {
            int digit = (int) roomNum.charAt(i) - '0';

            if (digit == 9){
                digitCounts[6]++;
            }
            else {
                digitCounts[digit]++;
            }
        }

        digitCounts[6] = digitCounts[6] / 2 + digitCounts[6] % 2;

        Arrays.sort(digitCounts);

        System.out.println(digitCounts[9]);
    }
}
