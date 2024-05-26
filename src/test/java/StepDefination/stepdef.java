package StepDefination;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddnewCustomerPage;
import PageObject.loginpage;
import PageObject.searchCustomerPage;
import ch.qos.logback.core.util.FileUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import utilities.ReadConfig;

public class stepdef extends BaseClass {
	
 @Before() 	
 public void setup() throws IOException
 {  log =org.apache.logging.log4j.LogManager.getLogger("stepdef");
 
    readConf =new ReadConfig();
 
    String browser = readConf.getBrowser();
     switch (browser.toLowerCase()) {
	 case "chrome":
		WebDriverManager.chromedriver().setup();
		 driver =new ChromeDriver();
		break;
	 case "firefox":
		WebDriverManager.firefoxdriver().setup();
		 driver =new FirefoxDriver();
		break;
		default :
			driver=null;
			break;
	
	}
    
   
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    log.info("setup1 executed..");
 }
/////////////////////////////// hook condition/////////////////////////
 // @Before("@sanity") 	// conditional hook @Before("@sanity") <-- this setup will execute only for @sanity   
 // public void setup2()
 // { 
 //	 System.out.println("Setup method extecuted");
 //	 WebDriverManager.chromedriver().setup();
 //	   
 //	    driver =new ChromeDriver();
 //	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 // }
 
 // @Before("@regression") 	//conditional hook @before("@regression") <-- this setup will execute only for @regression   
 // public void setup2()
 // { 
 //	 System.out.println("Setup method extecuted");
 //	 WebDriverManager.chromedriver().setup();
 //	   
 //	    driver =new ChromeDriver();
 //	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 // }
/////////////////////////////////////// hook condition end/////////////
 
 
//////////////////////////// order ///////////////////////////// 

//@Before(order = 1)  // here lower order is execute first in @Before where in @After execute order with higher order 
//public void setup1()
//   { 
//System.out.println("Setup method extecuted");
//WebDriverManager.chromedriver().setup();
//
//driver =new ChromeDriver();
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//  }
 
 
 
 //                    	// we can use @Before many time and execute alphabetical order
//                      // we can use @before many time but can control their execution order
//                     // we can use @before(order=number)
// @Before(order = 2)  // here lower order is execute first in @Before where in @After execute order with higher order 
// public void setup2()
//  { 
//	 System.out.println("Setup method extecuted");
//	 WebDriverManager.chromedriver().setup();
//	   
//	    driver =new ChromeDriver();
//	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//  }
///////////////////////////// order end ////////////////////////////////////////	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
	   
