package FileManagemnt.App;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class MyFileSystem
{

	public static void main(String[] args) throws IOException
	{
		int choiceMain,choiceSub;
		
		Scanner sc=new Scanner(System.in);
		String fileName;	
        File f;
		
		System.out.println("********: Welcome to File Management Application :*********");
		System.out.println("_________ Developed By : Vanishree M Biradargoudar__________\n");
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
	                     f = new File("C:/Users/Lenovo/eclipse-workspace/AssignmentProj1");
	                    pathnames = f.list();
                        for (String pathname : pathnames) 
                       {
                           System.out.println("\t"+pathname);
	                   }
                       break;
	             case 2:System.out.println("\t 1.To Add a file to the existing directory list");
	                    System.out.println("\t 2.To Delete a file from the existing directory list");
		                System.out.println("\t 3.To Search a file from the main directory");
		                System.out.println("\t 4.Back to Main menu");  
		                //System.out.println("\t 5.Exit ");
		                choiceSub=sc.nextInt();
		                
		            	   switch(choiceSub)
			               {
			                    case 1: System.out.println("\tEnter the file name to create:");
			                             fileName=sc.next();                  
			                             f =new File(fileName);
	                                     if(f.createNewFile()) System.out.println("File is created");
	                                     else System.out.println("File already exists");
	                                     System.out.println(f.getAbsolutePath());
	                             break;
		   
			                    case 2:System.out.println("\tEnter the file name to delete :");
	                                   fileName=sc.next();
	                                    f= new File(fileName);            
			        	               if(f.delete()) System.out.println(f.getName() + " deleted");    
			        	               else  System.out.println("failed"); 
			        	               break; 
			                    case 3:System.out.println("\tEnter the file name to Search:");
	                                   fileName=sc.next();
	                                    f = new File(fileName);
	                                   if (f.exists())System.out.println("Exists");
	                                   else System.out.println("Does not Exists");
	                                   break;
			                    case 4:continue Mainmenu;
			                   
			                                   
			        	    }
		                
		                
		            break;
		       
	      } 
		}while(choiceMain!=3);
		System.out.println("********Thank you for using the File Mangement System Application*********");

	}
}
