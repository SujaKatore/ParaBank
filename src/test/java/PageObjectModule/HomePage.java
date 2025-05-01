package PageObjectModule;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Locators
	@FindBy(xpath="//img[@title='ParaBank']") 
	 private WebElement paraBank;
	
	//Return
	public WebElement getparaBank()
	{
		return paraBank;
	}
	
	//Actions
	public boolean isDisplayed() 
	{
		return paraBank.isDisplayed();
		
	}

}