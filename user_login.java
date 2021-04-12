import java.io.*;

public class user_login {

    public static boolean user_login(String user, String pass){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("userList.txt"));
            String line;
            while((line = reader.readLine()) != null){
                String credentials[] = line.split("\t");
                if(credentials[0].equals(user) && credentials[1].equals(md5_hash.md5_hash(pass))){
                    reader.close();
                    return true;
                }
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }
}
