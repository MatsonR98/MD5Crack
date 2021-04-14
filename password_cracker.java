import java.util.*;
import java.io.*;
public class password_cracker {

    public static final String[] SPECIAL_CHARS = {"@", "#", "$", "%", "&"};
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

        while((cur = dictReader.readLine()) != null){
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
        BufferedReader dictSort = new BufferedReader(new FileReader(DICT));
        BufferedWriter file = null;
        String cur = "";
        TreeSet[] wordlist = new TreeSet<?>[28];

        for(int ct = 0; ct < wordlist.length; ct++){
            wordlist[ct] = new TreeSet<String>();
        }

        //Add each word to a bucket based on its length.
        System.out.println("Sorting passwords into buckets...");
        while((cur = dictSort.readLine())!= null){
            wordlist[cur.length()-1].add(cur);
        }

        for(int setnum = 0; setnum<28; setnum++){
            Iterator itr = wordlist[setnum].iterator();
            while(itr.hasNext()){
                String str = (String) itr.next();
            }
        }
        dictSort.close();
        System.out.println("Type 2 passwords exhausted.");
        return null;
    }
}
