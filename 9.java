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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
        
         String time=s.substring(8, s.length());
         String hour=s.substring(0, 2);
         String min=s.substring(3, 5);
         String sec=s.substring(6, 8);
          int h=Integer.parseInt(hour);
       
            
            if(time.equals("PM") && h<12){
               
                h=h+12;
                hour=Integer.toString(h);
                
            }else if(time.equals("AM") && h==12){
                
               hour="00";
            }
            
        
        return hour+":"+min+":"+sec;
    
    


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
