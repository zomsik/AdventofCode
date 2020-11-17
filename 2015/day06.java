
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;


public class Main {
    
    
    public static int[][] turn(int X0,int Y0,int X1,int Y1,int[][] grid,int value){
    for (int i = X0; i<=X1;i++)
        for (int j = Y0; j<=Y1;j++)
            grid[i][j]=value;
        
        return grid;
    }
    
    public static int[][] toggle(int X0,int Y0,int X1,int Y1,int[][] grid){
    for (int i = X0; i<=X1;i++)
        for (int j = Y0; j<=Y1;j++)
            grid[i][j]=-grid[i][j];
        
        return grid;
    }

    
    public static int countlit(int [][]grid){
        int count = 0;
    for (int i = 0; i<1000;i++)
        for (int j = 0; j<1000;j++)
            if(grid[i][j]==1)
                count++;
        
        return count;
    }
    
    public static int[][] add(int X0,int Y0,int X1,int Y1,int[][] grid,int value){
    for (int i = X0; i<=X1;i++)
        for (int j = Y0; j<=Y1;j++)
             if (grid[i][j]+value>=0)   
                grid[i][j]=grid[i][j] + value;
           
        
        return grid;
    } 
    
        public static int brightness(int [][]grid){
        int countbrightness = 0;
    for (int i = 0; i<1000;i++)
        for (int j = 0; j<1000;j++)
            countbrightness+=grid[i][j];
           
        return countbrightness;
    }
        
        
        
    public static void part1(){
    int litlights=0;
    String readdata;
    
    int [][] grid = new int [1000][1000];
    
    for (int i =0;i<1000;i++)
        for (int j=0; j<1000;j++)
            grid[i][j]=-1;
    
try {
      File file = new File("data.txt");
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        readdata = myReader.nextLine();
        String[] dataparts = readdata.split(" ");
        
        if("turn".equals(dataparts[0]))
        {
            String[] cordsStart = dataparts[2].split(",");
            String[] cordsEnd = dataparts[4].split(",");
            
            if ("on".equals(dataparts[1])){
                grid = turn(parseInt(cordsStart[0]),parseInt(cordsStart[1]),parseInt(cordsEnd[0]),parseInt(cordsEnd[1]),grid,1);
                  
            }else if ("off".equals(dataparts[1])){
                grid = turn(parseInt(cordsStart[0]),parseInt(cordsStart[1]),parseInt(cordsEnd[0]),parseInt(cordsEnd[1]),grid,-1);
            }
        }else if("toggle".equals(dataparts[0]))
        {
            String[] cordsStart = dataparts[1].split(",");
            String[] cordsEnd = dataparts[3].split(",");
            grid = toggle(parseInt(cordsStart[0]),parseInt(cordsStart[1]),parseInt(cordsEnd[0]),parseInt(cordsEnd[1]),grid);
        }
        
        
        
        
        
        
        
      }
      litlights=countlit(grid);
      System.out.println("Lights: "+litlights);
      
          for (int i =0;i<1000;i++)
        for (int j=0; j<1000;j++)
      
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Couldn't open the file");
      e.printStackTrace();
    }
      
            

        
    }
    
    
public static void part2(){
    int brightness;
    String readdata;
    
    int [][] grid2 = new int [1000][1000];
    
    for (int i =0;i<1000;i++)
        for (int j=0; j<1000;j++)
            grid2[i][j]=0;
    
try {
      File file = new File("data.txt");
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        readdata = myReader.nextLine();
        String[] dataparts = readdata.split(" ");
        
        if("turn".equals(dataparts[0]))
        {
            String[] cordsStart = dataparts[2].split(",");
            String[] cordsEnd = dataparts[4].split(",");
            
            if ("on".equals(dataparts[1])){
                grid2 = add(parseInt(cordsStart[0]),parseInt(cordsStart[1]),parseInt(cordsEnd[0]),parseInt(cordsEnd[1]),grid2,1);
                  
            }else if ("off".equals(dataparts[1])){
                grid2 = add(parseInt(cordsStart[0]),parseInt(cordsStart[1]),parseInt(cordsEnd[0]),parseInt(cordsEnd[1]),grid2,-1);
            }
        }else if("toggle".equals(dataparts[0]))
        {
            String[] cordsStart = dataparts[1].split(",");
            String[] cordsEnd = dataparts[3].split(",");
            grid2 = add(parseInt(cordsStart[0]),parseInt(cordsStart[1]),parseInt(cordsEnd[0]),parseInt(cordsEnd[1]),grid2,2);
        }
        
        
        
        
        
        
        
      }
      brightness=brightness(grid2);
      System.out.println("Brightness: "+brightness);
      
      myReader.close();
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
