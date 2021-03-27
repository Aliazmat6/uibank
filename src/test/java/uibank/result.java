package uibank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class result {

				WebDriver driver;
				By APR = By.id("rate");
				By appagain = By.id("applyForNewLoanButton");	



public String getapr() 

{
	
	WebElement r = driver.findElement(APR);
	String finalres = 	r.getText();

	return finalres;

 
}

public void applyagain()

{
	
	driver.findElement(appagain).click();	
}


public result(WebDriver driver)
{

    this.driver=driver;
         
 }



}
