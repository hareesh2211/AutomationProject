package pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelBooking {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div[1]/div[1]/div/div[2]/div[6]/div/div[2]/div")
	WebElement loginorsignup;
	@FindBy(xpath="/html/body/div[1]/div/div[3]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/div/p/button")
	WebElement passwordlogin;
	 @FindBy(xpath="/html/body/div[1]/div/div[3]/div/div/div/div/div/div[2]/div[2]/div[2]/div/div/div[3]/input")
	 WebElement Phone;
	 @FindBy(xpath="/html/body/div[1]/div/div[3]/div/div/div/div/div/div[2]/div[2]/div[2]/div/div/div[4]/div/input")
     WebElement password;
	 @FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div/div/div/div/div/div[2]/div[2]/div[2]/div/div/button")
	 WebElement verify;
	 @FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div/div/div/div/div/div[2]/div[2]/div[2]/div/div/span")
	 WebElement authenticationerror;
	 @FindBy(xpath="/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div[1]/a/div/h2")
	 WebElement City;
	 @FindBy(xpath="/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div[1]/div/a[4]")
	 WebElement indiranagar;
	 
	   
	 
	public HotelBooking(WebDriver driver)
	{
		this.driver=driver;
		 
		PageFactory.initElements(driver, this);    
				  
	}
	public void login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOf(loginorsignup));
		loginorsignup.click();
		//wait.until(ExpectedConditions.visibilityOf(passwordlogin));
		passwordlogin.click();
	}

	public void setvalues(String Phn,String pwd) 
	{
		 Phone.sendKeys(Phn);
		password.sendKeys(pwd);
	}
		
		public void verify() 
		{
			verify.click(); 

		}
		public void passwordlogin()
		{
			passwordlogin.click();
		}
		
		public void refresh()
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.navigate().refresh();
			
		}
		
		/*public void authentication()
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			boolean error=authenticationerror.isEnabled();
			if(error)
			{
				driver.navigate().refresh();
				passwordlogin.click();
			}
			else {
				verify.click();
			}
		}*/
		public void locationbyhover() {
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		//implicit wait	use one wait only impplicit or explicit	
			Actions act=new Actions(driver);
			 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30)); //start of explicit 
             act.moveToElement(City).perform();
              
            wait.until(ExpectedConditions.visibilityOf(indiranagar));    
            indiranagar.click();
		}

}
