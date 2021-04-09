package kakaohairshop;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) {
        DemoTest dt = new DemoTest();
        int[][] v = new int[][] {{1, 4}, {3, 4}, {3, 10}};
        int[] solution = dt.solution(v);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
    public int[] solution(int[][] v) {
        int[] answer = {};
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int[] ints : v) {
            x.add(ints[0]);
            y.add(ints[1]);
        }

        for (Integer integer : x) {
            System.out.println("integerx = " + integer);
        }
        for (Integer integer : y) {
            System.out.println("integery = " + integer);
        }
        List<Integer> all = new ArrayList<>();
        all.addAll(x);
        all.addAll(y);



        System.out.println("Hello Java");

        return answer;
    }
}
