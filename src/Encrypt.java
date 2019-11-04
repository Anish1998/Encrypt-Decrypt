import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
 

public class Encrypt
{
    
    
    public static void main(String[] args)
    {
        Encrypt e=new Encrypt();
        
        Scanner scanner = new Scanner(System.in);
        
                
        System.out.print("Enter a file name for the message with it's extension: ");
        System.out.flush();
        String myfile = scanner.nextLine();
        File file = new File(myfile);
        System.out.print("Enter a file name for the key used with it's extension: ");
        String key = scanner.nextLine();
        File file1 = new File(key);
        System.out.println( readAllBytesJava7( myfile,key) );//function call
        
    }
    private static String readAllBytesJava7(String myfile,String key)// Encryption operations are performed here
    {
        String message = "";
        String keygen="";
        

 
        try
        {
            message = new String ( Files.readAllBytes( Paths.get(myfile) ) );// Message is taken from the text file
            keygen=new String ( Files.readAllBytes( Paths.get(key) ) );// key is taken from the text file
        }
        catch (IOException b)
        {
            b.printStackTrace();
        }
        int l= message.length();
        int i,j;
        
        String s="";
        String result="";
       //The below logic converts the given message into binary 
        for(i=0;i<l;i++)
        {
            s=s+"0";
            char ch=message.charAt(i);
            j=ch;
            s=s+Integer.toBinaryString(j);

        }
        
        
        if(keygen.length()!=s.length()) //Checking the length of message and key
        {
            System.out.println("error: length is incorrect!");
        }
        else
        {
            char f1,s1;
            String c1;
            int a,b,c;
            for(i=0;i<32;i++)
            {
                f1=s.charAt(i);
                s1=keygen.charAt(i);
                a=Character.getNumericValue(f1);//here the message is stored in form of a number
                b=Character.getNumericValue(s1);//here the cipher is stored in form of a number
                c=a^b;// XOR operation between message and key
                c1=String.valueOf(c);// converting the cipher text into string
                result=result+c1;
            }
        System.out.println(result);
            
        }
    try {
            // Data is written into the file
			File file = new File("../data/cipher.txt");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(result);
			fileWriter.flush();
			fileWriter.close();// file is being closed
		} catch (IOException e) {
			e.printStackTrace();
		}
         
        return " ";
    }
    
    
}
