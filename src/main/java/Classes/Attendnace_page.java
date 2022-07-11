package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Attendnace_page {
	WebDriver driver;
	By Month = By.xpath("//td[text()='June 2022']");
	By previousbtn = By.xpath("//a[text()='<< Previous ']");
	
	public Attendnace_page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void initial_date(String date) {
		String month = driver.findElement(Month).getText();
		String date_of_first_table = date;
		String[] Splitter = date_of_first_table.split(",");
		String day = Splitter[0];
		String yearandmonth = Splitter[1];
		while(!month.equals(yearandmonth)) {
			driver.findElement(previousbtn).click();
			month = driver.findElement(Month).getText();
		}
		
		
	}
	
	
	

}
