package uibank;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class applyloan 
{
	

    @Test(priority = 0) 
	public static void apply() throws IOException
    
    {
    	
    
	  	System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
	   	WebDriver driver;
	 	driver= new ChromeDriver();
	    driver.manage().window().maximize();

	    driver.get("https://uibank.uipath.com/loans");
	    

    	 homepage hpage= new homepage(driver);		
    	 hpage.clickapply();

	  	 result re = new result(driver);
    	 applyloanpage apply = new applyloanpage(driver);
	  	 	  	 
	  	 File file =    new File("C:\\datasheet.xlsx");
	  	 FileInputStream inputStream = new FileInputStream(file);
	  	 XSSFWorkbook wb=new XSSFWorkbook(inputStream);
	  	 Sheet sheet=wb.getSheet("Sheet1");
	  	 int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	  	 
	  	     
for(int i=1;i<=rowCount;i++) 
	  	     {
	  	           
	  	       String emailid = sheet.getRow(i).getCell(0).getStringCellValue();

	  	       double  amt	= sheet.getRow(i).getCell(1).getNumericCellValue();
	  	       String amts = String.valueOf((int)amt);

	  	       double trm = sheet.getRow(i).getCell(2).getNumericCellValue();
	  	        String     trms = String.valueOf((int)trm);
	  	       
	  	       double incm = sheet.getRow(i).getCell(3).getNumericCellValue();
	  	       String incms = String.valueOf((int)incm);
	  	       
	  	       double age = sheet.getRow(i).getCell(4).getNumericCellValue();
	  	       String ag = String.valueOf((int)age);
	  	       
	  	       apply.enteremail(emailid);
	  	       apply.enteramount(amts);
	  	       apply.enterterm(trms);
	  	       apply.enterincome(incms);
	  	       apply.enterage(ag);  
	  	       apply.submit();
	  	      
		  	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;     
	  	       
	  	      String res =    re.getapr();
	  	  

	  	      inputStream.close();
	  	      FileOutputStream outputStream = new FileOutputStream("C:\\datasheet.xlsx");

	  	      Cell cell = sheet.getRow(i).createCell(5);
	  	      cell.setCellValue(res);
	          wb.write(outputStream);
	  	      outputStream.close();
	  	       
	  	      re.applyagain();
	  	   
	   }
	     
driver.close();
driver.quit();
wb.close();	  	 
	  
	}

}