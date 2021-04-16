import java.io.*;
import java.util.*;

public class project_main {
    public static void main(String[] args){
        System.out.println("\n--------------------------------------\nINFSCI 1620 Project by Ryan Matson\n--------------------------------------\n");
        if(args.length == 0){
            System.out.println("Account options:\n\tAdd user and password: \"-a [user] [password]\"\n\tLogin as user: \"-l [user] [password]\"\n");
            System.out.println("Crack password for specific account: \"-c [user]\"");
            System.out.println("Check password complexity: \"-p [password]\"\n");
        }
        else{
            if(args[0].equals("-a")){
                try{
                    String user = args[1];
                    String pass = args[2];
                    boolean status = user_add.user_add(user, pass);
                    if(status){
                        System.out.println("\nSuccess!");
                    }
                    else{
                        System.out.println("\nTask failed.");
                    }
                }
                catch(IndexOutOfBoundsException invalidIndex){
                    System.out.println("Input does not match required arguments. Usage: Add user and password: \"-a [user] [password]\"");
                }
                System.exit(0);
            }
            else if(args[0].equals("-l")){
                try{
                    String user = args[1];
                    String pass = args[2];
                    boolean status = user_login.user_login(user, pass);
                    if(status){
                        System.out.println("\nLogin Succeeded as "+user+".");
                    }
                    else{
                        System.out.println("\nLogin failed.");
                    }
                }
                catch(IndexOutOfBoundsException invalidIndex){
                    System.out.println("Input does not match required arguments. Usage: Login as user: \"-l [user] [password]\"");
                }
                System.exit(0);
            }

            else if(args[0].equals("-p")){
                try{
                    String pass = args[1];
                    String type = password_evaluator.password_evaluator(pass);
                    System.out.println("This password is a "+type+".");
                }
                catch(IndexOutOfBoundsException invalidIndex){
                    System.out.println("Input does not match required arguments. Usage: Check password complexity: \"-p [password]\"");
                }
                catch(FileNotFoundException f){
                    System.out.println("\"dictionary.txt\" not found.");
                }
                catch(IOException io){
                    System.out.println("An IO exception occurred.");
                }
                System.exit(0);
            }

            else if(args[0].equals("-c")){
                try{
                    String user = args[1];
                    String password = password_cracker.password_cracker(user);
                    if(password != null){
                        System.out.println("Password for user "+user+" is \""+password+"\".");
                    }
                    else{
                        System.out.println("Password not found.");
                    }
                    
                }
                catch(IndexOutOfBoundsException invalidIndex){
                    System.out.println("Input does not match required arguments. Usage: Crack password for specific user: \"-c [user]\"");
                }
                System.exit(0);
            }
            System.out.println("Arguments could not be parsed. Exiting...");
        }
    }
}
