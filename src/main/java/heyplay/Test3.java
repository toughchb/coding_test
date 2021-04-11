package heyplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {

        Test3 t3 = new Test3();
        int[] A = new int[]{1, 2, 1};
        t3.solution(A);
    }

    public int solution(int[] A) {

        List<Integer> list = new ArrayList<>();


        List<Integer> dupList = new ArrayList<>();

        for (int i : A) {
            list.add(i);
        }

        int max = Collections.max(list);
        int min = Collections.min(list);





        for (Integer integer : dupList) {
            int i = list.indexOf(integer);

            int integer1 = list.get(i);
            list.set(i, ++integer1);
        }

        System.out.println("dupList = " + dupList);

        return 0;
    }

    public boolean isDup(List<Integer> list) {
        List<Integer> checkList = new ArrayList<>();
        for (Integer integer : list) {
            if (!checkList.contains(integer)) {
                checkList.add(integer);
            }
        }
        if (list.size() > checkList.size()) {
            return true;
        }
        else
            return false;
    }
}
