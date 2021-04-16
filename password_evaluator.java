import java.util.*;
import java.io.*;

public class password_evaluator {
    private static String DICT = "dictionary.txt";
    private static HashSet words = new HashSet<String>();

    public static String password_evaluator(String password) throws FileNotFoundException, IOException{
        BufferedReader dictReader = new BufferedReader(new FileReader(DICT));
        String cur = ""; //String value holding the current word in the list

        //Pull each word from the file and add to the hashset
        while((cur = dictReader.readLine()) != null){
            words.add(cur); 
        }

        String strippedPass = password.replaceAll("[^a-zA-Z]", ""); //Strip all the non-characters from the word
        
        if(words.contains(strippedPass)){ //If the list contains the word, then the stripped password is either weak or moderate
            if(strippedPass.equals(password)){ //Compare the stripped password to the original password; if nothing has been stripped, then it is a weak password.
                return "weak password";
            }
            else{ //If the password was stripped of characters and still mateches, then it is a moderate password.
                return "moderate password";
            }
        }
        return "strong password"; //If no words match the stripped password, then it is a strong password
    }
}
