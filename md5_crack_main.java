import java.io.*;
import java.util.*;

public class md5_crack_main {

    public static void main(String[] args){
        
        String name;
        String pass;

        //Mode to add a user to a text file
        if(args.length == 0){
            System.out.println("Usage: -c or --cracker [user] | -a or --adduser [username] [password] | -p or --passwordcheck [password]");
            System.exit(0);
        }

        else if(args[0].equals("-a") || args[0].equals("--adduser")){

            //Quit the program if the required fields are empty
            try{
                name = args[1];
                pass = args[2];
            }
            catch(ArrayIndexOutOfBoundsException a){
                System.out.print("Usage: -a or --adduser [username] [password]");
                System.exit(0);
            }
        }

        else if(args[0].equals("-c") || args[0].equals("--cracker")){
            
            //Quit the program if the required fields are empty
            try{
                name = args[1];
                pass = args[2];
            }
            catch(ArrayIndexOutOfBoundsException a){
                System.out.print("Usage: -c or --cracker [user]");
                System.exit(0);
            }
        }

        else if(args[0].equals("-p") || args[0].equals("--passwordcheck")){

            //Quit the program if the required fields are empty
            try{
                name = args[1];
                pass = args[2];
            } 
            catch(ArrayIndexOutOfBoundsException a){
                System.out.print("Usage: -p or --passwordcheck [password]");
                System.exit(0);
            }
        }
        
    }

    private static String md5(String word){
        String md5 = "";


        return md5;
    }
}