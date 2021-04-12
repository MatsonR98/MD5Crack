import java.io.*;

public class user_add{
    public static boolean user_add(String username, String password){
        System.out.println("Adding user "+username+"...");

        //Check if user is already in database
        try{
            BufferedReader reader = new BufferedReader(new FileReader("userList.txt"));
            String line;
            while((line = reader.readLine()) != null){
                String credentials[] = line.split("\t");
                if(credentials[0].equals(username)){
                    System.out.println("User already exists.");
                    return false;
                }
            }
            reader.close();
        }
        catch(Exception e){
            return false;
        }

        //Add the user using a buffered writer
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
