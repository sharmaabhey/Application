package Main_test;

import java.util.Map;

import org.testng.annotations.Test;

import Classes.Iengage_class;
import Classes.Iengage_dashboard;
import Datautils.Data_Supplier;

public class Test_dataprovider extends Base_test_class{
	
	
	
	@Test(dataProvider= "iengage" , dataProviderClass= Data_Supplier.class)
	
	public void iengage_actions(Map iobj) throws Exception {
		test = report.createTest((String) iobj.get("Test_CaseName"));
		
		Iengage_class portal = new Iengage_class(driver,test);
		portal.click_on_loginusinemployeeid();
		portal.Login_id((String) iobj.get("Username"));
		portal.Password((String) iobj.get("password"));
		portal.click_on_signin();
		
		
		Iengage_dashboard dashboard = new Iengage_dashboard(driver,test);
		dashboard.close_popup();
		dashboard.click_on_attendance();
		dashboard.initial_date((String) iobj.get("Date"));
		//dashboard.get_day_of_the_date();
		
		
	}
	
	

	
	
	
	
	
	
	

}
