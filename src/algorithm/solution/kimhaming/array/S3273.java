package algorithm.solution.kimhaming.array;

import algorithm.problem.array.P3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
        public class S3273 implements P3273 {
            //  https://velog.io/@haminggu/백준-P3273-두-수의-합

            /**
             * 실제 애플리케이션에서는 예외를 적절히 처리하는 것이 중요하므로 try-catch 블록을 사용하여 IOException 처리하는 것이 좋지만,
             * 알고리즘 문제 풀이나 간단한 프로그램 작동 시에는 main 메서드에 throws IOException 을 추가합니다.
             */

            public static void main(String[] args) throws IOException {
                /*
                 Todo:
                  1. BufferedReader 와 InputStreamReader 사용하여 데이터 입력받기
                  2. 첫번째 줄에 입력받는 n 크기의 배열 생성
                  3. StringTokenizer 사용하여 두번째 줄에 공백 기준으로 입력되는 문자열을 배열의 요소로 저장하기
                  4. 세번째 줄에는 ai + aj = x 입력받고, 해당하는 쌍의 갯수를 나타낼 변수 count 초기화하기
                  5. 이중 for문 쓰니 시간초과되어, 중복 데이터를 저장하지 않는 HashSet 사용하기
                  6. count 출력하기
                */

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int n = Integer.parseInt(br.readLine());
                int[] a = new int[n];     // 1. 입력되는 n에 따라서 배열 생성
                HashSet<Integer> set = new HashSet<>();

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(st.nextToken());    // 2. 공백 기준으로 입력되는 문자열을 요소로 저장
                    set.add(a[i]);
                }

                int x = Integer.parseInt(br.readLine());    // 3. ai + aj = x 입력받기
                int count = 0;  // 조건에 맞는 쌍의 갯수를 저장할 변수

                for (int i = 0; i < n; i++) {
                    if (set.contains(x - a[i])) {
                        count++;
                    }
                }
                count/= 2;  // 문제에서 요구하는 바는 인덱스가 더 작은 인덱스가 쌍의 앞에 오는 것으로
                System.out.println(count);
            }
    }
