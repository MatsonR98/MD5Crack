import java.io.*;
public class password_cracker {
    public static String password_cracker(String user){

        //Type 1 passwords
        System.out.println("Now attempting all Type 1 passwords (Full-text matches):");
        try{
            BufferedReader userpassword = new BufferedReader(new FileReader("userList.txt"));
            BufferedReader dict = new BufferedReader(new FileReader("dictionary.txt"));
            String line = null;
            String hash = null;
            boolean user_found = false;
            while((line = userpassword.readLine()) != null && user_found == false){
                String credentials[] = line.split("\t");
                if(credentials[0].equals(user)){
                    hash = credentials[1];
                    user_found = true;
                }
            }
            userpassword.close();

            while((line = dict.readLine()) != null){
                String tmp_hash = md5_hash.md5_hash(line);
                if(tmp_hash.equals(hash)){
                    return line;
                }
            }
            System.out.println("No Type 1 matches.");
        }
        catch(Exception e){
            System.out.println("An error occurred.");
            return null;
        }




        //Type 2 passwords
        
        return null;
    }
}
