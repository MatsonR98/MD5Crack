import java.util.*;
import java.io.*;

public class password_evaluator {
    private static String DICT = "dictionary.txt";
    private static HashSet words = new HashSet<String>();

    public static String password_evaluator(String password) throws FileNotFoundException, IOException{
        BufferedReader dictReader = new BufferedReader(new FileReader(DICT));
        String cur = "";
        while((cur = dictReader.readLine()) != null){
            words.add(cur);
        }

        String strippedPass = password.replaceAll("[^a-zA-Z]", "");
        if(words.contains(strippedPass)){
            if(strippedPass.equals(password)){
                return "weak password";
            }
            else{
                return "moderate password";
            }
        }

        System.out.println(strippedPass);
        return "strong password";
    }
}
