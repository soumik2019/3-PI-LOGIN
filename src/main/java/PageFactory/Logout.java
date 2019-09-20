package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Logout {

	final WebDriver driver;

	@FindBy(how = How.ID, using="logoutLinkCC")
	public WebElement lout;
	public Logout(WebDriver driver){

        this.driver = driver;
    }
	
}
