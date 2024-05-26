package StepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.AddnewCustomerPage;
import PageObject.loginpage;
import PageObject.searchCustomerPage;
import ch.qos.logback.classic.Logger;
import utilities.ReadConfig;

/* parent class */
public class BaseClass {
	
 public static	WebDriver driver;
	public loginpage login;
	public AddnewCustomerPage addnewCustpg;
	public searchCustomerPage searcCustPage;
	public static org.apache.logging.log4j.Logger log;
	
	public ReadConfig readConf;
	
	// generate random unique Email id
      public String generateEmailId()
      {
    	 return RandomStringUtils.randomAlphabetic(5);
      }
}
