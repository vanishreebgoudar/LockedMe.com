package FileManagemnt.App;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 class MultipleFunc
{
	
	 void  toPrintFileList() throws IOException
	 {
		
		
		 List<Path> x = Files.list(Paths.get(""))
		            .filter(p -> Files.exists(p))
		            .map(s -> s.getFileName())
		            .sorted()
		            .collect(Collectors.toList());

		x.forEach(System.out::println);
	
		 
	 }
	 public int  findFile(String name,File file)
	    {
	        File[] list = file.listFiles();
	        int flag=0;
	        if(list!=null)
	          for (File fil : list)
	          {
	            if (fil.isDirectory())
	            
	                findFile(name,fil);
	            
	            else if (name.equalsIgnoreCase(fil.getName()))
	            {
	            	flag=1;
	            System.out.println("Found");                
	            System.out.println("File found at : "+fil.getParentFile());
                System.out.println("Path diectory: "+fil.getAbsolutePath());
	            }
	            }
	        return flag;
}
}
public class MyFileSystem
{

	public static void main(String[] args) throws IOException
	{
		int choiceMain=0,choiceSub=0;
		MultipleFunc m=new MultipleFunc();
		Scanner sc=new Scanner(System.in);
		String fileName;	
        File f;
		
		System.out.println("********: Welcome to File Management Application :*********");
		System.out.println("_________ Developed By : Vanishree M Biradargoudar__________\n");
		System.out.println("Select Your Option");
		Mainmenu:
		    do {
			
		         System.out.println("\n1.Retrieving the file names in an ascending order"); 
		         System.out.println("2.To  add or delete or search  the file");
		         System.out.println("3.Exit from the Application");
		         
	             choiceMain=sc.nextInt();
		        
		        
	                
	            switch(choiceMain)
	            {
	             case 1:System.out.println("List of File names of current directory in ascending order ");
	                   m.toPrintFileList();
					
					break;
	             case 2:System.out.println("\t 1.To Add a file to the existing directory ");
	                    System.out.println("\t 2.To Delete a file from the existing directory");
		                System.out.println("\t 3.To Search a file from the main directory");
		                System.out.println("\t 4.Back to Main menu");  
		                //System.out.println("\t 5.Exit ");
		               
		                choiceSub=sc.nextInt();
		               
		                 switch(choiceSub)
			               {
			                    case 1: System.out.println("\tEnter the file name to create in current directory:");
			                             fileName=sc.next();                  
			                             f =new File(fileName);
	                                     if(f.createNewFile()) System.out.println("File is created");
	                                     else System.out.println("File already exists");
	                                     System.out.println(f.getAbsolutePath());
			                           
			                           break;
		   
			                    case 2:System.out.println("\tEnter the file name to delete in current directory:");
	                                   fileName=sc.next();
	                                    f= new File(fileName);            
			        	               if(f.delete()) System.out.println(f.getName() + " deleted");    
			        	               else  System.out.println("File Not found"); 
			        	               break; 
			                    case 3:System.out.println("\tEnter the file name to search from main directory:");
	                                   fileName=sc.next();
	                                   String userDirectory = Paths.get("")
	                                	        .toAbsolutePath()
	                                	        .toString();
	                                   Path path = Paths.get(userDirectory); 
	                                   Path root = path.getRoot(); 
	                                   String str=root.toString();
	                                    
	                        		   
	                                  int res= m.findFile(fileName,new File(str));
	                                  if(res==0)System.out.println("File Not found in current directory ");
	                                 
	                                   break;
			                    case 4:continue Mainmenu;
			                   
			                                   
			        	    }
		                
		                
		            break;
		       
	      } 
		}while(choiceMain!=3);
		System.out.println("********Thank you for using the File Mangement System Application*********");

	}
}
