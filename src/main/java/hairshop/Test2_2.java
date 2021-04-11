package hairshop;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Test2_2 {
    //  method checks, character is operator or not
    boolean isOperator(char op)
    {
        return (op == '+' || op == '-' || op == 'x');
    }

    //  Utility recursive method to get all possible
    // result of input string
    Vector<Integer> possibleResultUtil(String input, Map<String, Vector<Integer> > memo)
    {
        //  If already calculated, then return from memo
        if (memo.get(input) != null)
            return memo.get(input);

        Vector<Integer> res = new Vector<>();
        for (int i = 0; i < input.length(); i++)
        {
            if (isOperator(input.charAt(i)))
            {
                // If character is operator then split and
                // calculate recursively
                Vector<Integer> resPre =
                        possibleResultUtil(input.substring(0, i), memo);
                Vector<Integer> resSuf =
                        possibleResultUtil(input.substring(i + 1), memo);

                //  Combine all possible combination
                for (int j = 0; j < resPre.size(); j++)
                {
                    for (int k = 0; k < resSuf.size(); k++)
                    {
                        if (input.charAt(i) == '+')
                            res.add(resPre.get(j) + resSuf.get(k));
                        else if (input.charAt(i) == '-')
                            res.add(resPre.get(j) - resSuf.get(k));
                        else if (input.charAt(i) == 'x')
                            res.add(resPre.get(j) * resSuf.get(k));
                    }
                }
            }
        }

        // if input contains only number then save that
        // into res vector
        if (res.size() == 0)
            res.add(Integer.valueOf(input));

        // Store in memo so that input string is not
        // processed repeatedly
        memo.put(input, res);
        return res;
    }

    //  method to return all possible output
// from input expression
    Vector<Integer> possibleResult(String input)
    {
        Map<String, Vector<Integer> > memo = new HashMap<>();
        return possibleResultUtil(input, memo);
    }

    public void solution(String expression) {
        for (int i = 1; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i)))
                continue;
            String substring = expression.substring(0, i);
            System.out.println("left substring = " + substring);


        }

        for (int i = expression.length()-1 ; i > 1; i--) {
            if (Character.isDigit(expression.charAt(i)))
                continue;
            String substring = expression.substring(i +1, expression.length());
            System.out.println("right substring = " + substring);


        }

    }

    public static void main(String[] args) {
        Test2_2 t2 = new Test2_2();
        String expression = "2-1x5-4x3+2";
        t2.solution(expression);
    }
}
