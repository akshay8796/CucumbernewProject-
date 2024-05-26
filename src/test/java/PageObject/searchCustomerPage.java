package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchCustomerPage
{
WebDriver ldriver; 
	
public searchCustomerPage(WebDriver driver)
    {
		// TODO Auto-generated constructor stub
	 ldriver=driver;
	 PageFactory.initElements(driver, this);
	 
	}

@FindBy(xpath = "//input[@id='SearchEmail']") WebElement searchemailAdd;
@FindBy(xpath = "//button[@id='search-customers']") WebElement btnsearch;
@FindBy(xpath = "//table[@id='customers-grid']") WebElement searchResult;
@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr") List<WebElement> tablerows;
@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr[1]//td") List<WebElement> tableCol;

@FindBy(xpath = "//input[@id='SearchFirstName']") WebElement FirstName;
@FindBy(xpath = "//input[@id='SearchLastName']") WebElement LastName;


public void enterEmail(String email)
{
      searchemailAdd.sendKeys(email);
}

public void clickOnsearchbtn()
{
	btnsearch.click();
}
public boolean searchcustomerByEmail(String email)
{
	boolean found=false;
	//total numbers of rows in a grid
	int Ttrows=tablerows.size();
	
	// total number of column in a grid
     int TtCol=tableCol.size();
     
     for(int i=1;i<=Ttrows;i++)
     {
    	 WebElement webelementEmail=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+i+"]//td[2]"));
          String ActualEmailAdd=webelementEmail.getText();
          if(ActualEmailAdd.equals(email))
          {
        	  found=true;
          }

     }
return found;
}


////////////////search customer by name/////////////////

public void searchFirstName(String name)
{
      FirstName.sendKeys(name);
}


public void searchLastName(String Last)
{
      LastName.sendKeys(Last);
}

public boolean searchByname(String name)
{ 
	boolean found=false;
	int ttrows=tablerows.size();
           
	for(int i=1;i<=ttrows;i++)
	{
		 WebElement WebElementName = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+i+"]//td[3]"));	
	      String actualName= WebElementName.getText();
	
	      if(actualName.equals(name))
	      {
	    	found=true;  
	    	break;
	      }
	}
	return found;
}




}
