package algorithm.solution.kimhaming.programmers.bruteForce;

import algorithm.problem.programmers.bruteForce.P2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S2 implements P2 {
    //  https://velog.io/@haminggu/프로그래머스Java-완전탐색-모의고사
    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers)));
    }
    //  Todo: 학생 1, 2, 3의 문제 맞춘 개수가 동일하면 오름차순으로 {1, 2, 3} 리턴
    //  1. 학생별 반복되는 패턴을 이차원 배열로 정의하기
    //  2. 세 학생이 정답을 몇 개 맞췄는지 저장하는 배열 hit
    //  3. 각 학생의 정답을 확인하는 반복문 안에서 문제 answers 배열 순회하여 맞았다면 hit++
    //  j % patterns[i].length 를 사용하여 정답 패턴 순환하는 것
    //  4. 세 학생 중에서 가장 많이 맞춘 개수 찾기
    //  5. 가장 많이 맞춘 학생들의 번호를 저장할 리스트 생성
    public static int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3]; //
        for (int i = 0; i < hit.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < hit.length; i++)
            if (max == hit[i]) list.add(i + 1);

            int[] answer = new int[list.size()];    // 위에서 완성한 리스트를 배열로 변환하는 과정
            int cnt = 0;
            for (int num : list)
                // 후위 증감이기 때문에 인덱스 0부터 시작해서 num 할당한 후에 인덱스가 1씩 증가합니다.
                answer[cnt++] = num;
            return answer;
        }
    }
