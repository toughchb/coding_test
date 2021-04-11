package enterprise;

import java.util.*;

public class Solution {
    public int segment(int x, List<Integer> space)
    {
        int chunkNum = 1;
        Stack<Integer> s = new Stack<>();
        s.push(space.get(0));

        for (int i = 1; i < space.size(); i++)
        {
            // first chunk
            if (i < x)
            {
                //if (space.get(i) < space.get(s.peek()))
                if (space.get(i) < s.peek())
                {
                    s.pop();
                    s.push(space.get(i));
                }
            }
            // other chunks
            else
            {
                // if found minimum is member of current chunk we just need to compare current number with it
                Integer peek = s.peek();
                if (peek >= chunkNum)
                {
                    //s.push(space.get(i) < space.get(peek) ? i: peek);
                    s.push(space.get(i) < peek ? space.get(i): peek);
                }
                // we have to loop through current chunk to find minimum number
                else
                {
                    s.push(space.get(i));

                    int j = chunkNum;
                    int count = 0;
                    while (count++ < x)
                    {
                        if (space.get(j) < space.get(s.peek()))
                        {
                            s.pop();
                            s.push(j);
                        }
                        j++;
                    }
                }
                // we are ready to go to next chunk
                chunkNum++;
            }
        }

        Integer max = Collections.max(s);

        //Integer result = s.stream().max(Comparator.comparingInt(Integer::intValue)).get();
        //List<Integer> temp = new ArrayList<>(s);


        return max;
        //return s.select(c => space[c]).Max();
    }

    public static void main(String[] args) {
        Solution s2 = new Solution();
        int x = 3;
        List<Integer> spaces = new ArrayList<>(Arrays.asList(2,5,4,6,8));

        System.out.println(s2.segment(x,spaces));
    }
}
