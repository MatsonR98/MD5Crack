import java.io.*;

public class user_login {

    public static boolean user_login(String user, String pass){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("userList.txt")); //Create a new reader to read the list of users
            String line;
            while((line = reader.readLine()) != null){
                String credentials[] = line.split("\t"); //Split each line into a username and password using the delimiter \t
                if(credentials[0].equals(user) && credentials[1].equals(md5_hash.md5_hash(pass))){ //Hash the password input and check if the credentials match the hash in the userlist
                    reader.close();
                    return true; //If it matches, return true.
                }
            }
        }
        catch(Exception e){
            return false;
        }
        return false; //Return false if the username or password is incorrect.
    }
}
