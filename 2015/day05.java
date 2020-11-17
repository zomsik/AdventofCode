
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    
    public static void part1(){
    int nicestringcount=0;
    String readdata;
try {
      File file = new File("data.txt");
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        int vowel=0;
        readdata = myReader.nextLine();

        boolean hasbadletters =false;
        boolean twiceinrow=false;
        for (int i=0; i<readdata.length();i++)
        {
            if(readdata.charAt(i)=='a' || readdata.charAt(i)=='e' || readdata.charAt(i)=='o' || readdata.charAt(i)=='u' || readdata.charAt(i)=='i')
                vowel++;     
        }
        for (int i=0; i<readdata.length()-1;i++)
        {
            if (readdata.charAt(i)==readdata.charAt(i+1))
                twiceinrow=true;    
            
        }
        
        if(readdata.contains("ab") || readdata.contains("cd") || readdata.contains("pq") || readdata.contains("xy"))
            hasbadletters=true;
        
        
        if (vowel>2 && !hasbadletters && twiceinrow)
        {   
            nicestringcount++;
        }
        
      }
      myReader.close();
      System.out.println("Nice strings: "+ nicestringcount);
    } catch (FileNotFoundException e) {
      System.out.println("Couldn't open the file");
      e.printStackTrace();
    }
      
            

        
    }
    
    
public static void part2(){
    int nicestringcount=0;
    String readdata;
    try {
      File file = new File("data.txt");
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        readdata = myReader.nextLine();

        boolean pairtwotimes =false;
        boolean twoandonebetweenw=false;
        for (int i=0; i<readdata.length()-3;i++)
        {
            for (int j=i;j<readdata.length()-3;j++)
                if((readdata.charAt(i)==readdata.charAt(j+2)) && (readdata.charAt(i+1)==readdata.charAt(j+3)))
                    pairtwotimes=true;
            
        }
        
        for (int i=0; i<readdata.length()-2;i++)
        {
            if (readdata.charAt(i)==readdata.charAt(i+2))
                twoandonebetweenw=true;    
            
        }

        if (twoandonebetweenw && pairtwotimes)
        {   
            nicestringcount++;
        }
        
      }
      myReader.close();
      System.out.println("Nice strings part 2 : "+ nicestringcount);
    } catch (FileNotFoundException e) {
      System.out.println("Couldn't open the file");
      e.printStackTrace();
    }
      
            

        
    }
    
    
    
    
    
    public static void main(String[] args){
        
        Main.part1();
        Main.part2();
        
       
        
        
    }
}
