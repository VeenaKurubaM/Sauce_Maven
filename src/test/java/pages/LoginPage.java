package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//page class is useful to have all reusable code of that specific page
public class LoginPage {
	WebDriver driver;
	// *********************************Objects*****************************//
	@FindBy(id = "user-name")

	WebElement UserId;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(name = "login-button")
	WebElement Login;
	/*@FindBy(xpath = "//h3[@data-test='error']")
	public WebElement Error;
	public String ActError;*/

	// WebElement
	// Product=driver.findElement(By.xpath("//div[@class=\"header_secondary_container\"]/span"));

	public LoginPage(WebDriver baseDriver) {

		this.driver = baseDriver;
		PageFactory.initElements(baseDriver, this);

	}

	
	// *********************************Methods*****************************//

	public void Login(String Uname, String Pwd) {

		UserId.sendKeys(Uname);
		Password.sendKeys(Pwd);
		Login.click();
		//ActError = Error.getText();

	}
}
