package algorithm.solution.smileDK.baejoon.string;

import algorithm.problem.baekjoon.string.P1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1543 implements P1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String keyword = br.readLine();

        int documentLength = document.length();


        document = document.replace(keyword, "");

        System.out.println((documentLength - document.length()) / keyword.length());

    }
}
