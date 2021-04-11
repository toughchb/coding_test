package heyplay;

public class Test1 {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        String G = "RSPRS";
        int solution = t1.solution(G);
        System.out.println("solution = " + solution);
    }

    public boolean isRPS(char c) {
        return (c == 'R' || c == 'P' || c == 'S');
    }

    public int solution(String G) {
        if ((0 > G.length()) || (100 < G.length())) {
            return 0;
        }

        int maxScore = 0;
        int tempScore = 0;

        for (int myTurns = 0; myTurns < 3; myTurns++) {
            for (int i = 0; i < G.length(); i++) {
                char friendsGesture = G.charAt(i);
                if (isRPS(friendsGesture)) {
                    if (myTurns == 0) {
                        //Franco Rock
                        switch (friendsGesture) {
                            case 'S':
                                tempScore += 2;
                                break;
                            case 'R':
                                tempScore += 1;
                                break;
                            default:
                                break;
                        }
                    } else if (myTurns == 1) {
                        //Franco Paper
                        switch (friendsGesture) {
                            case 'R':
                                tempScore += 2;
                                break;
                            case 'P':
                                tempScore += 1;
                                break;
                            default:
                                break;
                        }
                    }
                    else if (myTurns == 2){
                        //Franco Scissors
                        switch (friendsGesture) {
                            case 'P':
                                tempScore += 2;
                                break;
                            case 'S':
                                tempScore += 1;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            if (tempScore >= maxScore) {
                maxScore = tempScore;
            }
            tempScore = 0;
        }
        return maxScore;
    }
}
