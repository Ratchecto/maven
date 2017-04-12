package arnaud;

import java.io.FileReader;
import java.io.FileWriter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.apache.commons.collections.CollectionUtils;

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
    		CSVWriter writer;
			try {
				writer = new CSVWriter(new FileWriter("data-filtered.csv"));
		        try
				{
		        	List<String[]> myEntries = reader.readAll();
		        	for (String[] item : myEntries) 
			        {
		        		List<String> list = Arrays.asList(item);
		        		Vector<String> out = new Vector<String>();
		        		CollectionUtils.select(list, new MonPredicat<String>(), out);
		        		System.out.println("OUT :" + out);
			    		for (String i : out) 
			    		{
			    			nb++;
			    			
			    			monmax = var.max(Integer.parseInt(i), monmax);
			    		}
			    		String[] ret = out.toArray(new String[0]);
			    		writer.writeNext(ret);
					}
				}
				catch(IOException e)
				{
					System.out.println("Problème de lecture");
				}
	    		writer.close();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
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