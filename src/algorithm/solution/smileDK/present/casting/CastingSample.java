package algorithm.solution.smileDK.present.casting;

import java.util.ArrayList;
import java.util.List;

public class CastingSample {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();

        Parent p2 = (Parent) c;
//        Parent p2 = new Child();
        Child c2 = (Child) p2;


        List<Integer> list = new ArrayList<>();
        Parent[] pl = new Parent[]{p, c2};
    }
}
