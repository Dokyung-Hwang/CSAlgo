package algorithm.solution.smileDK.baejoon.linkedList;

import algorithm.problem.baekjoon.linkedList.P1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class S1406 implements P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        int m = Integer.parseInt(br.readLine());

        LinkedList<Character> initString = new LinkedList<>();
        ListIterator<Character> iter = initString.listIterator();

        for (char c : inputLine.toCharArray()) {
            iter.add(c);
        }

        for (int i = 0; i < m; i++) {
            String command = br.readLine();
            if (command.charAt(0) == 'L') {
                if (iter.hasPrevious())
                    iter.previous();
            }
            else if (command.charAt(0) == 'D') {
                if (iter.hasNext())
                    iter.next();
            }
            else if (command.charAt(0) == 'P') {
                iter.add(command.charAt(2));
            }
            else {
                if (iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character c : initString) {
            result.append(c);
        }

        System.out.println(result);
    }
}
