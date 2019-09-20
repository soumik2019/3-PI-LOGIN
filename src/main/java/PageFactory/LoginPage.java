package PageFactory;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {

	final WebDriver driver;

	@FindBy(how = How.ID, using="userName")
	public WebElement username;

	@FindBy(how = How.ID, using="password")
	public WebElement password;    

	@FindBy(how = How.ID, using="msisdnId")
	public WebElement msisdnid;
    
	@FindBy(how = How.ID, using="j_id1525140408_5ae7cb3a")
	public WebElement button;
    
    public LoginPage(WebDriver driver){

        this.driver = driver;
    }
    @Test
    public void click() {
    	button.click();
    	
    }

    }
    
