package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_page {

	public WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Accept all')]")
	WebElement accept_button;
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement sigin_button;
	
	@FindBy(id="login-username")
	WebElement username_textbox;
	
	@FindBy(id="login-passwd")
	WebElement password_textbox;
	
	@FindBy(id="login-signin")
	WebElement next_button_click;
	
	public Login_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void acceptbutton_click() {
		accept_button.click();
	}
	
	public void sigin_button_click() {
		sigin_button.click();
	}
	
	public void enterusername(String username) {
		username_textbox.click();
		username_textbox.sendKeys(username);
		
	}
	public void enterpassword(String password) {
		password_textbox.sendKeys(password);
		
	}
	public void nextbutton_click()
	{
	next_button_click.click();
	}
	
}
