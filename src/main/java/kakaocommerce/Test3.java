package kakaocommerce;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Test3 {
    public static void main(String[] args) {

        Test3 t3 = new Test3();

        int n = 6;
        int[] passenger = new int[]{1,1,1,1,1,1};
        int[][] train = new int[][]{{1,2},{1,3},{1,4},{3,5},{3,6}};

        t3.solution(n,passenger,train);

    }
    public int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {};

        int[][] mase = new int[passenger.length][passenger.length];
        for (int i = 0; i < passenger.length - 1 ; i++) {
            for (int j = 0; j < passenger.length - 1; j++) {
                if (i == train[i][0])
                    mase[i][j] = passenger[i];
                if (j == train[i][1])
                    mase[i][j] = passenger[i];
            }
        }
        for (int i = 0; i < passenger.length; i++) {
            for (int j = 0; j < passenger.length; j++) {
                System.out.print(mase[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < passenger.length-1; i++) {
            System.out.println(train[i][0] + " " + train[i][1]);
        }
        for (int i = 0; i < train.length; i++) {
            System.out.println(train[i][0] + " " + train[i][1]);
        }


        // 현재노드
        int curNode = 1;

        // 방문노드 저장
        Set<Integer> visitedSet = new HashSet<Integer>();

        // DFS 탐색을 위해 Stack을 사용함.
        Stack<Integer> stack = new Stack<Integer>();
        // 0을 시작노드로 설정
        stack.push(curNode);

        while(!stack.isEmpty()) {
            curNode = (int) stack.pop();

            // 방문한 노드이며 skip
            if(visitedSet.contains(curNode) ) {
                continue;
            }

            // 현재 노드를 방문했다고 설정함.
            visitedSet.add(curNode);

            // 방문한 노드를 출력
            System.out.print(curNode + " ");

            // 현재노드와 인접한 노드를 Queue에 저장함.
            for (int i = n-1; i >= 0; i--) {
             if(train[curNode][i] == 1) {
                    stack.push(i);
                }

//            for (int i = 2; i >= 0; i--) {
//                if(train[curNode][i] == 1) {
//                    stack.push(i);
//                }
//            }
        }

        return answer;
    }
}
