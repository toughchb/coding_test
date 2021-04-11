package cp;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

    public boolean solution(int[] arr, int n) {
        boolean answer = false;
        if ((n > 100000000) || (arr.length > 500000) || (arr.length < 1)) {
            return false;
        }
        List<Integer> smallerNList = new ArrayList<>(); /* n보다 작은 arr요소 의 index를 담을 배열 */

        /* arr의 요소가 n 보다 작은지 확인 그 수가 1 이하이면 무조건 false  */
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < n) {
                smallerNList.add(i);
            }
        }

        if (smallerNList.size() <= 1) {
            return false;
        }
        else if (smallerNList.size() == 2) { /* n보다 작은 arr의 요소의 개수가 2개면 바로 덧셈해서 확인 */
            if ((arr[smallerNList.get(0)] + arr[smallerNList.get(1)]) == n) {
                return true;
            } else {
                return false;
            }
        } /* 3개 이상 일때 */
        else {

            for (int i = 0; i < smallerNList.size(); i++) {
                int temp = n - arr[smallerNList.get(i)]; /* 다음 요소들 부터 temp 랑 비교하여 둘의 합이 n인지 확인*/
                for (int j = i + 1; j < smallerNList.size(); j++) {
                    if (temp == arr[smallerNList.get(j)]) {
                        return true;
                    }
                }
            }

        }

        return false; /* 다 돌았는데 못찾으면 false */
    }

    public static void main(String[] args) {
        Test3 t3 = new Test3();
        int[] arr = new int[]{5, 3, 9, 13};

        int n = 7;

        boolean ret = t3.solution(arr, n);
        System.out.println("ret = " + ret);
    }
}
