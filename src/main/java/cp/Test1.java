package cp;

public class Test1 {
    /**
     * 조건 1. 구간의 모든 연속된 원소들의 합이 S 이상이어야 합니다.
     * 조건 2. 위의 조건을 만족하는 구간 중 가장 길이가 짧아야 합니다.
     */
    public int solution(int []A, int S) {
        if ((A.length > 100000) || (S > 1000000000)){
            return 0;
        }

        int minLength = -1;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum >= S) {
                    int tempLength = j - i + 1;
                    if (minLength == -1) { //조건 1에 만족하는 맨 처음 길이
                        minLength = tempLength;
                        continue;
                    } else if (tempLength < minLength) { // 조건2 를 찾기위한 비교
                        minLength = tempLength;
                        continue;
                    }
                }
            }
        }
        //합이 S를 만족하는 구간이 없을때
        if (minLength == -1) {
            minLength = 0;
        }

        return minLength;
    }

    public static void main(String[] args) {

        Test1 t1 = new Test1();
        int[] A = new int[]{1,10,2,9,3,8,4,7,5,6};
        int S = 20;

        t1.solution(A,S);
    }
}
