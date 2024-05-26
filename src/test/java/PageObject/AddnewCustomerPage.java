package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddnewCustomerPage 
{
	
	WebDriver ldriver;
	
public AddnewCustomerPage(WebDriver rdriver) 
{
	ldriver=rdriver;
	
PageFactory.initElements(ldriver, this);
 
}

@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]") WebElement lnkCustomer_menu;
@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),' Customers')]") WebElement Lnkcustomer_menuItem;
@FindBy(xpath = "//a[@class='btn btn-primary']") WebElement btnAddnew;
@FindBy(xpath = "//input[@id='Email']") WebElement txtEmail;
@FindBy(xpath = "//input[@id='Password']") WebElement txtPassword;
@FindBy(xpath = "//input[@id='FirstName']") WebElement FirstName;
@FindBy(xpath = "//input[@id='LastName']") WebElement Lastname;
@FindBy(xpath = "//input[@id='Gender_Male']") WebElement Malegender;
@FindBy(xpath = "//input[@id='Gender_Female']") WebElement FeMalegender;
@FindBy(xpath = "//input[@id='DateOfBirth']") WebElement txtBirthDate;
@FindBy(xpath = "//input[@id='Company']") WebElement txtcompanyName;
////////////////////////////////////////////////////////////////////////////////
@FindBy(xpath = "(//span[@class='select2-selection select2-selection--multiple'])[2]") WebElement txtCustomerRole;
@FindBy(xpath = "//li[contains(text(),'Administrators')]") WebElement listItemsAdministrator;
@FindBy(xpath = "//li[contains(text(),'Registered')]") WebElement listitemsRegistered;
@FindBy(xpath = "//li[contains(text(),'Guests')]") WebElement listitemsGuest;
@FindBy(xpath = "//li[contains(text(),'Vendors')]") WebElement listitemsvendor;
///////////////////////////////////////////////////////////////////////////////
@FindBy(xpath = "//select[@id='VendorId']") WebElement dropdownVendor ;
@FindBy(xpath = "//textarea[@id='AdminComment']") WebElement txtadminContent;
@FindBy(xpath = "(//button[@type='submit'])[2]") WebElement savetab;

//Actions Method for web elements

public String getPagetitles()
{
    return ldriver.getTitle();	
}
public void clickCustomerMenu()
{
	lnkCustomer_menu.click();
}
public void clickOnCustomerMenuItem()
{
	Lnkcustomer_menuItem.click();
    	
}
public void clickOnAdd()
{
	btnAddnew.click();
}

public void enterEmail(String email)
{
 txtEmail.sendKeys(email);	
}

public void enterPassword(String password)
{
	txtPassword.sendKeys(password);
	}

public void enterFirstName(String firstname)
{
	FirstName.sendKeys(firstname);
	}
public void lastname(String lastname) 
{
	Lastname.sendKeys(lastname);
}
public void  enterDOB(String dob)
{
	txtBirthDate.sendKeys(dob);
	}
public void EnterCompanyName(String CoName)
{
	txtcompanyName.sendKeys(CoName);
	}

public void enterAdminContent(String content)
{
     txtadminContent.sendKeys(content);	
}

public void enterMangerofvendor(String value)
{
	Select sel=new Select(dropdownVendor);
	sel.selectByValue(value);
}


public void enterGender(String gender)
{
   if(gender.equals("Male"))
   {
	   Malegender.click();
   }
   else if(gender.equals("Female"))
   {
	    FeMalegender.click();   
   }
}

public void clickOnSave()
{
	savetab.click();
	}
}
