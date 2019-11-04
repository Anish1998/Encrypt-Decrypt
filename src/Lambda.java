import java.io.*;
import java.util.*;
public class Lambda
{
public static void main(String args[])
{
Lambda e=new Lambda();
String erri=args[0];//command line argument
e.lawda(erri);
}
public String lawda(String erri)
    {
        String keygen="";
        Random ran=new Random();
        int num=Integer.parseInt(erri);
        int[] z=new int[num];
    //The below logic is used to generate a key with lambda bits
        for(int q=0;q<num;q++)
        {
            
            z[q]=ran.nextInt(2);
        }
        for(int q=0;q<num;q++)
        {
            
            keygen=keygen+z[q];
        }
        System.out.println(keygen);
        
    try {
			File file = new File("newkey.txt"); // The new key generated is stored in a new file
			FileWriter fileWriter = new FileWriter(file);
            
			fileWriter.write(keygen);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
        
		}
    return keygen;
    
    }
    
    
}


