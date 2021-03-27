package uibank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homepage 

{
	
	 WebDriver driver;

	 	
	 By Applybtn = By.id("applyButton");
	 
	 
	public void clickapply()
	
	{

		driver.findElement(Applybtn).click();
	
	}

	public homepage(WebDriver driver)
    {
        this.driver=driver;
             
}
	
	
}
