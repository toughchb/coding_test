package cp;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Test2 {

    /***
     * @param current 기존에 들은 성적
     * @param future 방금 들은 성적
     * @return 성적이 같으면 0 방금 들은게 더 높으면 1 작으면 -1
     */
    public int compareGrades(String current, String future) {
            byte[] curBytes = current.getBytes(StandardCharsets.UTF_8);
            byte[] futBytes = future.getBytes(StandardCharsets.UTF_8);

        if (curBytes[0] == futBytes[0]) {
            if (curBytes[0] == 'F') {
                return 0;
            }
            if (curBytes[1] == futBytes[1]) {
                return 0;
            }
            if (curBytes[1] == '+') {
                switch (futBytes[1]) {
                    case '0':
                    case '-':
                        return -1;
                }
            } else if (curBytes[1] == '0') {
                switch (futBytes[1]) {
                    case '-':
                        return -1;
                }
            }
            return 1;
        } else {
            if (curBytes[0] == 'A') {
                return -1;
            }
            if (curBytes[0] == 'B') {
                if ((futBytes[0] == 'C') || (futBytes[0] == 'D') || futBytes[0] == 'F') {
                    return -1;
                }
            }
            if (curBytes[0] == 'C') {
                if ((futBytes[0] == 'D') || (futBytes[1] == 'F')) {
                    return -1;
                }
            }
            if (curBytes[0] == 'D') {
                if (futBytes[1] == 'F') {
                    return -1;
                }
            }
            return 1;
        }
    }

    public String[] solution(String[] grades) {
        String[] answer = {};

        Map<String, String > map = new HashMap<>();

        for (String grade : grades) {
            String[] s = grade.split(" ");

            if (!map.containsKey(s[0])) { /* 해당 학정 번호가 없으면 삽입 */
                map.put(s[0],s[1]);
                System.out.println("s[0] = " + s[0] + ", s[1] = " + s[1]);
            }
            else { /* 있으면 */
                if (compareGrades(map.get(s[0]),s[1]) ==1 )
                    map.put(s[0],s[1]);
            }
        }
        Stream<Map.Entry<String, String>> sorted =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue());
        for (String s : map.keySet()) {
            System.out.println("s  = " + s + ", value = " + map.get(s));
        }


        return answer;
    }
    public static void main(String[] args) {

        Test2 t2 = new Test2();

        String[] grades = new String[]{
                "DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+",
                "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"
        };

        t2.solution(grades);
    }
}
