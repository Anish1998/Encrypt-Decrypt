import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
 
public class Decrypt
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name for the cipher text with it's extension: ");
        System.out.flush();
        String myfile = scanner.nextLine();
        File file = new File(myfile); 
        System.out.print("Enter a file name for the key used with it's extension: ");
        String key = scanner.nextLine();
        File file1 = new File(key);

        
        System.out.println( readAllBytesJava7( myfile,key) );
        
    }
    private static String readAllBytesJava7(String myfile,String key)//Decryption operations are performed here
    {
        String message = "";
        String keygen="";
 
        try
        {
            message = new String ( Files.readAllBytes( Paths.get(myfile) ) );// Reading the cipher from the file
            keygen=new String ( Files.readAllBytes( Paths.get(key) ) ); //Reading key from the file
        }
        catch (IOException b)
        {
            b.printStackTrace();
        }
        int l= message.length();
        int i,j;
        
        String s="";
        String result="";
        
        
        if(keygen.length()!=l) //Checking whether the number of bits in cipher and key are equal
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
                f1=message.charAt(i);
                s1=keygen.charAt(i);
                a=Character.getNumericValue(f1); //Cipher text converted into an integer
                b=Character.getNumericValue(s1); // key text converted into an integer
                c=a^b;
                c1=String.valueOf(c);
                result=result+c1;
            }
            
        }
        String s2 = "";   
        char nextChar;
        int sav;
        //The below logic is used to convert the bits into a plaintext
        for (i = 0; i < result.length()/8; i++) {

        int a = Integer.parseInt(result.substring(8*i,(i+1)*8),2);
        s2 += (char)(a);
            
    }   
    System.out.println(s2);
    try {
			File file = new File("../data/GenText.txt"); //The plaintext generated is stored inside a new text file
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(s2);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
         
        return " ";
    }
}
