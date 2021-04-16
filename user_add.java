import java.io.*;

public class user_add{
    public static boolean user_add(String username, String password){
        System.out.println("Adding user "+username+"...");
        try{
            BufferedReader reader = new BufferedReader(new FileReader("userList.txt"));
            String line;

            //Check if the user already exists in the list
            while((line = reader.readLine()) != null){
                String credentials[] = line.split("\t"); //Split each line on the delimiter \t
                if(credentials[0].equals(username)){ //Add fails if a user already exists in the list
                    System.out.println("User already exists.");
                    return false;
                }
            }
            reader.close();
        }
        catch(Exception e){

        }
        try{
            BufferedWriter userList = new BufferedWriter(new FileWriter("userList.txt", true)); //Open a filewriter
            String passwordHash = md5_hash.md5_hash(password); //Hash the input password
            userList.write(username + "\t" + passwordHash); //Write the username and password to the file with a \t delimiter in between
            userList.newLine(); //Add a newline for the next add
            System.out.println("...Done.");
            userList.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
