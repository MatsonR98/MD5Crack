import java.util.*;
import java.io.*;
import java.lang.*;
public class password_cracker {

    public static final String[] CH = {"","@","#","$","%","&","0","1","2","3","4","5","6","7","8","9"};
    public static String USERLIST = "userList.txt";
    public static String DICT = "dictionary.txt";

    public static String password_cracker(String user){
        try{
            BufferedReader userReader = new BufferedReader(new FileReader(USERLIST));

            String tmp_creds = "";
            String[] creds = null;
            String hash = "";

            boolean found = false;
            while((tmp_creds = userReader.readLine()) != null){
                creds = tmp_creds.split("\t");
                hash = creds[1];
                if(creds[0].equals(user)){
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("This account does not exist.");
                return null;
            }
            

            String pass = null;
            if((pass = Type1(hash)) != null){
                System.out.println("Password is a Type 1 password.");
                return pass;
            }
            if((pass = Type2(hash)) != null){
                System.out.println("Password is a Type 2 password.");

                return pass;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    //Try and find a type 1 password
    private static String Type1(String passwordHash) throws FileNotFoundException, IOException{
        BufferedReader dictReader = new BufferedReader(new FileReader(DICT));

        String cur = "";

        //Use a bufferedreader to iterate through the dictionary list
        while((cur = dictReader.readLine()) != null){
            //Hash the current password and compare them to the hash
            if(md5_hash.md5_hash(cur).equals(passwordHash)){ 
                dictReader.close();
                return cur;
            }
        }
        dictReader.close();
        System.out.println("Type 1 passwords exhausted.");
        return null;
    }
    


    //Try and find a type 2 password
    private static String Type2(String passwordHash) throws FileNotFoundException, IOException{
        //Create a new BufferedReader to open dictionary.txt
        BufferedReader dictSort = new BufferedReader(new FileReader(DICT));
        //Create a new TreeSet to store the words in
        TreeSet wordBucket = new TreeSet<String>();
        String cur = "";
        while((cur = dictSort.readLine()) != null){
            wordBucket.add(cur);
        }
        
        //Reuse the cur placeholder as part of the Type 2 cracker
        cur = "";
        
        //For each word, run through each word and attempt all permutations of characters
        //Structure: CH[outerLeft]+CH[innerLeft]+cur+CH[innerRight]+CH[outerRight]
        for(int outerLeft=0; outerLeft<CH.length; outerLeft++){
            for(int innerLeft=0; innerLeft<CH.length; innerLeft++){
                for(int outerRight=0; outerRight<CH.length; outerRight++){
                    for(int innerRight=0; innerRight<CH.length; innerRight++){
                        Iterator<String> it = wordBucket.iterator();
                        while(it.hasNext()){
                            cur = it.next();
                            String guess = CH[outerLeft]+CH[innerLeft]+cur+CH[innerRight]+CH[outerRight];
                            String guessHash = md5_hash.md5_hash(guess);
                            if(guessHash.equals(passwordHash)){
                                return guess;
                            }
                        }
                    }
                }
            }
        }
        //This point will not be reached if the password is successfully cracked.
        System.out.println("Type 2 passwords exhausted.");
        return null;
    }
}
