package Classes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Datautils.Report_utility;

public class Iengage_dashboard {
	
	
	WebDriver driver;
	ExtentTest reporter;
	@FindBy(xpath="(//button[text()='Close'])[1]")
	WebElement close_popup;
	//By close_popup =By.xpath("(//button[text()='Close'])[1]");
	
	@FindBy(xpath="//a[@id='Attendance']")
	WebElement  attendance_path;
	//By attendance_path = By.xpath("//a[@id='Attendance']");
	
	@FindBy(xpath="(//table[@title='Please click on date for mark/unmark your attendance']//following-sibling::td)[1]")
	WebElement Month;
	//By Month = By.xpath("(//table[@title='Please click on date for mark/unmark your attendance']//following-sibling::td)[1]");
	
	@FindBy(xpath="//a[text()='<< Previous ']")
	WebElement previousbtn;
	//By previousbtn = By.xpath("//a[text()='<< Previous ']");
	//By status_of_chooseddate=  By.xpath("//table[@title='Please click on date for mark/unmark your attendance']//child::a[text()='"+day+"']//following::td[2]");
	//By selecting_date =By.xpath("(//table[@title='Please click on date for mark/unmark your attendance']//child::a[text()='"+day+"']");
	@FindBy(xpath="//table[@id='ctl00_ContentPlaceHolder1_calAttendance']/tbody/tr")
	List<WebElement> row;
	
//	@FindBys(xpath="((//table[@id='ctl00_ContentPlaceHolder1_calAttendance']/tbody/tr)["+i+"]//child::span)")
//	List<WebElement> row_list;
	
	
	public Iengage_dashboard(WebDriver driver,ExtentTest reporter) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.reporter = reporter;
	}
	
	public void close_popup() throws Exception {
		close_popup.click();
		reporter.pass("the popup is:",MediaEntityBuilder.createScreenCaptureFromPath(Report_utility.captureSS(driver)).build());
		reporter.pass("closing the arise popup");
	}
	public void click_on_attendance() throws Exception {
		attendance_path.click();
		String oldwin = driver.getWindowHandle();
		for(String currwin: driver.getWindowHandles()) {
			if(oldwin != currwin) {
				driver.switchTo().window(currwin);
				Thread.sleep(2000);
			}
		}reporter.pass("Click on attendance tab:");
	}	
	public void initial_date(String date) throws Exception {
		String month = Month.getText();
		System.out.println(month);
		String date_of_first_table = date;
		System.out.println(date_of_first_table);
		String[] Splitter = date_of_first_table.split(",");
		String day = Splitter[0];
		String yearandmonth = Splitter[1];
		while(!month.equals(yearandmonth)) {
			Thread.sleep(2000);
			previousbtn.click();
			month = Month.getText();
			System.out.println(month);
			Thread.sleep(2000);
		}
//		String userdefined_date = "//table[@title='Please click on date for mark/unmark your attendance']//child::a[text()='"+day+"']";
//		String ele = driver.findElement(By.xpath(userdefined_date)).getText();
//		System.out.println(ele);
//		if(ele.equals("14")) {
			//String str = "//table[@title='Please click on date for mark/unmark your attendance']//child::a[text()='"+day+"']//following::td[2]";
			String store =driver.findElement(By.xpath("//table[@title='Please click on date for mark/unmark your attendance']//child::a[text()='"+day+"']//following::td[2]")).getText();
			System.out.println(store);
			reporter.pass("the status of the current date" + day + "is:" + store);
//		}else {
//			System.out.println("sorry");
//		}
			
			int count = 1;
			//List<WebElement> row = driver.findElements(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_calAttendance']/tbody/tr"));
			for (int i=3; i<row.size(); i++) {
				List<WebElement> row_list = driver.findElements(By.xpath("((//table[@id='ctl00_ContentPlaceHolder1_calAttendance']/tbody/tr)["+i+"]//child::span)"));
//				for(WebElement ele : row_list) {
//					String date_celltext = ele.getText();
//					System.out.println(date_celltext);
//					if(date_celltext.length()>2) {
						
						for(int time_text=0; time_text< row_list.size();time_text++) {	
								
							String date_celltext = row_list.get(time_text).getText();
							System.out.println(date_celltext);
							reporter.pass("time for the date" + date_celltext);
							if(date_celltext.length()>2 || date_celltext.equals(day)) {
						
					List<WebElement> date_text= driver.findElements(By.xpath("((//table[@id='ctl00_ContentPlaceHolder1_calAttendance']/tbody/tr)["+i+"]//child::a)["+count+"]"));
					for(int j =0; j<date_text.size();j++) {
							String date_index = date_text.get(j).getText();
							System.out.println(date_index);
							reporter.pass("date index is:" + date_index);
							
							
							
							
						
//						//System.out.println(date_text);
//						for(WebElement str : date_text) {
//							
//							String stri = str.getText();
//							System.out.println(stri);
							if(date_index.equals(day) || date_celltext.equals(day) ) {


					
						
						List<WebElement> daylist = driver.findElements(By.xpath("(//table[@id='ctl00_ContentPlaceHolder1_calAttendance']/tbody/tr)[2]/th"));
						String dayvalue = daylist.get(time_text).getText();					
						System.out.println(dayvalue);
						reporter.pass("the day of the" + day + "is:" + dayvalue );
						
						

							
							
						 
						
					return;	
					}
					
					
					}
					count++;
					
				}
				
			}
			count=1;

			
			
			
				


	
	

}

			
			

	
	
	
	
	
	
	
	
	}
}
	



