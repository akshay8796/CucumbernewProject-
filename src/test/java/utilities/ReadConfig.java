package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig
{

	
	      Properties properties;
	      String path="Config.properties"; 
	      
	      
	      //Constructor
	      public ReadConfig() throws IOException
	      {
	    	  
	    	  properties =new Properties();
	    	  FileInputStream file=new FileInputStream(path);
	    	  properties.load(file);
	      }
	      
	      public String getBrowser()
	      {
	    	  String value=properties.getProperty("browser");
	    	  if(value!=null)
	    	  
	    		  {return value;}
	    	  else
	    	  {
	    		  throw new RuntimeException("URL not specified in cofig file.");
	    	  }
	    	  
	    	  
	      }
	      
	      
	
}
