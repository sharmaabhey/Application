package Testcasewithconfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import Classes.Iengage_class;
import Main_test.Base_test_class;

public class Test_with_configfile  {
	//protected Properties prop = null;
	public Properties prop;
	
	
	@Test

	public void iengage() throws Exception  {
		
		
        prop = new Properties();
		
		
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") +"/configuration/config.properties");
			prop.load(fs);
			System.out.println("url:" + prop.getProperty("url"));
			System.out.println("username:" + prop.getProperty("Username"));
			System.out.println("password:" + prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
				
			
			
			
		}

		
		
	}


