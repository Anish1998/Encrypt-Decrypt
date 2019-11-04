import java.io.*;
import java.util.*;
public class rkandfreq
{
public static void main(String args[])
{
rkandfreq e=new rkandfreq();
e.frequency();
}
public String generation()
    {
        String keygen="";
        Random ran=new Random();
        
        int[] z=new int[3]; 
        //The below code is used to generate a random key of 3 bits
        for(int q=0;q<3;q++)
        {
            
            z[q]=ran.nextInt(2);
        }
        for(int q=0;q<3;q++)
        {
            
            keygen=keygen+z[q];
        }
        
    return keygen;
    
    }
    
public List<String> llawda() //A list function to store all the generated keys
{
    int i;
    
    List<String> list = new ArrayList<String>();
    
    for(i=0;i<5000;i++)
    {
        list.add(generation()); // function call to add all the values into it
        
    }
    return list;
    
    
}
public void frequency()
{
    List<String> laddu=llawda(); //function call to retrieve all the data from the list
    int zzz=0,zoz=0,zzo=0,ozz=0,ooo=0,ozo=0,ooz=0,zoo=0,i;
    // The below code is used to calculate the frequency of each of obtained bits
    for(i=0;i<laddu.size();i++)
    {
        
        if((laddu.get(i)).equals("000"))
        {
            
            zzz++;
        }
        else if((laddu.get(i)).equals("010"))
        {
            zoz++;
        }
        else if((laddu.get(i)).equals("001"))
        {
            zzo++;
        }
        else if((laddu.get(i)).equals("100"))
        {
            ozz++;
        }
        else if((laddu.get(i)).equals("111"))
        {
            ooo++;
        }
        else if((laddu.get(i)).equals("101"))
        {
            ozo++;
        }
        else if((laddu.get(i)).equals("110"))
        {
            ooz++;
        }   
        else if((laddu.get(i)).equals("011"))
        {
            zoo++;
        }
            
    }
    System.out.println(zzz+" "+zoz+" "+zzo+" "+ozz+" "+ooo+" "+ozo+" "+ooz+" "+zoo);
    
    
}

}

