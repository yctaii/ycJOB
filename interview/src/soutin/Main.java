package soutin;

import java.util.*;

class Solution {
    public void myFunc(ArrayList<ArrayList<Integer>> arr) {

    }
}
public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        while(cin.hasNextLine())
        {
            ArrayList<Integer> row = new ArrayList<Integer>();
            String line = cin.nextLine();
            if (line.length() > 0) {
                String[] arrLine = line.split(" ");
                for (int i=0; i<arrLine.length; i++) {
                    row.add(Integer.parseInt(arrLine[i]));
                }
                arr.add(row);
            }else {
                break;
            }
        }
        cin.close();

        arr.stream().flatMap(ArrayList::stream)
                .forEach(value -> System.out.print(value + " "));

        Solution slution = new Solution();
        slution.myFunc(arr);

    }
}