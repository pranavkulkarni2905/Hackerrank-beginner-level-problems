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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
        
        
        int minCount=0;
        int maxCount=0;
        
        int min=scores.get(0);
        int max=scores.get(0);
        
        List<Integer> res=new ArrayList<>();
        HashMap<String,Integer> hmap=new HashMap<>();
        
        hmap.put("Min",min);
        hmap.put("Max",max);
        
        for(int i=1;i<scores.size();i++){
            if(hmap.get("Min")>scores.get(i)){
                hmap.put("Min", scores.get(i));
                minCount++;
            }
            if(hmap.get("Max")<scores.get(i)){
                hmap.put("Max", scores.get(i));
                maxCount++;
            }
            
        }
        res.add(maxCount);
        res.add(minCount);
        return res;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
