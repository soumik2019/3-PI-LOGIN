package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class providerdetailspage {
	
	final WebDriver driver;

	@FindBy(how = How.XPATH, using="//a[@id='j_id1872450351_6f9b5406:0:popup']")
	public WebElement pdetails1;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Product_refund_Id')]")
	public WebElement prefund1;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Provider_oct6_Test')]")
	public WebElement pname1;
	@FindBy(how = How.XPATH, using="//button")
	public WebElement close_button;
	@FindBy(how = How.XPATH, using="//td[@class='description']")
	List<WebElement> description1;
	@FindBy(how = How.XPATH, using="//*[@id=\"products\"]/tbody/tr[1]/td[2]")
	WebElement spbkt;
	
	
	
	
	public  providerdetailspage(WebDriver driver) {
        this.driver = driver;
    }
public void descriptiontext() {
	for ( WebElement we: description1) { 
		System.out.println(we.getText());
	}
}
	public void spbkt_descriptiontext() {
		
			System.out.println(spbkt.getText());
}
}