	    login =new loginpage(driver);
	    addnewCustpg=new AddnewCustomerPage(driver);
	        searcCustPage=new searchCustomerPage(driver);
	        log.info(" browser launch chrome");
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
	    driver.get(url);
	    log.info(" url opened");
	}

	@When("user enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String Emailaddress, String Password) {
	   login.enterEmail(Emailaddress);
	   login.enterPassword(Password);
	   log.info(" email and password entered");
	}

	@When("Click on Login")
	public void click_on_login() {
	 login.clickonlogin();
	 log.info(" click on login button");
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedtitle) {
	  String actual=driver.getTitle();
	  if(actual.equals(expectedtitle))
	  {
		  log.warn("Test pasword  :login feature :page title  matched."); 
		  org.junit.Assert.assertTrue(true);
	  }
	  else
	  {
		 
		  org.junit.Assert.assertTrue(false);
		  log.info("Test Failed : login feature- page title not matched.");
	  }
	}

	@When("User Click on Log out link")
	public void user_click_on_log_out_link() {
	  login.clicOnLogoutButton();
	  log.info("Login feature page titles not matched");
	}
	
	@Then("Page Title should be as {string}")
	public void page_title_should_be_as(String exptitle) {
	  String actual=driver.getTitle();
	  System.out.println(actual); 
	  if(actual.equals(exptitle))
	  {
		  log.info("same page title : test passed");
		 org.junit.Assert.assertTrue(true);
	  }
	  else
	  {
		  org.junit.Assert.assertTrue(false);
		  log.warn("Not same page title : test Failed");
	  }
	}
	
	
	/*
	 * @Then("close browser")
	public void close_browser() {
	 driver.close();
	 log.info("Browser closed");
	// driver.quit();
	}
	
	*/
	
	/////////////////////////    add new  feature
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualtitles = addnewCustpg.getPagetitles();
		String expectedtitles="Dashboard / nopCommerce administration";
	     if(actualtitles.equals(expectedtitles))
	     {
	    	 log.info(" user can view Dashboard");
	    	org.junit.Assert.assertTrue(true);
	     }
	     else
	    	 
	     {  
	    	 log.warn("user can not view Dashboard");
	    	 org.junit.Assert.assertTrue(false);
	    	 
	     }
	}

	@When("User click on the customer Menu")
	public void user_click_on_the_customer_menu() {
		log.info("user can click on customer menu");
		addnewCustpg.clickCustomerMenu();   
	}

	@When("Click on customers Menu Item")
	public void click_on_customers_menu_item() {
		log.info("user can click on customer menu items");
		addnewCustpg.clickOnCustomerMenuItem();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {
		log.info("user can click on Add new button");
		addnewCustpg.clickOnAdd();
	}

	@Then("User can view Add new Customer page")
	public void user_can_view_add_new_customer_page() {
		String expectedtitles="Add a new customer / nopCommerce administration";
		String actualtitles=addnewCustpg.getPagetitles();
		 if(actualtitles.equals(expectedtitles))
	     {
			 log.info("user can view : Add new customer page");
	    	org.junit.Assert.assertTrue(true);
	     }
	     else
	     { log.warn("user can not view :Add new customer page");
	    	 org.junit.Assert.assertTrue(false);
	     }
	}

	@When("user enter customer info")
	public void user_enter_customer_info() 
	{
		//addnewCustpg.enterEmail("nehal2@gmail.com");
		log.info("user enter emailAdd");
		addnewCustpg.enterEmail(generateEmailId()+"@gmail.com");
		
		log.info("user enter password");
		addnewCustpg.enterPassword("test1");
		
		log.info("user enter firstName");
		addnewCustpg.enterFirstName("prachi");
		
		log.info("user enter LastName");
		addnewCustpg.lastname("Gupta");
		
		log.info("user select gender");
		addnewCustpg.enterGender("Female");
		
		log.info("user enter DOB");
		addnewCustpg.enterDOB("6/13/1998");
		
		log.info("user Enter CompanyName  ");
		addnewCustpg.EnterCompanyName("Codestudio");
		
		log.info("user enter Admin Content");
		addnewCustpg.enterAdminContent("Admin content");
		
		log.info("user select enter Manger of Vendor");
		addnewCustpg.enterMangerofvendor("2");
		
		
	}

	@When("Click on save button")
	public void click_on_save_button() {
		log.info("User click on add new Customer  page");
	    addnewCustpg.clickOnSave();
	}

	@Then("User can view Confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMessage ) 
	{
	   String bodytagText=driver.findElement(By.tagName("Body")).getText();
	   if(bodytagText.contains(expectedConfirmationMessage))
	   {
		   log.info("\"User can view Confirmation message : test pass");
		   org.junit.Assert.assertTrue(true);
	   }
	   else
	   {
		   log.info("User can NOT view Confirmation message : test fail");
		   org.junit.Assert.assertTrue(false);
	   }
	}
	
////////////////////////////  Search customer
	
	@When("Enter Customer Email")
	public void enter_customer_email() {
	   searcCustPage.enterEmail("victoria_victoria@nopCommerce.com");
	   log.info("user Enter Email");
	}

	@When("Click on Search button")
	public void click_on_search_button() {
	 searcCustPage.clickOnsearchbtn();
	 log.info("User Click on search button");
	}

	@Then("User Should Found Email in the Search table")
	public void user_should_found_email_in_the_search_table() 
	{
		 log.info("User can see see search email in table");
	  String expectedEmail="victoria_victoria@nopCommerce.com";
	 
	  org.junit.Assert.assertTrue(searcCustPage.searchcustomerByEmail(expectedEmail));
	
	  
	}
	
	//////////////////////// search by name and LastName ////////////
	
	@When("Enter Customer FirstName")
	public void enter_customer_first_name() {
	    searcCustPage.searchFirstName("Victoria");
	    log.info("User Enter Customer FirstName ");
	}

	@When("Enter Customer LastName")
	public void enter_customer_last_name() {
		searcCustPage.searchLastName("Terces");
		 log.info("User can Enter Customer LastName");
	}

	@Then("User Should Found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
	   String  ExpectedName="Victoria Terces";
	   if(searcCustPage.searchByname(ExpectedName)==true)
	   {   log.info("User found Name in Search table");
		   org.junit.Assert.assertTrue(true);
	   }
	   else
	   { log.warn("USer Not Found in Search Table");
		   org.junit.Assert.assertTrue(false);
	   }
	
	}
	//@After()
	public void teardown(Scenario sc) throws IOException
	{
		if(sc.isFailed()==true)
		{
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File  Destination=new File("A:\\eclipsCucumber_workspace\\firstProject_bdd\\screenshotFail\\test.png");
		 FileUtils.copyFile(scrFile, Destination);
		}
		
		System.out.println("tear down method executed");
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
	 if(scenario.isFailed())
	 {
		final byte[]   screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png", scenario.getName());
	 }
	}
	
	
	
/////////////////////////////////////////////////// after (order=number) /////////////
//	@After(order = 1)
//	public void teardown()
//	{
//		System.out.println("tear down method executed");
//		driver.quit();
//	}	
	
//	@After(order = 2) // we can use @after many times but here order of execution is in reverse order
//	         // so if you want to run @After (the second one first)
//	           // for that you have to mention higher order eg @After(order=2)
//	public void teardown2()
//	{
//		System.out.println("tear down method executed");
//		driver.quit();
//	}
//	
/////////////////////////////////////////////////// after (order=number) end /////////////
	
	
/////////////////////////////////////// beforestep  afterstep	//////////////////////
//	@AfterStep
//	public void afterStepMethodDemo()
//	{
//		System.out.println("execute after each steps "); 
//	}
//	
//	@BeforeStep
//	public void beforeStepMethod()
//	{
//		System.out.println("Execute before each steps ");
//	}

}
