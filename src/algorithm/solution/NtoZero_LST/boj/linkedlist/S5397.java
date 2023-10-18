package algorithm.solution.NtoZero_LST.boj.linkedlist;


import algorithm.problem.baejoon.linkedList.P5397;

import java.util.*;
import java.io.*;

public class S5397 implements P5397 {
    /*
        시간 제한 1초, 메모리 제한 256MB
        테스트케이스 개수 K, 문자열의 길이 L, 1<=L<=10^6
        - 시간 복잡도 : NlogN 이하 사용 가능. 이 때, N= K*L. (사실 K의 조건도 K는 10^2 이하로 주어져야 한다고 생각한다.)
        - 자료 구조 : LinkedList + ListIterator의 조합 (커서가 정해진 상태에서 삽입/삭제 연산 O(1))
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TCNum = Integer.parseInt(br.readLine());

        for(int i=0; i<TCNum; i++) {
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            String password = br.readLine();

            for(int k=0; k<password.length(); k++) {
                char c = password.charAt(k);
                switch(c) {
                    case '<':
                        if(iter.hasPrevious())
                            iter.previous();
                        break;
                    case '>':
                        if(iter.hasNext())
                            iter.next();
                        break;
                    case '-':
                        if(iter.hasPrevious()){
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                        break;
                }
            }
            for(char c : list) {
                bw.write(c);
            }
            bw.write("\n");
        }
        bw.close();
    }
}
