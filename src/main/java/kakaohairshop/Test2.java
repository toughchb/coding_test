package kakaohairshop;

import java.util.Vector;

public class Test2 {

    // Utility method to check whether a character
    // is operator or not
    static boolean isOperator(char op)
    {
        return (op == '+' || op == 'x' || op == '-');
    }

    // method prints minimum and maximum value
    // obtainable from an expression
    static void printMinAndMaxValueOfExp(String exp)
    {
        Vector<Integer> num = new Vector<Integer>();
        Vector<Character> opr = new Vector<Character>();
        String tmp = "";

        //  store operator and numbers in different vectors
        for (int i = 0; i < exp.length(); i++)
        {
            if (isOperator(exp.charAt(i)))
            {
                opr.add(exp.charAt(i));
                num.add(Integer.parseInt(tmp));
                tmp = "";
            }
            else
            {
                tmp += exp.charAt(i);
            }
        }

        //  storing last number in vector
        num.add(Integer.parseInt(tmp));

        int len = num.size();
        int[][] maxVal = new int[len][len];

        //  initializing minval and maxval 2D array
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                maxVal[i][j] = 0;

                //  initializing main diagonal by num values
                if (i == j)
                    maxVal[i][j] = num.get(i);
            }
        }

        // looping similar to matrix chain multiplication
        // and updating both 2D arrays
        for (int L = 2; L <= len; L++)
        {
            for (int i = 0; i < len - L + 1; i++)
            {
                int j = i + L - 1;
                for (int k = i; k < j; k++)
                {
                    int minTmp = 0, maxTmp = 0;

                    // if current operator is '+', updating
                    // tmp variable by addition
                    if (opr.get(k) == '+')
                    {
                        maxTmp = maxVal[i][k]
                                + maxVal[k + 1][j];
                    }

                    // if current operator is '*', updating
                    // tmp variable by multiplication
                    else if (opr.get(k) == 'x')
                    {
                        maxTmp = maxVal[i][k]
                                * maxVal[k + 1][j];
                    }

                    else if (opr.get(k) == '-')
                    {
                        maxTmp = maxVal[i][k]
                                - maxVal[k + 1][j];
                    }

                    //  updating array values by tmp
                    //  variables
                    if (maxTmp > maxVal[i][j])
                        maxVal[i][j] = maxTmp;
                }
            }
        }

        //  last element of first row will store the result
        System.out.print(
                        ", Maximum value : " + maxVal[0][len - 1]);
    }

    private static void parenthesis(String expression) {
        resultStorage = new long[100][100][100];
        long[] results = parenthesis(expression, 0, 0);
        System.out.println();
        System.out.println("=====> " + expression + " -> " + results[0] + "/" + results[1]);
    }

    private static long[][][] resultStorage;

    public static long[] parenthesis(String expression, int start, int end) {
        if (resultStorage[start][end][2] == 1)
            return resultStorage[start][end];

        try {
            long parsedLong = Long.parseLong(expression);
            return new long[] { parsedLong, parsedLong, 1 };
        } catch (NumberFormatException e) {
            //
        }

        long[] result = { Integer.MAX_VALUE, Integer.MIN_VALUE, 1 };
        for (int i = 1; i < expression.length() - 1; i++) {
            if (Character.isDigit(expression.charAt(i)))
                continue;
            long[] left = parenthesis(expression.substring(0, i), start, start + i);
            long[] right = parenthesis(expression.substring(i + 1, expression.length()), start + i + 1, end);
            for (int li = 0; li < 2; li++) {
                for (int ri = 0; ri < 2; ri++) {
                    switch (expression.charAt(i)) {
                        case '+':
                            result[0] = Math.min(result[0], left[li] + right[ri]);
                            result[1] = Math.max(result[1], left[li] + right[ri]);
                            break;
                        case '-':
                            result[0] = Math.min(result[0], left[li] - right[ri]);
                            result[1] = Math.max(result[1], left[li] - right[ri]);
                            break;
                        case 'x':
                            result[0] = Math.min(result[0], left[li] * right[ri]);
                            result[1] = Math.max(result[1], left[li] * right[ri]);
                            break;
                    }
                }
            }
        }

        resultStorage[start][end] = result;
        return result;
    }

    public static void main(String[] args) {
        String expression = "2-1x5-4x3+2";
        printMinAndMaxValueOfExp(expression);
        parenthesis(expression);

    }

}
