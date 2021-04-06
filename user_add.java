import java.io.*;

public class user_add{
    public static boolean user_add(String username, String password){
        System.out.println("Adding user "+username+"...");
        try{
            BufferedWriter userList = new BufferedWriter(new FileWriter("userList.txt", true));
            String passwordHash = md5_hash.md5_hash(password);
            userList.write(username + "\t" + passwordHash);
            userList.newLine();
            System.out.println("...Done.");
            userList.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
