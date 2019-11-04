import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
 

public class Encrypt_128
{
    
    
    public static void main(String[] args)
    {
        
        Encrypt_128 e=new Encrypt_128();
        
        
        Scanner scanner = new Scanner(System.in);
        
                
        System.out.print("Enter a file name for the message with it's extension: ");
        System.out.flush();
        String myfile = scanner.nextLine();
        File file = new File(myfile); 
        System.out.print("Enter a file name for the key used with it's extension: ");
        String key = scanner.nextLine();
        File file1 = new File(key);
        System.out.println( readAllBytesJava7( myfile,key) );
        
        
    }
    private static String readAllBytesJava7(String myfile,String key)
    {
        long start=System.currentTimeMillis(); //Timer starts here
        String message = "";
        String keygen="";
        

 
        try
        {
            message = new String ( Files.readAllBytes( Paths.get(myfile) ) );
            keygen=new String ( Files.readAllBytes( Paths.get(key) ) );
        }
        catch (IOException b)
        {
            b.printStackTrace();
        }
        int l= message.length();
        int i,j;
        
        String s="";
        String result="";
        
        for(i=0;i<l;i++)
        {
            s=s+"0";
            char ch=message.charAt(i);
            j=ch;
            s=s+Integer.toBinaryString(j);

        }
        
        
        if(keygen.length()!=s.length())
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
                a=Character.getNumericValue(f1);
                b=Character.getNumericValue(s1);
                c=a^b;
                c1=String.valueOf(c);
                result=result+c1;
            }
        System.out.println(result);
            
        }
        long elapsed = System.currentTimeMillis();//Time ends here
        long duration=elapsed-start;// duration=end-start
        
        float average =((float)duration)/((float)l); //average=duration/iterations
        System.out.println(average);//The average time calculated is printed

    try {
			File file = new File("../data/cipher_128.txt");//storing it into a new file
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(result);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
                 
        return " ";
    }
    
    
}
