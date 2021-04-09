package kakaocommerce;

import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {

        Test1 t1 = new Test1();
        int[] gift_cards = new int[]{5, 4, 5, 4, 5};
        int[] wants = new int[]{1, 2, 3, 5, 4};

        int answer = t1.solution(gift_cards,wants);
        System.out.println("answer = " + answer);

    }

    static void swap(int[] array, int index1, int index2){
        int iTemp;
        iTemp = array[index1];
        array[index1] = array[index2];
        array[index2] = iTemp;
    }
    public int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        boolean[] satisfy = new boolean[gift_cards.length];
        Arrays.fill(satisfy, Boolean.FALSE);

        for (int i = 0; i < gift_cards.length; i++) {
            if ((satisfy[i] == false) && (gift_cards[i] == wants[i])) {
                satisfy[i] = true;
            }
        }

        for (int i = 0; i < gift_cards.length; i++) {
            for (int j = 0; j < gift_cards.length; j++) {
                if (i == j) {
                    continue;
                }
                if ((satisfy[i] == false) && (wants[i] == gift_cards[j])) {
                    swap(gift_cards,i,j);
                    satisfy[i] = true;
                }
            }
        }
        for (boolean sat : satisfy) {
            if(!sat)
                answer++;
        }
        return answer;
    }
}
