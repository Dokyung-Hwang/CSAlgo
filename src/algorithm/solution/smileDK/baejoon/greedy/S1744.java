package algorithm.solution.smileDK.baejoon.greedy;

import algorithm.problem.baekjoon.greedy.P1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Memo.
    Input: n(n < 50), 수열의 각 수(-1,000<=num<=1,000)
    Output: 수열의 수를, 합이 최대가 나오게 묶었을 때의 합
    * Step
    1. 양수와 음수(0 포함)를 따로 ArrayList에 담기
    2. positive 내림차순 정렬 / negative 오름차순 정렬
    3. 양수, 음수 각각 앞에서 2개씩 묶어서 곱한 뒤 sum 에 누적해서 담기(요소의 개수가 홀수 개일 경우 마지막 수는 그냥 더해준다.)
    4. 양수, 음수의 계산 결과를 더한 후 출력
    주의사항)
    1. 0은 양수 리스트에 넣었을 경우 처리하기가 어려우므로 음수 리스트에 담는다.(0을 포함하여 짝수일 경우 음수의 가장 큰 값과 곱해주면 0이 되므로 최댓값이 된다.)
    2. 양수 리스트에서 1은 곱했을 경우 1을 손해보므로 두 수가 중 하나라도 1이라면 서로 더해준다.
*/

/*Review.
    처음에 1차원 배열에 모든 수열을 담고 처리하다보니 엄청 돌아왔다.
    경우의 수가 나뉜다면, 경우의 수를 나눠서 각각의 리스트에 담아서 생각해보는 습관을 들여야겠다.
    나눈 후 정렬해보니 계산은 수월하게 진행할 수 있었다. 하지만 메모의 주의사항을 생각하지 않고 엄한 반례만 찾다가 시간을 낭비했다.
    쉽지 않다 알고리즘.
*/


public class S1744 implements P1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 양수와 음수(0 포함)를 따로 ArrayList에 담기
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(br.readLine());
            if (element > 0)
                positive.add(element);
            else
                negative.add(element);
        }

        // Todo. positive 내림차순 정렬 / negative 오름차순 정렬
        positive.sort(Collections.reverseOrder());
        Collections.sort(negative);

        System.out.println(calculateSum(positive) + calculateSum(negative));
    }

    public static int calculateSum(List<Integer> sequence) {
        int sum = 0;

        for (int i = 0; i < sequence.size() - 1; i += 2) {
            if (sequence.get(i) == 1 || sequence.get(i + 1) == 1)
                sum += sequence.get(i) + sequence.get(i + 1);
            else
                sum += sequence.get(i) * sequence.get(i + 1);
        }

        if (sequence.size() % 2 != 0) {
            sum += sequence.get(sequence.size() - 1);
        }

        return sum;
    }
}
