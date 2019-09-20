package Test;

import PageFactory.LoginPage;
import PageFactory.Logout;
import PageFactory.providerdetailspage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.File;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

 
public class Sanity_test {
 
 public WebDriver driver;
 ExtentReports extent;
 ExtentTest logger1;
 Logger logger = Logger.getLogger(Sanity_test.class);
 File file = new File("C:\\Users\\escuhao\\eclipse-workspace\\new\\ccgui_test\\src\\main\\java\\resource\\Input.txt"); 
  
 @Test
  public void openCCGUI() throws FileNotFoundException {

	  /* < --------- CC Login page loading functionality Test ------- >*/
	  
 @SuppressWarnings("resource")
 Scanner   sc = new Scanner(file);	   
 logger1 = extent.startTest("Customer Care GUI Page load Test ");
 driver.get(sc.nextLine());
 logger.info("Customer Care GUI has opended");
 logger1.log(LogStatus.PASS, "Customer Care GUI has opended");
 
 
/* < -----------   Login functionality Test  ------------->  */
 
 LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
 logger1 = extent.startTest("Login Functionality Test");
 loginPage.username.clear();
 loginPage.username.sendKeys(sc.nextLine());
 loginPage.password.clear();
 loginPage.password.sendKeys(sc.nextLine());
 loginPage.msisdnid.clear();
 loginPage.msisdnid.sendKeys(sc.nextLine());
 loginPage.click();  
 sc.close();
 logger.info("Login successful"); 
 logger1.log(LogStatus.PASS, "Login successful");
 
 /* < --------- provider details page load functionality Test ------- >*/
 logger1 = extent.startTest("Provider details page load functionality Test");
 providerdetailspage pdails = PageFactory.initElements(driver, providerdetailspage.class);
 pdails.pdetails1.click();
 String Product_Id = pdails.prefund1.getText();
 String Provider_name=pdails.pname1.getText();
 System.out.println(Product_Id + Provider_name );
 pdails.close_button.click();
 logger.info("provider details page load is successful");
 logger1.log(LogStatus.PASS, "Provider details page loading is successful");
 
 /* < --------- Page scrolling ------- >*/
 
 JavascriptExecutor jse = (JavascriptExecutor)driver;
 jse.executeScript("window.scrollBy(0,550)", "");
 pdails.descriptiontext();
 pdails.spbkt_descriptiontext();
 jse.executeScript("window.scrollBy(0,-380)", "");
 
/* < -----------   Logout functionality Test  ------------->  */
 
 logger1 = extent.startTest("Logout Functionality Test");
 Logout l_out = PageFactory.initElements(driver, Logout.class);
 l_out.lout.click();
 logger.info("Logout successful");
 logger1.log(LogStatus.PASS, "Logout successful");
  }

  @Parameters("browser")
  @BeforeMethod
  public void beforeTest(String browser) {
   
	  extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
	  extent
	                 .addSystemInfo("Environment", "Automation Testing")
	                 .addSystemInfo("User Name", "Soumik Chakraborty");
	  extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml")); 
	  
	  /* < -----------   Browser Selection  ------------->  */	  
	  
	   if(browser.equalsIgnoreCase("firefox")) {
		   extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport_fox.html", true);
		   System.setProperty("webdriver.gecko.driver", "C:\\Users\\escuhao\\Downloads\\geckodriver.exe");
		   driver = new FirefoxDriver();
	 	   Capabilities browserCap = ((RemoteWebDriver) driver).getCapabilities();
	 	   String browserName = browserCap.getBrowserName();
	 	   String browserVersion = browserCap.getVersion();
	 	   extent.addSystemInfo("Browser Name", browserName);
	 	   extent.addSystemInfo("Browser Version", browserVersion);
	  
	   }
	   else if (browser.equalsIgnoreCase("ie")) { 
		   extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport_ie.html", true);
	 	   System.setProperty("webdriver.ie.driver", "C:\\Users\\escuhao\\Desktop\\Project\\IEDriverServer.exe");
	 	  driver = new InternetExplorerDriver(); 
	 	   Capabilities browserCap = ((RemoteWebDriver) driver).getCapabilities();
	 	   String browserName = browserCap.getBrowserName();
	 	   String browserVersion = browserCap.getVersion();
	 	   extent.addSystemInfo("Browser Name", browserName);
	 	   extent.addSystemInfo("Browser Version", browserVersion);
	 	   
	   } 
	   
	   else {
		   extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport_chrome.html", true);	   
   System.setProperty("webdriver.chrome.driver", "C:\\Users\\escuhao\\Downloads\\chromedriver.exe");
   driver = new ChromeDriver();
   Capabilities browserCap = ((RemoteWebDriver) driver).getCapabilities();
   String browserName = browserCap.getBrowserName();
   String browserVersion = browserCap.getVersion();
   extent.addSystemInfo("Browser Name", browserName);
   extent.addSystemInfo("Browser Version", browserVersion);
   
	   }
	   
	   /* < -----------   Browser launch functionality Test  ------------->  */
	   
   logger1 = extent.startTest("Browser Loading Functionality Test");
   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
   driver.manage().window().maximize();
   logger.info("Browser launched");
   logger1.log(LogStatus.PASS, "Browser Launched");    
  }
  
  /* < -----------   Extent Report Generation  ------------->  */
  
  @AfterMethod
  public void getResult(ITestResult result){
  if(result.getStatus() == ITestResult.FAILURE){
  logger1.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
  logger1.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
  }else if(result.getStatus() == ITestResult.SKIP){
  logger1.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
  } 
  }
  
  /* < -----------   End of Test  ------------->  */
  
 
 
}