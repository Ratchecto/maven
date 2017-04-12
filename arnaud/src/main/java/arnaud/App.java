package arnaud;

import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App 
{

	
    public static void main( String[] args )
    {
    	/*int result = max(4, 5);
        System.out.println(result);*/
    	
    	int monmax = 0, nb = 0;
    	obj var = new obj();
        try
        {
	        CSVReader reader = new CSVReader(new FileReader("data.csv"));
	        try
			{
	        	List<String[]> myEntries = reader.readAll();
	        	for (String[] item : myEntries) 
		        {
		    		for (String i : item) 
		    		{
		    			nb++;
		    			
		    			monmax = var.max(Integer.parseInt(i), monmax);
		    		}
				}
			}
			catch(IOException e)
			{
				System.out.println("Problème de lecture");
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Fichier non trouvé");
		}
		
		System.out.println("Nombre lu : " + nb);
		System.out.println("Maximum : " + monmax);
    }
   

}