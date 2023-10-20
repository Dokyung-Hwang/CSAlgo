package algorithm.solution.NtoZero_LST.boj.stack;


import algorithm.problem.baejoon.stack.P10828;

import java.io.*;

public class S10828 implements P10828 {
    /*
        시간 제한 0.5초, 메모리 제한 256MB
        연산의 수 N, 최대 10^5 / 주어지는 정수 K <10^6
        - 시간 복잡도 : NlogN 이하 권장됨

     */
    static int[] data; // 스택의 요소를 담을 배열
    static int pos; // 스택의 길이, 요소 개수
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        data = new int[N];
        pos = 0;

        for(int i=0; i<N; i++) {
           String[] commandLine = br.readLine().split(" ");
           String command = commandLine[0];
           String num = commandLine.length>1 ? commandLine[1] : "";

           switch(command) {
               case "push" :
                   int pushNum = Integer.parseInt(num);
                   push(pushNum);
                   break;
               case "pop" :
                   pop();
                   break;
               case "size" :
                   size();
                   break;
               case "empty" :
                   isEmpty();
                   break;
               case "top" :
                   top();
                   break;
           }
        }
        bw.close();
    }

    static void push(int num) {
        data[pos++] = num;
    }

    static void pop() throws IOException {
        if(pos > 0)
            bw.write(String.valueOf(data[--pos]));
        else // pos == 0
            bw.write("-1");
        bw.write("\n");
    }

    static void size() throws IOException {
        bw.write(String.valueOf(pos)+"\n");
    }

    static boolean isEmpty() throws IOException {
        int print =
                pos == 0 ? 1 : 0;
        bw.write(String.valueOf(print)+"\n");

        return pos==0;
    }

    static void top() throws IOException {
        if(pos > 0)
            bw.write(String.valueOf(data[pos-1]));
        else if(pos == 0)
            bw.write(String.valueOf(-1));
        bw.write("\n");
    }

}
