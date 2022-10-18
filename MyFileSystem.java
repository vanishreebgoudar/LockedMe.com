package FileManagemnt.App;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class MyFileSystem
{

	public static void main(String[] args) throws IOException
	{
		int choiceMain;
		char choiceSub;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("********: Welcome to File Management Application :*********");
		System.out.println("_________ Developed By : Vanishree M B__________\n");
		System.out.println("Select Your Option");
		Mainmenu:
		    do {
			
		         System.out.println("\n1.Retrieving the file names in an ascending order"); 
		         System.out.println("2.To perform add or delete or search the file");
		         System.out.println("3.Exit from the Application");
	             choiceMain=sc.nextInt();
	            switch(choiceMain)
	            {
	             case 1:System.out.println("List of File names in current directory");
	                    String[] pathnames;
	                    File f = new File("D:/OfficeFiles");
	                    pathnames = f.list();
                        for (String pathname : pathnames) 
                       {
                           System.out.println("\t"+pathname);
	                   }
                       break;
	             case 2:System.out.println("\t 1.Add a file to the existing directory list");
	                    System.out.println("\t 2.Delete a user specified file from the existing directory list");
		                System.out.println("\t 3.Search a user specified file from the main directory");
		                System.out.println("\t 4.Back to Main menu");  
		                //System.out.println("\t 5.Exit ");
		                choiceSub=sc.next().charAt(0);
		                String fileName;	
		            	   switch(choiceSub)
			               {
			                    case 1: System.out.println("\tEnter the file Name to Create:");
			                             fileName=sc.next();                  
			                            File f1=new File(fileName);
	                                    if(f1.createNewFile()) System.out.println("File is created");
	                                    else System.out.println("File already exists");
	                                    System.out.println(f1.getAbsolutePath());
	                                    break;
		   
			                    case 2:System.out.println("\tEnter the file Name to delete :");
	                                   fileName=sc.next();
	                                   File f3= new File(fileName);            
			        	               if(f3.delete()) System.out.println(f3.getName() + " deleted");    
			        	               else  System.out.println("failed"); 
			        	               break; 
			                    case 3:System.out.println("\tEnter the file Name to Search:");
	                                   fileName=sc.next();
			                    	   break;
			                    case 4:continue Mainmenu;
			                   
			                                   
			        	    }
		                
		                
		            break;
		       
	      } 
		}while(choiceMain!=3);
		System.out.println("Thank you ");

	}
}
