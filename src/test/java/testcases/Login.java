package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.LoginPage;

public class Login extends BaseClass {

	@Test
	public void Test1() {

		LoginPage Lp = new LoginPage(driver);

		Lp.Login("standard_user", "secret_sauce");
		WebElement Product = driver.findElement(By.xpath("//div[@class=\"header_secondary_container\"]/span"));
		Assert.assertEquals(Product.getText(), "PRODUCTS");

	}

	@Test
	public void Test2() {
		LoginPage Lp = new LoginPage(driver);

		Lp.Login("standard_user", "secret_sauce1");
		WebElement Error = driver.findElement(By.xpath("//h3[@data-test='error']"));
		String ActError = Error.getText();
		String ExpError = "Epic sadface: Username and password do not match any user in this service";

		AssertJUnit.assertTrue(Error.isDisplayed());
		AssertJUnit.assertEquals(ActError, ExpError);

	}
	@Test
	public void Test3() {
		LoginPage Lp = new LoginPage(driver);

		String UserName = sheet.getRow(2).getCell(0).getStringCellValue();
		String Password = sheet.getRow(2).getCell(1).getStringCellValue();
		String ExpectedError = sheet.getRow(2).getCell(2).getStringCellValue();
		

		System.out.println(ExpectedError);
		Lp.Login(UserName, Password);
		WebElement Error = driver.findElement(By.xpath("//h3[@data-test='error']"));

		String ActError = Error.getText();
		System.out.println(ActError);

		AssertJUnit.assertTrue(Error.isDisplayed());
		AssertJUnit.assertEquals(ActError, ExpectedError);
		
	}

	

}
