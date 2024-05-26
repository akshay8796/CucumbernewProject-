package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ch.qos.logback.core.util.Duration;

public class loginpage 
{
WebDriver Ldriver;
public loginpage(WebDriver rdriver)  // constructor  classname
{
	Ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}


@FindBy(id = "Email") WebElement email;
@FindBy(id = "Password") WebElement password;
@FindBy(xpath = "//button[@class='button-1 login-button']") WebElement login;
@FindBy(xpath = "//a[text()='Logout']") WebElement logout;
public void enterEmail(String emailAdd)
{        email.clear();
       email.sendKeys(emailAdd);
}

public void enterPassword(String pwd)
{        password.clear();
       password.sendKeys(pwd);
}

public void clickonlogin()
{
     login.click();
}

public void clicOnLogoutButton()
{
	WebDriverWait wait=new WebDriverWait(Ldriver , java.time.Duration.ofSeconds(10));
WebElement	k=wait.until(ExpectedConditions.elementToBeClickable(logout));
       k.click();		
//logout.click();	
	
	
	
	
	}

}