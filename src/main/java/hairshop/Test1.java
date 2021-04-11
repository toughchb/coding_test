package hairshop;


import java.util.Arrays;

import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        //test1.solution("ABBCCCBBAB");
        System.out.println(test1.solution("AAAABCCCCC"));

    }

    public String solution(String vote) {
        String answer = "";
        String[] split = vote.split("");

        Map<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(
                e -> e, Collectors.counting()
        ));
//        for (String s : collect.keySet()) {
//            System.out.println("s = " + s);
//            System.out.println("value = " + collect.get(s));
//        }
        Long countA = collect.get("A");
        Long countB = collect.get("B");
        Long countC = collect.get("C");

        int totalVoters = vote.length();
        if (countC >= totalVoters / 2) {
            return "C";
        }
        if (countA.equals(countB)) {
            return "AB";
        }
        if (countA > countB) {
            return "A";
        } else {
            return "B";
        }



//        List<String> list = new ArrayList<>();
//
//        list.stream()
//                .collect(Collectors)
    }
}
