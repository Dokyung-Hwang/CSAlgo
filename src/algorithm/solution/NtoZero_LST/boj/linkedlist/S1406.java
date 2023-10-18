package algorithm.solution.NtoZero_LST.boj.linkedlist;


import algorithm.problem.baejoon.linkedList.P1406;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class S1406 implements P1406 {
    /*
        시간 제한 2초, 메모리 제한 512MB
        N(문자열의 길이) 10^5, M(입력할 명령어의 개수) 5*10^5
        - 자료 구조 : LinkedList(연결 리스트)
            - 조회가 빈번하면 ArrayList(배열), 커서의 위치를 알고 있는 상태에서 입력/수정/삭제가 빈번하면 LinkedList를 사용하는 것이 좋다.
              현재 문제는 커서의 위치가 주어지므로, 입력/수정/삭제의 시간 복잡도가 O(1)인 연결 리스트를 사용해야 한다.
              💡 단, 자바에서 커서의 위치가 제공된 상황에서의 LinkedList 삽입/삭제 연산, O(1)을 수행하기 위해서는 ListIterator를 사용해야 한다.
        - 시간 복잡도 : O(M) -> 최대 M번만큼 좌우 한 칸 이동 O(1) 또는 쓰기 연산 O(1)을 한다. (M*1번의 연산)
            - 만약 ArrayList를 사용한다면 좌우 한 칸 이동 O(1) 또는 쓰기 연산 O(N)을 하므로 최악의 경우 N*M에 가까운 시간 복잡도가 계산된다.
     */

    static LinkedList<String> list = new LinkedList<>();
//    static int cursor; // 0<=cursor<=list.size() ❌ ListIterator 사용 시 별도의 커서가 필요하지 않다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String content = br.readLine();
        //ListIterator 생성
        ListIterator<String> iter = list.listIterator();

        // 커서가 마지막 content.length()에 위치한다.
        for(int i=0; i<content.length(); i++) {
            iter.add(content.charAt(i)+"");
        }
        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++) {
            String[] commandLine = br.readLine().split(" ");
            String command = commandLine[0];
            String str = commandLine.length>1 ? commandLine[1] : "";
            edit(command, str, iter);
        }

        //iter의 커서 위치 초기화
        iter = list.listIterator();

        while(iter.hasNext()) {
            bw.write(iter.next());
        }
        bw.close();
    }

    static void edit(String command, String str, ListIterator iter) {
        switch(command) {
            case "L":
                if(iter.hasPrevious())
                    iter.previous();
                break;
            case "D":
                if(iter.hasNext())
                    iter.next();
                break;
            case "B":
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
                break;
            case "P":
                iter.add(str);
                break;
        }
    }
}

// 참조 할만한 사이트 : https://minhamina.tistory.com/17 -> 스택으로도 풀이할 수 있다.

// 시간 초과가 발생하는 풀이1 (순수 LinkedList)
//  => 💡 함정 : 자바 LinkedList의 add, remove 메서드는 커서의 위치가 제공 되었다고 해서 바로 그 위치에서 삽입/삭제가 이루어지는 것이 아니다.
//               자바의 LinkedList는 이동(O(N)) 후 제거/삭제 한다. ListIterator를 작성해서 previous(), next() 등으로 커서를 옮겨야 한다.
/*
static LinkedList<String> list = new LinkedList<>();
    static int cursor; // 0<=cursor<=list.size()
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String content = br.readLine();
        for(int i=0; i<content.length(); i++) {
            list.add(content.charAt(i)+""); //❌ add 역시 시간 복잡도가 O(N)이다. (이동 후 삽입)
        }
        cursor = list.size();
        int M = Integer.valueOf(br.readLine());

        for(int i=0; i<M; i++) {
            String[] commandLine = br.readLine().split(" ");
            String command = "", str = "";
            if(commandLine.length>=2) {
                command = commandLine[0];
                str = commandLine[1];
            } else {
                command = commandLine[0];
            }
            edit(command,str);
        }

        for(int i=0; i<list.size(); i++) {
            bw.write(list.get(i)); //❌ get 메서드는 이동 후 조회하는 것이라 O(N)만큼의 시간 복잡도가 발생한다.
        }
        bw.close();
    }

    static void edit(String command, String str) {
        switch(command) {
            case "L":
                if(cursor>0)
                    cursor--;
                break;
            case "D":
                if(cursor<list.size())
                    cursor++;
                break;
            case "B":
                if(cursor>0)
                    list.remove(--cursor); //❌ 자바 LinkedList의 remove는 이동 O(N) 후 제거
                break;
            case "P":
                             //왼쪽에 추가 후 cursor+1
                list.add(cursor++,str);   //❌ 자바 LinkedList의 add는 이동 O(N) 후 삽입
                break;
        }
    }
 */
