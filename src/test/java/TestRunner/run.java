package TestRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;

// @RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions
(
		features = ".//Features/loginfeature.feature",
		// features = ".//Features/",    //  this will use to execute all features files
		
		// features = {".//Features/Customers.feature",".//Features/Customers.feature"}, //for specific feature file you want to execute
		//features = ".//Features/Customers.feature",
			// tags = "@sanity or @regression",  run with scenario  tagged with sanity or regression (if scenario contains any one of the value it will run)
		   // tags = "@sanity and @regression", to run scenario which having both tag sanity as well regression 
		   // tags = "@sanity and not @regression", will run Scenario which is tagged with sanity but not Regression
		
		 tags ="@sanity",
		glue = "StepDefination",
		dryRun = false,
		monochrome = true,
	
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} 
		
	//	plugin = {"pretty","html:reports/cucumberReport/reportcustomeradd.html"}
		// for all formate 	plugin = {"pretty","html:reports/cucumberReport/report.html","json:reports/cucumberReport/report.json","junit:reports/cucumberReport/report.xml"}
	//	plugin = {"pretty","json:reports/cucumberReport/report.json"}
	  //  plugin = {"pretty","junit:reports/cucumberReport/report.xml"}
		)
public class run extends AbstractTestNGCucumberTests 
{

	/* this class will be empty*/
	
}
