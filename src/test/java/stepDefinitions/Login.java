package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class Login {
	
	WebDriver driver=Driver_Class.setup();
	Properties prop=new Properties();
	FileInputStream File;
	String URL;
	Login_page loginpagedriver;

	@Given("URL of the application")
	public void url_of_the_application() throws FileNotFoundException {
		 try {
	    File=new FileInputStream("src/test/java/Utility/config.properties");
			prop.load(File);
			URL=prop.getProperty("application_URL");
			driver.get(URL);
			loginpagedriver=new Login_page(driver);
			loginpagedriver.acceptbutton_click();	
			loginpagedriver.sigin_button_click();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
   
	@When("From Credentials sheet enter {string}  and {string}.")
	@Test(dataProvider="LoginData")
	public void from_credentials_sheet_enter_and(String user, String pwd) {
		   
			loginpagedriver.enterusername(user);
			loginpagedriver.nextbutton_click();
			
		}
		
	@And("click on login")
	public void click_on_login() {
	   
	}

	@Then("user get navigate to homepage")
	public void user_get_navigate_to_homepage() {
	 
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{		
		//get the data from excel
		String path="src\\test\\resources\\datafiles\\Credentials.xlsx";
		XLUtility xlutil=new XLUtility(path);
		int totalrows=xlutil.getRowCount("Credentials");
		int totalcols=xlutil.getCellCount("Credentials",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Credentials", i, j);
			}
				
		}
		
		System.out.println(loginData);
		return loginData;
		
	}
	
}
