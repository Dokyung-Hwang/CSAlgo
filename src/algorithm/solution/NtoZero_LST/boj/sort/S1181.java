package algorithm.solution.NtoZero_LST.boj.sort;

import algorithm.problem.baekjoon.sort.P1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1181 implements P1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Words[] wordArr = new Words[N];
        for(int i=0; i<N; i++) {
            wordArr[i] = new Words(br.readLine());
        }

        Arrays.sort(wordArr);

        StringBuilder sb = new StringBuilder();
        String beforeWord = "";
        for(Words w : wordArr) {
            if(!beforeWord.equals(w.word))
                sb.append(w.word+"\n");
            beforeWord = w.word;
        }
        System.out.println(sb);
    }

    static class Words implements Comparable<Words> {
        String word;

        public Words(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Words other) {
            if(word.length()!=other.word.length())
                return this.word.length()-other.word.length();

            int comp = 0;
            for(int i=0; i<word.length(); i++) {
                char c1 = word.charAt(i);
                char c2 = other.word.charAt(i);
                if(c1!=c2) {
                    comp = c1-c2;
                    break;
                }
            }
            return comp;
        }
    }
}
