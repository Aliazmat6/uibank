package uibank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;




public class applyloanpage {


	
	WebDriver driver;

	 By email = By.id("email");
	 By amount =By.id("amount");
	 By term = By.id("term");
	 By income = By.id("income");
	 By age = By.id("age");
	
	By submit = By.id("submitButton");
	
	public void enteremail(String emailID)
	{
		
		driver.findElement(email).sendKeys(emailID);
		
	}
	
	public void enteramount(String amts)
	{
		
		driver.findElement(amount).sendKeys(amts);
		
	}

	public void enterterm(String trm)
	{
		
		
		Select drpterm = new Select(driver.findElement(term));
		drpterm.selectByVisibleText(trm);
		
	}
	
	public void enterincome(String incm) {
		
		driver.findElement(income).sendKeys(incm);
		
	}
	
	
	public void enterage(String ag)
	{
		
		driver.findElement(age).sendKeys(ag);
	}
	

	public void submit()
	{
		
		driver.findElement(submit).click();
		
	}
	
	public applyloanpage(WebDriver driver)
    {
		this.driver=driver;
             
     }
	
	
	
}
