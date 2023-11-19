package algorithm.solution.dohyoungK.baekjoon.sort;

import algorithm.problem.baekjoon.sort.P1431;

import java.io.*;
import java.util.Arrays;

public class S1431 implements P1431 {
// TODO:
//  N개의 문자열 입력받아 조건에 따라 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Guitar[] guitars = new Guitar[N];

        for (int i = 0; i < N; i++) {
            guitars[i] = new Guitar(br.readLine());
        }

        Arrays.sort(guitars);
        Arrays.stream(guitars).forEach(guitar -> {
            try {
                bw.write(guitar.serial + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.flush();
        bw.close();
    }

    private static class Guitar implements Comparable<Guitar> {
        private String serial;

        public Guitar(String serial) {
            this.serial = serial;
        }

        private int getSum(String serial) {
            int sum = 0;

            for (int i = 0; i < serial.length(); i++) {
                char c = serial.charAt(i);
                if (Character.isDigit(c)) {
                    sum += c - '0';
                    System.out.println(sum);
                }
            }

            return sum;
        }

        @Override
        public int compareTo(Guitar o) {
            if (serial.length() < o.serial.length()) return -1;
            else if (serial.length() > o.serial.length()) return 1;
            else {
                int sum1 = getSum(serial);
                int sum2 = getSum(o.serial);

                if (sum1 < sum2) return -1;
                else if (sum1 > sum2) return 1;
                else return serial.compareTo(o.serial);
            }
        }
    }
}
