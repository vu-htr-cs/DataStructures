import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    //vu-htr-cs
    public static int lilysHomework(List<Integer> arr) {
    // Write your code here
        List<Integer> unsorted1= new ArrayList<>(arr);
        List<Integer> unsorted2= new ArrayList<>(arr);
        Collections.sort(arr);
        int countAsc=0;
        int countDesc=0;
        for(int i=0;i<arr.size();i++){
            if(unsorted1.get(i)!=arr.get(i)){
                int temp=unsorted1.get(i);
                int idx=unsorted1.indexOf(arr.get(i));
                unsorted1.set(i, arr.get(i));
                unsorted1.set(idx,temp );
                countAsc++;
            }
        }
        Collections.sort(arr,Collections.reverseOrder());
         for(int i=0;i<arr.size();i++){
            if(unsorted2.get(i)!=arr.get(i)){
                int temp=unsorted2.get(i);
                int idx=unsorted2.indexOf(arr.get(i));
                unsorted2.set(i, arr.get(i));
                unsorted2.set(idx,temp );
                countDesc++;
            }
        }
        return Math.min(countAsc,countDesc);
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
