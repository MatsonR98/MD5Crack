import java.io.*;
import java.util.*;

public class md5_crack_main {

    public static void main(String[] args){
        
        //Mode to add a user to a text file
        if(args[0].equals("-a") || args[0].equals("--adduser")){
            try{
                String name = args[1];
                String pass = args[2];
            }
            catch(ArrayIndexOutOfBoundsException a){
                System.out.print("Usage: -a|--adduser [username] [password]");
                System.exit(0);
            }
            System.out.println(args[1]+" "+args[2]);

            File outputfile = new File("user_store.txt");
        }
    }
}