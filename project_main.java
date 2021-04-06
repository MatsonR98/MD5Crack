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
            for(int i=0; i<args.length;i++){
                if(args[i].equals("-a")){
                    System.out.println("Todo: Add user");
                    System.exit(0);
                }
                else if(args[i].equals("-l")){
                    System.out.println("Todo: Login");
                    System.exit(0);
                }
                else if(args[i].equals("-p")){
                    System.out.println("Todo: Password Complexity");
                    System.exit(0);
                }
                else if(args[i].equals("-c")){
                    System.out.println("Todo: Password cracker");
                    System.exit(0);
                }
            }
            System.out.println("Arguments could not be parsed. Exiting...");
        }
    }
}
