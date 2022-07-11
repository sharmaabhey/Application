package Classes;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Datautils.Report_utility;

public class Iengage_class {
	
	
	WebDriver driver;
	ExtentTest reporter;
	
	@FindBy(id = "btnLogin")
	WebElement loginbtn;
	
	
	
	//By click_on_loginemployeeid = By.xpath("//input[@id='btnLogin']");
	
	@FindBy(xpath="//label[contains(text(),'Login Id')]//following-sibling::input[@class='form-control']")
	WebElement click_on_logincolumn;
	
//	By click_on_logincolumn = By.xpath("//label[contains(text(),'Login Id')]//following-sibling::input[@class='form-control']");
	
	@FindBy(xpath="//label[contains(text(),'Password')]//following-sibling::input[@class='form-control']")
	WebElement click_on_password_column;
	
//	By cick_on_password_column = By.xpath("//label[contains(text(),'Password')]//following-sibling::input[@class='form-control']");
	
	@FindBy(xpath="//input[@value='Sign In']")
	WebElement click_signin;
	
	//By click_signin = By.xpath("//input[@value='Sign In']");
	
	
	public Iengage_class(WebDriver driver, ExtentTest reporter) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
		this.reporter = reporter;
		}
	
	



	public void click_on_loginusinemployeeid() {
		loginbtn.click();
		reporter.pass("Clicking on login using employeeeid");
		
	}
		
	public void Login_id(String Loginid) throws Exception {
		
		click_on_logincolumn.click();
		click_on_logincolumn.sendKeys(Loginid);
		Thread.sleep(2000);
		reporter.pass("Entered login id is:" + Loginid);
		
		
	}
	public void Password(String pwd) throws Exception {
		
		click_on_password_column.click();
		click_on_password_column.sendKeys(pwd);
		reporter.pass("Entered loin password is:" + "**********");
		reporter.pass("Reviewing screenshot of checking login id is correct or not:",MediaEntityBuilder.createScreenCaptureFromPath(Report_utility.captureSS(driver)).build());
	}
	
	public void click_on_signin() {
		click_signin.click();
		reporter.pass("Clicking on sign in button");
	}
	
		
	}

