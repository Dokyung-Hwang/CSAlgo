package algorithm.solution.smileDK.baejoon.linkedList;

import algorithm.problem.baekjoon.linkedList.P5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

/* Memo.
    '-': 백스페이스
    '<': left
    '>': right
* */

public class S5397 implements P5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < l; i++) {
            String inputString = br.readLine();
            LinkedList<Character> linkedList = new LinkedList<>();
            ListIterator<Character> iter = linkedList.listIterator();

            for (int j = 0; j < inputString.length(); j++) {
                char c = inputString.charAt(j);

                switch(c) {
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    case '<':
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>':
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    default:
                        iter.add(c);
                }
            }
            for(char c : linkedList) sb.append(c);
            sb.append("\n");
        }


        System.out.println(sb);
    }
}
