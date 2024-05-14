package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseClassHB {

	
	public WebDriver driver;
	@BeforeTest
public void setup()
{
	driver=new ChromeDriver();
	driver.get("https://www.oyorooms.com/");
	driver.manage().window().maximize();
}
	public void postcondition()
	{
		driver.quit();
	}
}