package algorithm.solution.NtoZero_LST.boj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set = {"c=", "c-", "d-", "lj", "nj", "s=", "dz=","z="};
        String target = br.readLine();


        for(int i=0; i<set.length; i++) {
            if(target.contains(set[i]))
                target = target.replace(set[i], "!");
        }

        System.out.println(target.length());
    }
}
